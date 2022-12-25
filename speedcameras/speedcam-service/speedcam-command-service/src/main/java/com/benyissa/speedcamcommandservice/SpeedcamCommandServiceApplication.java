package com.benyissa.speedcamcommandservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpeedcamCommandServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpeedcamCommandServiceApplication.class, args);
        System.out.println("speed cam is running ... ");
    }

}
