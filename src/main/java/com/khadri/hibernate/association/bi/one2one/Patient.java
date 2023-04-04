package com.khadri.hibernate.association.bi.one2one;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;

@Entity(name = "Patient")
@Table(name = "PATIENT")
public class Patient {

	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	@Column(name = "P_ID")
	private UUID id;

	@Column(name = "P_OP")
	@NaturalId
	private Long op;

	@Column(name = "P_NAME")
	private String name;

	@Column(name = "P_DESEASE")
	private String disease;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Long getOp() {
		return op;
	}

	public void setOp(Long op) {
		this.op = op;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}
	
}
