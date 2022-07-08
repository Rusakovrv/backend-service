package com.postgres_backend;

import com.postgres_backend.dto.UserAddressRelationshipDto;
import com.postgres_backend.dto.UserDto;
import com.postgres_backend.mapper.UserDtoMapper;
import com.postgres_backend.repository.AddressRepository;
import com.postgres_backend.repository.UserAddressRelationshipRepository;
import com.postgres_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserAddressRelationshipRepository userAddressRelationshipRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Transactional
	public UserDto saveUser(User user)
	{
		if(user.getId()!=null)
		{
			var userFromDbOpt = userRepository.findById(CompositeID.builder().id(user.getId()).version(user.getVersion()).build());
			var userFromDb = userFromDbOpt.orElseThrow(() -> new EntityNotFoundException());
			var relationshipsFromDb = userFromDb.getAddressRelationships();
			if(user.getAddressRelationships()!= null)
			{
				relationshipsFromDb.removeIf(r -> !user.getAddressRelationships().contains(r));
			}
			//relationshipsFromDbIds.addAll(user.getAddressRelationships());
		}
		//var persistedUser= userRepository.save(user);
		if(user.getAddressRelationships()!= null)
			user.getAddressRelationships().forEach(rel ->
			{
				rel.setUser(user);
			});
		else
		{
			user.setAddressRelationships(new ArrayList<>());
			user.getAddressRelationships().clear();
		}
				var result =  userRepository.save(user);
		return UserDtoMapper.UserEntityToDto(result);
	}

	public Address saveAddress(Address address)
	{
		return addressRepository.save(address);
	}

	public User updateUser(User user) throws Exception {
		if(userRepository.existsById(CompositeID.builder().id(user.getId()).version(user.getVersion()).build()))
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
