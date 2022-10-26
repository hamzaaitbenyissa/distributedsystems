package com.benyissa.invoiceservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Invoice {

    @Id
    private String id;
    private Date date;
    //   We are dealing with money broo, so stop using double here
    private BigDecimal amount;
    private String customerId;
    //We are using @Transient to tell jpa, please don't care about this entity, It's not yours anymore lol
    @Transient
    private Customer customer;

}
