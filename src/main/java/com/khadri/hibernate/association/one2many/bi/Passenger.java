package com.khadri.hibernate.association.one2many.bi;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity(name = "Passenger")
@Table(name = "PASSENGER")
public class Passenger {

	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	@Column(name = "P_ID")
	private UUID id;

	@Column(name = "P_TNO")
	private String ticketNumber;

	@ManyToOne
	private Bus bus;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

}
