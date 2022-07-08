package com.postgres_backend.controller;

import com.postgres_backend.Address;
import com.postgres_backend.User;
import com.postgres_backend.UserService;
import com.postgres_backend.dto.UserDto;
import com.postgres_backend.mapper.UserDtoMapper;
import com.postgres_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static com.postgres_backend.mapper.UserDtoMapper.UserDtoToEntity;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@GetMapping
	public List<UserDto> getAllUsers()
	{
		var users = userService.getAll();
		return users.stream().map(u -> UserDtoMapper.UserEntityToDto(u)).collect(Collectors.toList());
	}

	@PostMapping
	public UserDto createUser(@RequestBody UserDto user)
	{
		return userService.saveUser(UserDtoToEntity(user));
	}

	@PostMapping("/entity")
	public UserDto createUserByEntity(@RequestBody User user)
	{
		return userService.saveUser(user);
	}

	@PostMapping("/address")
	public Address createAddressByEntity(@RequestBody Address address)
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
