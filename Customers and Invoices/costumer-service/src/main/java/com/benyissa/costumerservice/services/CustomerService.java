package com.benyissa.costumerservice.services;

import com.benyissa.costumerservice.DTOs.CustomerRequestDTO;
import com.benyissa.costumerservice.DTOs.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {


    List<CustomerResponseDTO> listCustomers();

    CustomerResponseDTO getCustomerById(String id);

    CustomerResponseDTO addCustomer(CustomerRequestDTO customerRequestDTO);


    CustomerResponseDTO updateCustomer(String id, CustomerRequestDTO customerRequestDTO);

    void deleteCustomer(String id);
}
