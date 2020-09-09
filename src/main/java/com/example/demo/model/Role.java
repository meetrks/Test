package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "roles_tab")
@SequenceGenerator(name = "role_id_seq", initialValue = 1, allocationSize = 1)
public class Role {

	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_seq")
	private Integer id;

	private String name;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(String name) {
		super();
		this.name = name;
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
