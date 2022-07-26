package com.kretacx.rr.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReservationRequest implements Serializable{

	private static final long serialVersionUID = 3566291994425186276L;
	
	@JsonProperty(required = true)
	private String userName;
	
	@JsonProperty(required = true)
	private Integer partySize;
	
	@JsonProperty(required = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss.SSS")
	private Date reservationDate;
	
	@JsonProperty(required = true)
	private String restaurantName;

	public ReservationRequest() {
		
	}
		
	public ReservationRequest(String userName, Integer partySize, Date reservationDate, String restaurantName) {
		super();
		this.userName = userName;
		this.partySize = partySize;
		this.reservationDate = reservationDate;
		this.restaurantName = restaurantName;
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

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

}
