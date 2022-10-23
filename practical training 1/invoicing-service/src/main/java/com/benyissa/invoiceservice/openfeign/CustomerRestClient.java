package com.benyissa.invoiceservice.openfeign;


import com.benyissa.invoiceservice.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping(path = "/api/v1/customers/{id}")
    Customer getCustomerById(@PathVariable String id);
    @GetMapping(path = "/api/v1/customers")
    List<Customer> listCustomers();
}

