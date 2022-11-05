package com.benyissa.orderservice.entities;


import com.benyissa.orderservice.enums.Status;
import com.benyissa.orderservice.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orders")
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Status status;
    Long costumerId;
    Date createdAt;
    Date updatedAt;
    @OneToMany(mappedBy = "order")
    List<ProductItem> orderedProducts;

    // we can do that using dto , this annotation tells JPA please don't care about this attribute
    @Transient
    Customer customer;
}
