package com.khadri.hibernate.association.bi.one2one;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity(name = "Doctor")
@Table(name = "DOCTOR")
public class Doctor {

	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	@Column(name = "D_ID")
	private UUID id;
	
	@Column(name = "D_NAME")
	private String name;
	
	@OneToOne
	@JoinColumn(name = "D_P_ID",foreignKey = @ForeignKey(name="FK_PATIENT") )
	private Patient patient;

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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
