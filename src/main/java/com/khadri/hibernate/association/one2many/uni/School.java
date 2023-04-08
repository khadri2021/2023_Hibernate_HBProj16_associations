package com.khadri.hibernate.association.one2many.uni;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity(name = "School")
@Table(name = "SCHOOL")
public class School {

	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	@Column(name = "S_ID")
	private UUID id;

	@Column(name = "S_NAME")
	private String name;

	@Column(name = "S_REG_NUMBER")
	private String regNumber;

	@Column(name = "S_ADDRESS")
	private String address;

	
	//use case for one to many
	@OneToMany
	private List<Student> student;
	
	//use case for one to one
	@OneToOne
	private HeadMaster headerMaster;
	
	
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

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public HeadMaster getHeaderMaster() {
		return headerMaster;
	}

	public void setHeaderMaster(HeadMaster headerMaster) {
		this.headerMaster = headerMaster;
	}

}
