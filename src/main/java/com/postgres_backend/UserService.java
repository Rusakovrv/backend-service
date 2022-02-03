package com.postgres_backend;

import com.postgres_backend.repository.AddressRepository;
import com.postgres_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	public User saveUser(User user)
	{
		return userRepository.save(user);
	}

	public Address saveAddress(Address address)
	{
		return addressRepository.save(address);
	}

	public User updateUser(User user) throws Exception {
		if(userRepository.existsById(CompositeID.builder().userId(user.getUserId()).userVersion(user.getUserVersion()).build()))
		{
			return userRepository.save(user);
		}
		else
		{
			throw new Exception();
		}

	}

	public List<User> getAll()
	{
		return userRepository.findAll();
	}
}
