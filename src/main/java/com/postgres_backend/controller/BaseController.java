package com.postgres_backend.controller;

import com.postgres_backend.model.Base;
import com.postgres_backend.model.Employee;
import com.postgres_backend.model.Student;
import com.postgres_backend.repository.BaseRepository;
import com.postgres_backend.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseController {

	@Autowired
	private BaseRepository<Employee> baseRepository;

	@Autowired
	private BaseRepository<Student> studentRepository;

	@GetMapping(path = "/employee")
	public List<Employee> getEmployeeList(@RequestParam List<Long> ids)
	{
		return baseRepository.find(ids);
	}

	@GetMapping(path = "/student")
	public List<Student> getStudentList(@RequestParam List<Long> ids)
	{
		return studentRepository.find(ids);
	}

}
