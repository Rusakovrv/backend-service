package com.postgres_backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Place implements Serializable {

	@Id
	@GeneratedValue(generator = "place_id_seq", strategy = GenerationType.SEQUENCE)
	private Long id;

	private String info;

	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;


}