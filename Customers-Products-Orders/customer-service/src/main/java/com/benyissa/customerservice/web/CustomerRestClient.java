package com.benyissa.customerservice.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CustomerRestClient {
    @Value("${global.params.p1}")
    String p1;
    @Value("${global.params.p2}")
    String p2;

    @GetMapping("/params")
    Map map() {
        return Map.of(p1, "p1", p2, "p2");
    }

}
