package com.benyissa.orderservice;

import com.benyissa.orderservice.entities.Order;
import com.benyissa.orderservice.entities.ProductItem;
import com.benyissa.orderservice.enums.Status;
import com.benyissa.orderservice.models.Customer;
import com.benyissa.orderservice.models.Product;
import com.benyissa.orderservice.repositories.OrderRepo;
import com.benyissa.orderservice.repositories.ProductItemRepo;
import com.benyissa.orderservice.services.CustomerRestClient;
import com.benyissa.orderservice.services.ProductRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(ProductItemRepo productItemRepo, OrderRepo orderRepo, CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
        return args -> {
            List<Customer> customers = customerRestClient.listCustomers().getContent().stream().toList();
            List<Product> products = productRestClient.listProducts().getContent().stream().toList();
            Random random = new Random();

            for (int k = 0; k < 15; k++) {
                Order newOrder = Order.builder()
                        .costumerId(customers.get(random.nextInt(0, customers.size())).getId())
                        .status(random.nextBoolean()? Status.PENDING :Status.COMPLETED)
                        .createdAt(new Date())
                        .updatedAt(new Date())
                        .build();
                orderRepo.save(newOrder);

                for (int i = 0; i < products.size(); i++) {
                    if (random.nextBoolean()) {
                        ProductItem newProductItem = ProductItem.builder()
                                .order(newOrder)
                                .productId(products.get(i).getId())
                                .quantity(random.nextInt(3))
                                .discount(random.nextDouble(100))
                                .build();
                        productItemRepo.save(newProductItem);
                    }
                }
            }
        };

    }
}
