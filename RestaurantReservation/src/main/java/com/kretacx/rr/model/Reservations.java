package com.kretacx.rr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "RESERVATIONS")
public class Reservations implements Serializable {

	private static final long serialVersionUID = 6087369347508294485L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "PARTY_SIZE", 
			nullable = false, 
			insertable = true, 
			updatable = true, 
			length = 3)
	private Integer partySize;
	
	@Column(name = "TIMESTAMP", 
			nullable = false, 
			insertable = true, 
			updatable = true)
	private Date dateAndTime;
	
	@Column(name = "RESTAURANT_NAME", 
			nullable = false, 
			insertable = true, 
			updatable = true, 
			length = 100)
	private String RestaurantName;
	
	public Reservations() {
		
	}

	public Reservations(Integer id, String userName, Integer partySize, Date dateAndTime, String restaurantName) {
		super();
		this.id = id;
		this.userName = userName;
		this.partySize = partySize;
		this.dateAndTime = dateAndTime;
		RestaurantName = restaurantName;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getPartySize() {
		return partySize;
	}

	public void setPartySize(Integer partySize) {
		this.partySize = partySize;
	}

	public Date getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getRestaurantName() {
		return RestaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		RestaurantName = restaurantName;
	}

}
