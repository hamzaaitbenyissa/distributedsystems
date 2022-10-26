package com.benyissa.invoiceservice;

import com.benyissa.invoiceservice.DTOs.InvoiceRequestDTO;
import com.benyissa.invoiceservice.openfeign.CustomerRestClient;
import com.benyissa.invoiceservice.services.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class InvoiceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvoiceServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(InvoiceService invoiceService, CustomerRestClient customerRestClient) {
        return args -> {
            customerRestClient.listCustomers().stream()
                    .forEach(customer ->
                    {
                        for (int i = 0; i < new Random().nextInt(10); i++) {
                            BigDecimal amount = BigDecimal.valueOf(new Random().nextDouble() * 100000);
                            invoiceService.addInvoice(new InvoiceRequestDTO(amount, customer.getId()));
                        }
                    });
        };
    }

}
