package com.postgres_backend.service;

import com.postgres_backend.model.Person;
import com.postgres_backend.model.Place;
import com.postgres_backend.repository.PersonRepository;
import com.postgres_backend.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

	private final PersonRepository personRepository;

	private final PlaceRepository placeRepository;

	public Person createPerson(Person person)
	{
		if(person.getPlaces()!=null) {
			person.getPlaces().forEach(p ->
			{
				p.setPerson(person);
			});
		}
		return personRepository.save(person);
	}

	public Place createPlace(Place place)
	{
		return placeRepository.save(place);
	}
}
