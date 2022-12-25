package com.benyissa.vehiclequeryservice.repositories;

import com.benyissa.vehiclequeryservice.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,String> {
}
