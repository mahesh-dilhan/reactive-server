package com.rserver.reactserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.blockhound.BlockHound;
import reactor.core.publisher.Mono;


import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
public class ReactServerApplication {

	public static void main(String[] args) {
		//BlockHound.install();
		SpringApplication.run(ReactServerApplication.class, args);
	}

	@Bean
	RouterFunction<ServerResponse> routes(PubHandler pub){
		return route(
				GET("/author"),req->ok().body(Mono.just("Mahesh"),String.class))
				.andRoute(GET("/colleagues").and(accept(MediaType.APPLICATION_JSON)),pub::getColleagues)
				.andRoute(GET("/colleague/{name}").and(accept(MediaType.APPLICATION_JSON)),pub::getColleague)
				.andRoute(POST("/colleague").and(accept(MediaType.APPLICATION_JSON)),pub::saveCollegue)
				;
	}
}