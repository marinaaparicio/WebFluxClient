package com.nttdata.bootcamp.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nttdata.bootcamp.webflux.dto.Person;
import com.nttdata.bootcamp.webflux.services.PersonService;

import reactor.core.publisher.Flux;

@Controller
public class PersonListController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping("/person-list")
	public String personList(final Model model) {
		final Flux<Person> personList = personService.persons();
		model.addAttribute("personList", personList);
		return "personList";
	}

}
