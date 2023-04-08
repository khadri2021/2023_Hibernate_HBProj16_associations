package com.khadri.hibernate.association.one2many.uni;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity(name = "HeadMaster")
@Table(name = "HEADMASTER")
public class HeadMaster {

	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	@Column(name = "H_ID")
	private UUID id;

	@Column(name = "H_NAME")
	private String name;

	@Column(name = "H_AGE")
	private int age;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
