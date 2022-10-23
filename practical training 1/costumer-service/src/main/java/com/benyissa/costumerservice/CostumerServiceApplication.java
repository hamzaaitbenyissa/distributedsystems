package com.benyissa.costumerservice;

import com.benyissa.costumerservice.DTOs.CustomerRequestDTO;
import com.benyissa.costumerservice.services.CustomerService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CostumerServiceApplication {

    @Autowired
    CustomerService customerService;

    public static void main(String[] args) {
        SpringApplication.run(CostumerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            Faker faker = new Faker();
            for (int i = 0; i < 20; i++) {
                String name = faker.name().fullName();
                String email = faker.internet().emailAddress();
                customerService.addCustomer(new CustomerRequestDTO(name, email));
            }
        };
    }


}
