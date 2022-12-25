package com.benyissa.vehiclequeryservice.repositories;

import com.benyissa.vehiclequeryservice.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,String> {
}
