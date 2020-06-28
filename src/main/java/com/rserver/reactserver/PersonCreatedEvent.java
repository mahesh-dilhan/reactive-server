package com.rserver.reactserver;

import org.springframework.context.ApplicationEvent;

public class PersonCreatedEvent extends ApplicationEvent {

    public PersonCreatedEvent(Object source) {
        super(source);
    }
}
