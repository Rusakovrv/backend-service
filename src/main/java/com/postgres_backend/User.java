package com.postgres_backend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Cascade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(CompositeID.class)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	private Long id;

	@Id
	private String version;

	@Column
	@NotNull
	private String firstName;

	@Column
	private String lastName;

	@Column(columnDefinition = "varchar default 'new'")
	private String role;

	@OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
	private List<UserAddressRelationship> addressRelationships;

//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//	private List<Address> addresses;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		User that = (User) o;
		return id != null && version != null && Objects.equals(id, that.id) && Objects.equals(version, that.version);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, version);
	}
}
