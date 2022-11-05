package com.benyissa.orderservice.models;

import lombok.Data;

@Data
public class Product {
    Long id;
    String name;
    Integer quantityStock;
    Double price;
}
