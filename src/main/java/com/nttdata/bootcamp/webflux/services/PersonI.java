package com.nttdata.bootcamp.webflux.services;

import com.nttdata.bootcamp.webflux.dto.Person;

import reactor.core.publisher.Flux;

public interface PersonI {
	
	public Flux<Person> persons();

}
