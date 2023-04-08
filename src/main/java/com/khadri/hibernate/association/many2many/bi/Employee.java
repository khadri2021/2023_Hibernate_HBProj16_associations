package com.khadri.hibernate.association.many2many.bi;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity(name = "Employee1")
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	@Column(name = "EMP_ID")
	private UUID id;

	@Column(name = "EMP_NAME")
	private String name;

	@ManyToMany
	private List<Project> listProjects = new ArrayList<>();

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addProjects(List<Project> list) {
		this.listProjects.addAll(list);
	}

	public List<Project> getProjects() {
		return this.listProjects;
	}

}
