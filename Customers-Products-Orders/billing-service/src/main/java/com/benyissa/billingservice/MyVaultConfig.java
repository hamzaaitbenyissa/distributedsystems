package com.benyissa.billingservice;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "user")
@Data
public class MyVaultConfig {
    private String username;
    private String password;
}
