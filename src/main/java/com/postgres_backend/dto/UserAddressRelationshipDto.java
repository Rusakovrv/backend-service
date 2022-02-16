package com.postgres_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAddressRelationshipDto {

	private Long addressId;

	private String addressVersion;

	private String type;

}
