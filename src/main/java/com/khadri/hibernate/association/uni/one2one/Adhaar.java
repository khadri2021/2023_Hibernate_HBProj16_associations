package com.khadri.hibernate.association.uni.one2one;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;

@Entity(name = "Adhaar1")
@Table(name = "ADHAAR")
public class Adhaar {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "uuid-char")
	@Column(name = "A_ID")
	private UUID adhaarId;

	@Column(name = "COUNTRY")
	private String country;
	
	@NaturalId
	@Column(name = "ADHAAR_NO")
	private String adhaarNumber;

	public UUID getAdhaarId() {
		return adhaarId;
	}

	public void setAdhaarId(UUID adhaarId) {
		this.adhaarId = adhaarId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAdhaarNumber() {
		return adhaarNumber;
	}

	public void setAdhaarNumber(String adhaarNumber) {
		this.adhaarNumber = adhaarNumber;
	}

}
