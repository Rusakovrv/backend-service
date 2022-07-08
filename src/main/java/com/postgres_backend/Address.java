package com.postgres_backend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
@IdClass(CompositeID.class)
public class Address {

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
	private Long id;

	@Id
	private String version;

	@Column
	private String info;

	@Column
	private String text;

	@OneToMany(mappedBy = "address", cascade = {CascadeType.ALL})
	private List<UserAddressRelationship> userAddressRelationshipList;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "user_id")
//	private User user;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		Address that = (Address) o;
		return id != null && version != null && Objects.equals(id, that.id) && Objects.equals(version, that.version);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, version);
	}
}
