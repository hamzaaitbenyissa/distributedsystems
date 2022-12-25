package com.benyissa.speedcamqueryservice.controller;

import com.benyissa.commonapi.*;

import com.benyissa.speedcamqueryservice.entities.*;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/radars")
public class RadarQueryController {

    @Autowired
    public QueryGateway queryGateway;


    @GetMapping
    public CompletableFuture<List<Radar>> radarList() {
        return queryGateway.query(new GetAllRadarsQuery(), ResponseTypes.multipleInstancesOf(Radar.class));
    }

    @GetMapping("/{id}")
    public CompletableFuture<Radar> radar(@PathVariable String id) {
        return queryGateway.query(new GetRadarById(id), ResponseTypes.instanceOf(Radar.class));
    }

    @GetMapping("/speed/{id}")
    public CompletableFuture<List<OverSpeedDetection>> overSpeedByRadar(@PathVariable String id) {
        return queryGateway.query(new GetOverSpeedDetectionByRadar(id), ResponseTypes.multipleInstancesOf(OverSpeedDetection.class));
    }
}
