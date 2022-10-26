package com.benyissa.costumerservice.services;

import com.benyissa.costumerservice.DTOs.CustomerRequestDTO;
import com.benyissa.costumerservice.DTOs.CustomerResponseDTO;
import com.benyissa.costumerservice.entities.Customer;
import com.benyissa.costumerservice.exceptions.CustomerNotFoundException;
import com.benyissa.costumerservice.mappers.CustomerMapper;
import com.benyissa.costumerservice.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    CustomerMapper customerMapper;


    @Override
    public List<CustomerResponseDTO> listCustomers() {
        return customerRepo.findAll().stream().map(customer -> customerMapper.customerToCustomerResponseDTO(customer)).collect(Collectors.toList());
    }

    @Override
    public CustomerResponseDTO getCustomerById(String id) {
        Customer customer = customerRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
        return customerMapper.customerToCustomerResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO addCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customertosave = customerMapper.customerReuestDTOTocustomer(customerRequestDTO);
        customertosave.setId(UUID.randomUUID().toString());
        customerRepo.save(customertosave);
        return customerMapper.customerToCustomerResponseDTO(customertosave);
    }

    @Override
    public CustomerResponseDTO updateCustomer(String id, CustomerRequestDTO customerRequestDTO) {
        Customer customertoupdate = customerRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
        customertoupdate.setEmail(customerRequestDTO.getEmail());
        customertoupdate.setName(customerRequestDTO.getName());
        return customerMapper.customerToCustomerResponseDTO(customertoupdate);
    }

    @Override
    public void deleteCustomer(String id) {
        Customer customertodelete = customerRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
        customerRepo.delete(customertodelete);
    }


}
