package com.rserver.reactserver;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class RSocketPersonHandler {

    private final PersonRepository personRepository;

    public RSocketPersonHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @MessageMapping("rsock-collegues")
    Flux<Person> getrname(){
        return personRepository.findAll();
    }
}
