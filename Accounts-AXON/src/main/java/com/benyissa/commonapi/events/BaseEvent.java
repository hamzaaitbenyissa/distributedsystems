package com.benyissa.commonapi.events;

import lombok.Getter;

public abstract class BaseEvent <T>{
    @Getter
    protected T id ;
    public BaseEvent(T id) {
        this.id = id;
    }
}
