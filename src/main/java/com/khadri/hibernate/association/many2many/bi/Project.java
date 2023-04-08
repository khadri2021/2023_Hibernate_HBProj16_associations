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

@Entity(name = "Project1")
@Table(name = "PROJECT")
public class Project {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	@Column(name = "PRO_ID")
	private UUID id;

	@Column(name = "PRO_NAME")
	private String name;

	@ManyToMany
	private List<Employee> listEmployees = new ArrayList<>();

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

	public void addEmployees(List<Employee> list) {
		this.listEmployees.addAll(list);
	}
	public List<Employee> getEmployees() {
		return this.listEmployees;
	}
}
