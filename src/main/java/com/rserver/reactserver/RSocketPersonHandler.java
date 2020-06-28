/**
 * This is RSocket Implementation
 */
package com.rserver.reactserver;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Controller
public class RSocketPersonHandler {

    private final PersonRepository personRepository;

    public RSocketPersonHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @MessageMapping("rsock-colleagues")
    Flux<Person> getRsockColleagues(){
        return personRepository.findAll();
    }

    @MessageMapping("rsock-colleague")
    Mono<Person> getRSockColleague(String name){
        return personRepository.findByName(name);
    }

    @MessageMapping("rsock-save-colleague")
    Mono<Person> saveRSockColleague(Person person){
        return personRepository.save(person);
    }
}
