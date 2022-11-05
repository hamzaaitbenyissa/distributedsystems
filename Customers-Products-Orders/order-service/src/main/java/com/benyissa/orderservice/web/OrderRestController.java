package com.benyissa.orderservice.web;

import com.benyissa.orderservice.entities.Order;
import com.benyissa.orderservice.entities.ProductItem;
import com.benyissa.orderservice.models.Customer;
import com.benyissa.orderservice.models.Product;
import com.benyissa.orderservice.repositories.OrderRepo;
import com.benyissa.orderservice.repositories.ProductItemRepo;
import com.benyissa.orderservice.services.CustomerRestClient;
import com.benyissa.orderservice.services.ProductRestClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderRestController {

    CustomerRestClient customerRestClient;
    ProductRestClient productRestClient;
    OrderRepo orderRepo;
    ProductItemRepo productItemRepo;

//    get all details about a product
    @GetMapping("fullorder/{id}")
    Order getFullOrder(@PathVariable Long id) {
        Order order = orderRepo.findById(id).get();
        Customer customer = customerRestClient.getCustomerById(order.getCostumerId());
        order.setCustomer(customer);
        order.getOrderedProducts().forEach(
                productItem -> {
                    Product product = productRestClient.getProductById(productItem.getProductId());
                    productItem.setProduct(product);
                }
        );
        return order;
    }
}
