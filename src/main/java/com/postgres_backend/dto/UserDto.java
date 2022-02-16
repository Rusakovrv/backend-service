package com.postgres_backend.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserDto {

	private Long id;

	private String firstName;

	private String lastName;

	private String version;

	private List<UserAddressRelationshipDto> relationshipDto;
}
