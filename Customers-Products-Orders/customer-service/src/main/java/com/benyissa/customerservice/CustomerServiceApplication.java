package com.benyissa.customerservice;

import com.benyissa.customerservice.entities.Customer;
import com.benyissa.customerservice.repositories.CustomerRepo;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(CustomerRepo customerRepo) {
        return args -> {
            Faker faker = new Faker();
            for (int i = 0; i < 20; i++) {
                String name = faker.name().fullName();
                String email = faker.internet().emailAddress();
                customerRepo.save(Customer.builder().email(email).name(name).build());
            }

            System.out.println("Yeeeeep 😜 mission done ✔");
        };
    }

}
