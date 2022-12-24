package com.benyissa.commonapi.commandes;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public  abstract class BaseCommand <T>{
  @TargetAggregateIdentifier

   @Getter
    protected T id ;

  public BaseCommand(T id) {
    this.id = id;
  }
}
