package com.postgres_backend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserAddressRelationship {

	@EmbeddedId
	private UserAddressCompositeKey id;

	@ManyToOne
	@MapsId("userCompositeId")
	@JoinColumns({@JoinColumn(name = "user_id"), @JoinColumn(name ="user_version")})
	private User user;

	@ManyToOne
	@MapsId("addressCompositeId")
	@JoinColumns({@JoinColumn(name = "address_id"), @JoinColumn(name ="address_version")})
	private Address address;

	private String type;

}
