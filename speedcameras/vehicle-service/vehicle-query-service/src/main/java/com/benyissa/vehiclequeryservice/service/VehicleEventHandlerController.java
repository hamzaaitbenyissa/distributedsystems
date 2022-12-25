package com.benyissa.vehiclequeryservice.service;

import lombok.NoArgsConstructor;
import com.benyissa.commonapi.*;
import com.benyissa.vehiclequeryservice.entities.Owner;
import com.benyissa.vehiclequeryservice.entities.Vehicle;
import com.benyissa.vehiclequeryservice.mappers.VehicleMapper;
import com.benyissa.vehiclequeryservice.repositories.OwnerRepository;
import com.benyissa.vehiclequeryservice.repositories.VehicleRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
public class VehicleEventHandlerController {

    @Autowired
    private VehicleRepository vehicleRepository ;

    @Autowired
    private VehicleMapper vehicleMapper ;

    @Autowired
    private OwnerRepository ownerRepository;



    @EventHandler
    public void  on(VehicleCreatedEvent  event){
        System.out.println("*********************"+event.getPayload().getOwnerAddress());
        Vehicle vehicle = vehicleMapper.vehicleDtoToVehicle(event.getPayload());
        vehicle.setId(event.getId());
        Owner owner = new Owner() ;
        owner.setId(event.getId());
        owner.setOwnerAddress(event.getPayload().getOwnerAddress());
        owner.setOwnerEmail(event.getPayload().getOwnerEmail());
        owner.setOwnerName(event.getPayload().getOwnerName());
        owner.setOwnerNationalIdCard(event.getPayload().getOwnerNationalIdCard());
        owner.setOwnerPhoneNumber(event.getPayload().getOwnerPhoneNumber());
        Owner saved =ownerRepository.save(owner);
        vehicle.setOwner(saved);
        vehicleRepository.save(vehicle);
    }

    @QueryHandler
    public List<Owner> on(GetAllVehiclesQuery getAllVehiclesQuery){
         List<Owner> list =ownerRepository.findAll();
       return list;
    }


}
