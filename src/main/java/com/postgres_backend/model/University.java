package com.postgres_backend.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

import static java.util.Objects.nonNull;

@Entity
@DynamicInsert
@Data
@Setter
@NoArgsConstructor
public class University implements Serializable {

	@GeneratedValue(generator = "university_id_seq", strategy = GenerationType.SEQUENCE)
	@Id
	@Column
	private Long id;

	@ColumnDefault(value="'new'")
	private String type;

	@Setter
	@Column(columnDefinition = "varchar default 'new'")
	private String name;

	public void setName(String name)
	{
		this.name = nonNull(name) ? name : "default";
	}

}
