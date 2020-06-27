package com.rserver.reactserver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.EntityResponse.fromPublisher;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class PubHandler{

	private final PersonRepository personRepository;

	public PubHandler(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}


	public Mono<ServerResponse> getName(ServerRequest request){
		return ok().contentType(APPLICATION_JSON)
				.body(personRepository.findAll(), Person.class);
	}
}

interface PersonRepository extends ReactiveMongoRepository<Person,String>{

}


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
class Person{
	@Id
	private String id;
	private String name;
}

@Log4j2
@Component
class DataGenerator{
	private final PersonRepository personRepository;

	DataGenerator(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void writeData() throws Exception{
		var collegues = Flux.just("Xiaoyuan","Lloyd","Bing Jie","Swapnik","Reni","Vlad","Murali","Naren","Kishore","SriDevi")
				.map(name -> new Person(null, name))
				.flatMap(this.personRepository::save);

		this.personRepository
				.deleteAll()
				.thenMany(collegues)
				.thenMany(this.personRepository.findAll())
				.subscribe(log::info);
	}

}