package com.benyissa.invoiceservice.repositories;


import com.benyissa.invoiceservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepo extends JpaRepository<Invoice,String> {

    List<Invoice> findByCustomerId(String customerId);

}
