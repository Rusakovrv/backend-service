package com.postgres_backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Data
public class Person implements Serializable {

	@Id
	@GeneratedValue(generator = "person_id_seq", strategy = GenerationType.SEQUENCE)
	private Long id;

	private String info;

	@OneToMany(mappedBy = "person", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
	//@OneToMany(mappedBy = "person")
	private List<Place> places;

//	@OneToMany
//	private List<Person> subPersons;


}
