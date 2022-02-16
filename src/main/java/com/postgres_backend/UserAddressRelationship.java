package com.postgres_backend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@IdClass(UserAddressCompositeKey.class)
public class UserAddressRelationship {


	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name = "user.id"), @JoinColumn(name = "user.version")})
	private User user;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name = "address.id", referencedColumnName = "id"), @JoinColumn(name = "address.version", referencedColumnName = "version")})
	private Address address;

	private String type;

}
