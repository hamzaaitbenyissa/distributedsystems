package com.benyissa.orderservice.entities;

import com.benyissa.orderservice.enums.Status;
import com.benyissa.orderservice.models.Customer;
import org.springframework.data.rest.core.config.Projection;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Projection(types = Order.class, name = "fullOrder")
public interface OrderProjection {


    Long getId();

    Status getStatus();

    Long getCostumerId();

    Date getCreatedAt();

    Date getUpdatedAt();

    Double getTotal();

}
