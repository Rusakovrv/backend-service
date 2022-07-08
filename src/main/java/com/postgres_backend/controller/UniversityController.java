package com.postgres_backend.controller;

import com.postgres_backend.model.University;
import com.postgres_backend.repository.UniversityRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {

	@Autowired
	private UniversityRepository universityRepository;

	@GetMapping
	public List<University> getUniversities()
	{
		return universityRepository.findAll();
	}

	@PostMapping
	public University createUniversity(@RequestBody University university)
	{
		return universityRepository.save(university);
	}

	@PostMapping(value = "/empty")
	public University createEmptyUniversity()
	{
		var university = new University();
		university.setType(null);
		university.setName(null);
		return universityRepository.saveAndFlush(university);
	}

}
