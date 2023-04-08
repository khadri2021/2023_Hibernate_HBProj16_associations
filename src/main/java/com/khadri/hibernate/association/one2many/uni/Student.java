package com.khadri.hibernate.association.one2many.uni;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity(name = "Student")
@Table(name = "STUDENT")
public class Student {

	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	@Column(name = "ST_ID")
	private UUID id;

	@Column(name = "ST_NAME")
	private String name;

	@Column(name = "ST_GRADE")
	private String grade;
	
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
