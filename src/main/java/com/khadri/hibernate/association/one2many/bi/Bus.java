package com.khadri.hibernate.association.one2many.bi;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;

@Entity(name = "Bus")
@Table(name = "BUS")
public class Bus {

	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	@Column(name = "B_ID")
	private UUID id;

	@Column(name = "B_BUS_NO")
	@NaturalId
	private String busNo;

	@Column(name = "B_SOURCE")
	private String source;

	@Column(name = "B_DEST")
	private String destination;

	@OneToMany
	private List<Passenger> listPassenger;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public List<Passenger> getListPassenger() {
		return listPassenger;
	}

	public void setListPassenger(List<Passenger> listPassenger) {
		this.listPassenger = listPassenger;
	}

}
