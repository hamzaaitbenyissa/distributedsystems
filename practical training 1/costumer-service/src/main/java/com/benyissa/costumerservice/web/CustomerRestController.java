package com.benyissa.costumerservice.web;

import com.benyissa.costumerservice.DTOs.CustomerRequestDTO;
import com.benyissa.costumerservice.DTOs.CustomerResponseDTO;
import com.benyissa.costumerservice.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class CustomerRestController {

    final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //    return all costumers
    @GetMapping("/customers")
    public List<CustomerResponseDTO> customers() {
        return customerService.listCustomers();
    }

    //    get a customer by id
    @GetMapping("/customers/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable String id) {
        return customerService.getCustomerById(id);
    }

    //    create a new customer
    @PostMapping("/customers")
    public CustomerResponseDTO saveCustomer(CustomerRequestDTO customerRequestDTO) {
        return this.customerService.addCustomer(customerRequestDTO);
    }

    @PutMapping("/customers/{id}")
    public CustomerResponseDTO updateCustomer(@PathVariable String id, @RequestBody CustomerRequestDTO customerRequestDTO) {
        return customerService.updateCustomer(id, customerRequestDTO);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable String id) {
        this.customerService.deleteCustomer(id);
    }

}
