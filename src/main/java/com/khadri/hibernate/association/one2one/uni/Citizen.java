package com.khadri.hibernate.association.one2one.uni;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;

@Entity(name = "Citizen1")
@Table(name = "CITIZEN")
public class Citizen {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "uuid-char")
	@Column(name = "C_ID")
	private UUID citizenId;

	@Column(name = "C_NAME")
	@NaturalId
	private String citizenName;

	@OneToOne
	@JoinColumn(name = "ADHAAR_A_ID", foreignKey = @ForeignKey(name = "CITIZEN_ADHAAR_FK"))
	private Adhaar adhaar;

	public UUID getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(UUID citizenId) {
		this.citizenId = citizenId;
	}

	public String getCitizenName() {
		return citizenName;
	}

	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}

	public Adhaar getAdhaar() {
		return adhaar;
	}

	public void setAdhaar(Adhaar adhaar) {
		this.adhaar = adhaar;
	}

}
