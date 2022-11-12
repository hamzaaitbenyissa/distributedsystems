package com.benyissa.orderservice.repositories;

import com.benyissa.orderservice.entities.Order;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface OrderRepo extends JpaRepository<Order, Long> {

    @RestResource(path = "/byCustomer")
    List<Order> findByCostumerId(@Param("id") Long id);
}
