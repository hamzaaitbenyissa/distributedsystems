package com.benyissa.orderservice.repositories;

import com.benyissa.orderservice.entities.Order;
import com.benyissa.orderservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductItemRepo extends JpaRepository<ProductItem, Long> {
}
