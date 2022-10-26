package com.benyissa.costumerservice.repositories;


import com.benyissa.costumerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,String> {

}
