package com.nttdata.bootcamp.webflux.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.nttdata.bootcamp.webflux.dto.Person;

import reactor.core.publisher.Flux;

@Service
public class PersonService implements PersonI {

	@Override
	public Flux<Person> persons() {
		
		WebClient webClient = WebClient.create("http://localhost:8087");
		
		Flux<Person> person1 = webClient.get().uri("/person-list-1").retrieve().bodyToFlux(Person.class);
		
		Flux<Person> person2 = webClient.get().uri("/person-list-2").retrieve().bodyToFlux(Person.class);
		
		Flux<Person> person3 = webClient.get().uri("/person-list-3").retrieve().bodyToFlux(Person.class);
		
		Flux<Person> person4 = webClient.get().uri("/person-list-4").retrieve().bodyToFlux(Person.class);
		
		Flux<Person> personsListStartsA = Flux.concat(person1,person2,person3,person4).
									filter(person->person.getFirstName().
									startsWith("A"));
		
		personsListStartsA.subscribe(person->System.out.println(person.getLastName()+", "+person.getFirstName()+" tiene " + person.getAge() + " años"));
		
		Flux<Person> personsList = Flux.concat(person1, person2, person3, person4);
		
		return personsList;
	}

}
