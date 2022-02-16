package com.postgres_backend.mapper;

import com.postgres_backend.Address;
import com.postgres_backend.User;
import com.postgres_backend.UserAddressRelationship;
import com.postgres_backend.dto.UserAddressRelationshipDto;
import com.postgres_backend.dto.UserDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserDtoMapper {

	public static User UserDtoToEntity(UserDto userDto)
	{
		return User.builder().id(userDto.getId()).version(userDto.getVersion()).firstName(userDto.getFirstName()).lastName(userDto.getLastName()).addressRelationships(userAddressRelationshipDtoListToEntity(userDto.getRelationshipDto())).build();
	}

	public static UserAddressRelationshipDto userAddressRelationshipToDto(UserAddressRelationship addressRelationship)
	{
		return UserAddressRelationshipDto.builder().addressId(addressRelationship.getAddress().getId()).addressVersion(addressRelationship.getAddress().getVersion()).type(addressRelationship.getType()).build();
	}

	public static List<UserAddressRelationshipDto> userAddressRelationshipListToDto(List<UserAddressRelationship> addressRelationship)
	{
		return Optional.ofNullable(addressRelationship).map(ar -> addressRelationship.stream().map(a -> userAddressRelationshipToDto(a)).collect(Collectors.toList())).orElse(null);
	}

	public static List<UserAddressRelationship> userAddressRelationshipDtoListToEntity(List<UserAddressRelationshipDto> addressRelationship)
	{
		return Optional.ofNullable(addressRelationship).map(ar -> addressRelationship.stream().map(a -> userAddressRelationshipDtoToEntity(a)).collect(Collectors.toList())).orElse(null);
	}

	public static UserAddressRelationship userAddressRelationshipDtoToEntity(UserAddressRelationshipDto addressRelationship)
	{
		return UserAddressRelationship.builder().address(Address.builder().id(addressRelationship.getAddressId()).version(addressRelationship.getAddressVersion()).build()).type(addressRelationship.getType()).build();
	}

	public static UserDto UserEntityToDto(User user)
	{
		return UserDto.builder().firstName(user.getFirstName()).lastName(user.getLastName()).version(user.getVersion()).id(user.getId()).relationshipDto(userAddressRelationshipListToDto(user.getAddressRelationships())).build();
	}


}
