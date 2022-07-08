package com.postgres_backend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@IdClass(UserAddressCompositeKey.class)
public class UserAddressRelationship {


	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name = "user.id", referencedColumnName = "id"), @JoinColumn(name = "user.version", referencedColumnName = "version")})
	private User user;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name = "address.id", referencedColumnName = "id"), @JoinColumn(name = "address.version", referencedColumnName = "version")})
	private Address address;

	private String type;

	public UserAddressCompositeKey getId()
	{
		return UserAddressCompositeKey.builder().user(CompositeID.builder().id(user.getId()).version(user.getVersion()).build()).address(CompositeID.builder().id(address.getId()).version(address.getVersion()).build()).build();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		UserAddressRelationship that = (UserAddressRelationship) o;
		return user != null && address != null && Objects.equals(user, that.user) && Objects.equals(address, that.address);
	}

	@Override
	public int hashCode() {
		return Objects.hash(user, address);
	}

}
