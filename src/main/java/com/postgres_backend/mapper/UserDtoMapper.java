package com.postgres_backend.mapper;

import com.postgres_backend.User;
import com.postgres_backend.dto.UserDto;

public class UserDtoMapper {

	public static User UserDtoToEntity(UserDto userDto)
	{
		return User.builder().userId(userDto.getId()).firstName(userDto.getFirstName()).lastName(userDto.getLastName()).build();
	}
}
