package com.kretacx.rr.dto;

import java.io.Serializable;

public class ReservationResponse implements Serializable{
	
	private static final long serialVersionUID = 6950516743879226567L;
	
	private Integer id;
	private ReservationDateResponse dt;
	private String userName;
	private String restaurantName;
	private Integer partySize;
	
	public ReservationResponse() {
		
	}

	public ReservationResponse(Integer id, ReservationDateResponse dt, String userName, String restaurantName,
			Integer partySize) {
		super();
		this.id = id;
		this.dt = dt;
		this.userName = userName;
		this.restaurantName = restaurantName;
		this.partySize = partySize;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ReservationDateResponse getDt() {
		return dt;
	}

	public void setDt(ReservationDateResponse dt) {
		this.dt = dt;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Integer getPartySize() {
		return partySize;
	}

	public void setPartySize(Integer partySize) {
		this.partySize = partySize;
	}
	
}
