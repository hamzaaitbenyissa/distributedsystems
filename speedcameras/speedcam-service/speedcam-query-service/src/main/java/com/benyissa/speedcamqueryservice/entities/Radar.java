package com.benyissa.speedcamqueryservice.entities;

import com.benyissa.commonapi.RadarStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Radar implements Serializable {

    @Id
    private String Id ;
    private  String name ;
    private double  longitude ;
    private double latitude ;
    private double altitude ;
    private  int maxSpeed ;
    private String  roadDesignation ;
    private RadarStatus radarStatus ;
    @OneToMany(mappedBy = "radar")
    @JsonIgnore
    List<OverSpeedDetection> overSpeedDetections = new ArrayList<>();
}
