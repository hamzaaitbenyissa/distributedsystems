package com.benyissa.orderservice.entities;


import com.benyissa.orderservice.models.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long productId;
    Integer quantity;
    Double discount;
    Double price;
    Double amount;
    @ManyToOne
    @JsonIgnore
    Order order;

    // we can do that using dto , this annotation tells JPA please don't care about this attribute
    @Transient
    Product product;

    public Double getAmount() {
        return price * (1 - discount) * quantity;
    }
}
