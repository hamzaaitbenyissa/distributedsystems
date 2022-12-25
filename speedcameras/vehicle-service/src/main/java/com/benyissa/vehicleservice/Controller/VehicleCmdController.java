package com.benyissa.vehicleservice.Controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.benyissa.commonapi.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/vehicle/commands")
@AllArgsConstructor
@NoArgsConstructor
public class VehicleCmdController {

    @Autowired
    CommandGateway commandGateway;

    @PostMapping("/create")
    public CompletableFuture<String> CreateVehicle(@RequestBody VehicleRequestDTO vehicleRequestDTO) {
        return commandGateway.send(new CreateVehicleCommand(UUID.randomUUID().toString(), vehicleRequestDTO));
    }

    @PutMapping("/update")
    public CompletableFuture<String> UpdateOwner(@RequestBody UpdateVehicleOwnerRequestDTO updateVehicleOwnerRequestDTO) {
        return commandGateway.send(new UpdateVehicleOwnerCommand(updateVehicleOwnerRequestDTO.getOwnerNationalIdCard(), updateVehicleOwnerRequestDTO));
    }

}
