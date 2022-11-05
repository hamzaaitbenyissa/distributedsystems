package com.benyissa.productservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = Product.class, name = "fullProduct")
public interface ProductProjection {

    public Long getId();

    public String getName();

    public Integer getQuantity();

    public Double getPrice();

}
