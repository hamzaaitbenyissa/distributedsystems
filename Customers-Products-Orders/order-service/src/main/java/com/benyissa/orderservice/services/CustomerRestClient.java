package com.benyissa.orderservice.services;


import com.benyissa.orderservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {

    //    get a customer by id
    @GetMapping(path = "/customers/{id}?projection=fullCustomer")
    Customer getCustomerById(@PathVariable Long id);

    //    get list of customers
    @GetMapping(path = "/customers?projection=fullCustomer")
    PagedModel<Customer> listCustomers();
}
