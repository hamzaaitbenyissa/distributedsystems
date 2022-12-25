package com.benyissa.speedcamcommandservice.Aggregate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.EntityId;

@Data @NoArgsConstructor @AllArgsConstructor
public class OverSpeedMember {
    @EntityId
    private String id;
    private String vehicleRegistrationNumber;
    private int vehicleSpeed;
}
