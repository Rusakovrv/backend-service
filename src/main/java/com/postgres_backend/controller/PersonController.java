package com.postgres_backend.controller;

import com.postgres_backend.model.Person;
import com.postgres_backend.model.Place;
import com.postgres_backend.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PersonController {

	private final PersonService personService;


	@PostMapping(value = "/person")
	public Long createPerson(@RequestBody Person person)
	{
		return personService.createPerson(person).getId();
	}

	@PostMapping(value = "/place")
	public Long createPlace(@RequestBody Place place)
	{
		return personService.createPlace(place).getId();
	}

}
