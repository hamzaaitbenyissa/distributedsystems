package com.benyissa.billingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController

public class ConsulConfigRestController {
    @Autowired
    MyConsulConfig myConsulConfig;
    @Autowired
    MyVaultConfig myVaultConfig;

    @GetMapping("/myConfig")
    public Map<String, Object> myConfig() {
        return Map.of("consul config ", myConsulConfig, "vault config", myVaultConfig);
    }
}
