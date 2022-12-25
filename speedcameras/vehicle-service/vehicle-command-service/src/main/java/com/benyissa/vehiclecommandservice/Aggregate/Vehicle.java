package com.benyissa.vehiclecommandservice.Aggregate;

import com.benyissa.commonapi.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class Vehicle {

    @AggregateIdentifier
    private String vehicleId ;
    private String registrationNumber ;
    private   VehicleType type;
    private String  brand ;
    private String model ;
    private int fiscalPower ;
    private String ownerName;
    private String ownerNationalIdCard;
    private String ownerEmail;
    private String ownerPhoneNumber;
    private String ownerAddress;
    public Vehicle() {
    }

    @CommandHandler
    public Vehicle(CreateVehicleCommand command){
        AggregateLifecycle.apply(new VehicleCreatedEvent( command.getId(),
                command.getPayload())
        );
    }

    @EventSourcingHandler
    public void on(VehicleCreatedEvent event){
        this.vehicleId= event.getId();
        this.ownerName = event.getPayload().getOwnerName();
        this.ownerAddress = event.getPayload().getOwnerAddress();
        this.ownerPhoneNumber = event.getPayload().getOwnerPhoneNumber();
        this.ownerNationalIdCard = event.getPayload().getOwnerNationalIdCard() ;
        this.registrationNumber = event.getPayload().getRegistrationNumber();
        this.type =event.getPayload().getType();
        this.brand =event.getPayload().getBrand();
        this.model=event.getPayload().getModel();
        this.fiscalPower =event.getPayload().getFiscalPower();
    }

    @CommandHandler
    public void handle(UpdateVehicleOwnerCommand command){
        AggregateLifecycle.apply(new UpdateVehicleOwnerCommand( command.getId(),
                command.getPayload())
        );
    }

    @EventSourcingHandler
    public void on(VehicleOwnerUpdatedEvent event){

        this.ownerName = event.getPayload().getOwnerName();
        this.ownerAddress = event.getPayload().getOwnerAddress();
        this.ownerPhoneNumber = event.getPayload().getOwnerPhoneNumber();
        this.ownerNationalIdCard = event.getPayload().getOwnerNationalIdCard() ;
        this.registrationNumber = event.getPayload().getRegistrationNumber();

    }



}
