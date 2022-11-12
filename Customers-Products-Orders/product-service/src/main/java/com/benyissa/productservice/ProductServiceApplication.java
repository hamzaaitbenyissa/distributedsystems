package com.benyissa.productservice;

import com.benyissa.productservice.entities.Product;
import com.benyissa.productservice.repositories.ProductRepo;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(ProductRepo productRepo) {
        return args -> {
//            let's create 20 fake products
            Faker faker = new Faker();
            for (int i = 0; i < 20; i++) {
                String name = faker.commerce().productName();
                productRepo.save(Product.builder().name(name).price(Math.random() * 101 + 23).quantityStock(new Random().nextInt(0, 100)).build());
            }
        };
    }
}
