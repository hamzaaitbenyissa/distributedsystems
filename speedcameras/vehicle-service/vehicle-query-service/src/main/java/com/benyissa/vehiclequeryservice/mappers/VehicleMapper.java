package com.benyissa.vehiclequeryservice.mappers;

import com.benyissa.commonapi.VehicleRequestDTO;
import com.benyissa.vehiclequeryservice.entities.Vehicle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleMapper {
    Vehicle vehicleDtoToVehicle(VehicleRequestDTO vehicleRequestDTO) ;

}
