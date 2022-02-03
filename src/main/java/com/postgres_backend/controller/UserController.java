package com.postgres_backend.controller;

import com.postgres_backend.Address;
import com.postgres_backend.User;
import com.postgres_backend.UserService;
import com.postgres_backend.dto.UserDto;
import com.postgres_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static com.postgres_backend.mapper.UserDtoMapper.UserDtoToEntity;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> getAllUsers()
	{
		return userService.getAll();
	}

	@PostMapping
	public User createUser(UserDto user)
	{
		return userService.saveUser(UserDtoToEntity(user));
	}

	@PostMapping("/entity")
	public User createUserByEntity(User user)
	{
		return userService.saveUser(user);
	}

	@PostMapping("/address")
	public Address createAddressByEntity(Address address)
	{
		return userService.saveAddress(address);
	}

	@PatchMapping
	public User updateUser(User user)
	{
		try {
			return userService.updateUser(user);
		}
		catch (Exception ex)
		{
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "entity not found"
			);
		}
	}
}
