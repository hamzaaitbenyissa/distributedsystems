package com.benyissa.speedcamqueryservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OverSpeedDetection {
    @Id
    private String id;
    private String vehicleRegistrationNumber;
    private int vehicleSpeed;
    private Date date ;

    @ManyToOne
    @JsonIgnore
    private Radar radar;
}
