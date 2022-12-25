package com.benyissa.speedcamcommandservice.Aggregate;

import com.benyissa.commonapi.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Aggregate
public class RadarAggregate {

    @AggregateIdentifier
    private String radarId ;
    private  String name ;
    private double  longitude ;
    private double latitude ;
    private double altitude ;
    private  int maxSpeed ;
    private String  roadDesignation ;
    private RadarStatus radarStatus ;

    List<OverSpeedMember> overSpeedMembers = new ArrayList<>();
    public RadarAggregate() {
    }

    @CommandHandler
    public void handle(ChangeRadarStatusCommand command){
        AggregateLifecycle.apply(new RadarStatusChangedEvent(
                command.getId(),
                command.getPayload()
        ));
    }
    @EventSourcingHandler
    public void on(RadarStatusChangedEvent event){
        this.radarId=event.getId();
        this.radarStatus=event.getPayload();
    }
    @CommandHandler
    public RadarAggregate(CreateNewRadarCommand command){
        AggregateLifecycle.apply(new RadarCreatedEvent( command.getId(),
                command.getPayload())
        );
    }

    @EventSourcingHandler
    public void on(RadarCreatedEvent event){
        this.radarId= event.getId();
        this.name= event.getPayload().getName();
        this.latitude =event.getPayload().getLatitude();
        this.longitude =event.getPayload().getLongitude();
        this.maxSpeed=event.getPayload().getMaxSpeed();
        this.radarStatus =event.getPayload().getRadarStatus();
        this.roadDesignation= event.getPayload().getRoadDesignation();
    }

    @CommandHandler
    public void UpdateRadarAggregate(UpdateRadarCommand command){
        AggregateLifecycle.apply(new RadarCreatedEvent( command.getId(),
                command.getPayload())
        );
    }

    @EventSourcingHandler
    public void on(UpdateRadarEvent event){
        this.name= event.getPayload().getName();
        this.latitude =event.getPayload().getLatitude();
        this.longitude =event.getPayload().getLongitude();
        this.maxSpeed=event.getPayload().getMaxSpeed();
        this.radarStatus =event.getPayload().getRadarStatus();
        this.roadDesignation= event.getPayload().getRoadDesignation();
    }
//
//    @CommandHandler
//    public void NewVehicleOverSpeedDetection(NewVehicleOverSpeedDetectionCommand command){
//        command.getPayload().setOverSpeedId(UUID.randomUUID().toString());
//        command.getPayload().setRadarMaxSpeed(this.maxSpeed);
//        command.getPayload().setRadarLongitude(this.longitude);
//        command.getPayload().setRadarLongitude(this.latitude);
//        command.getPayload().setRadarAltitude(this.altitude);
//        command.getPayload().setRadarId(this.radarId);
//
//
//                AggregateLifecycle.apply(
//                        new VehicleOverSpeedDetectedEvent( command.getId(),
//                        command.getPayload(), UUID.randomUUID().toString())
//                );
//    }

//    @EventSourcingHandler
//    public void on(VehicleOverSpeedDetectedEvent event){
//        System.out.println("+++++++++++++++++++++++++");
//        OverSpeedMember overSpeedMember = new OverSpeedMember() ;
//        overSpeedMember.setVehicleSpeed(event.getPayload().getVehicleSpeed());
//        overSpeedMember.setId(event.getId());
//        overSpeedMember.setVehicleRegistrationNumber(event.getPayload().getVehicleRegistrationNumber());
//        overSpeedMembers.add(overSpeedMember);
//
//    }


    @CommandHandler
    public void handle(NewVehicleOverSpeedDetectionCommand command){
        command.getPayload().setOverSpeedId(UUID.randomUUID().toString());

        if(command.getPayload().getVehicleSpeed()>this.maxSpeed)
        AggregateLifecycle.apply(new VehicleOverSpeedDetectedEvent(
                command.getId(),
                command.getPayload(),
                UUID.randomUUID().toString()
        ));
    }
    @EventSourcingHandler
    public void on(VehicleOverSpeedDetectedEvent event){
        this.radarId=event.getId();
        OverSpeedMember overSpeedMember =new OverSpeedMember();
        overSpeedMember.setId(UUID.randomUUID().toString());
        overSpeedMember.setVehicleRegistrationNumber(event.getPayload().getVehicleRegistrationNumber());
        overSpeedMember.setVehicleSpeed(event.getPayload().getVehicleSpeed());
        this.overSpeedMembers.add(overSpeedMember);
    }
}
