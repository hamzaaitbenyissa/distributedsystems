package com.benyissa.speedcamcommandservice.Controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.benyissa.commonapi.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/commands")
@AllArgsConstructor
@NoArgsConstructor
public class RadarCmdController {

    @Autowired
    CommandGateway commandGateway ;

    @PostMapping("/create")
    public CompletableFuture<String> CreateRadar(@RequestBody RadarDTO radarDTO){
        return commandGateway.send( new CreateNewRadarCommand(UUID.randomUUID().toString(),radarDTO));
    }

    public CompletableFuture<String> UpdateRadar (@RequestBody RadarDTO radarDTO){
        return  commandGateway.send(new UpdateRadarCommand(radarDTO.getRadarId(),radarDTO));
    }
    @PostMapping("/radar/changeStatus")
    public CompletableFuture<String> changeRadarStatus(@RequestBody ChangeRadarStatusRequestDTO request){
        return this.commandGateway.send(new ChangeRadarStatusCommand(
                request.getRadarId(),
                request.getRadarStatus()
        ));
    }

    @PostMapping("/radar/overSpeed")
    public CompletableFuture<String> newOverSpeed(@RequestBody OverSpeedRequestDTO request){
        CompletableFuture<String> cmd1 = this.commandGateway.send(new NewVehicleOverSpeedDetectionCommand(
                request.getRadarId(),
                request
        ));
        return cmd1;
    }

}
