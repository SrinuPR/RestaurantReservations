package com.kretacx.rr.dto;

import java.io.Serializable;

public class ReservationDateResponse implements Serializable{

	private static final long serialVersionUID = -962219221774175267L;
	
	private Integer dayOfMonth;
	private String dayOfWeek;
	private Integer dayOfYear;
	
	public ReservationDateResponse() {
		
	}
	
	public ReservationDateResponse(Integer dayOfMonth, String dayOfWeek, Integer dayOfYear) {
		super();
		this.dayOfMonth = dayOfMonth;
		this.dayOfWeek = dayOfWeek;
		this.dayOfYear = dayOfYear;
	}


	public Integer getDayOfMonth() {
		return dayOfMonth;
	}
	public void setDayOfMonth(Integer dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public Integer getDayOfYear() {
		return dayOfYear;
	}
	public void setDayOfYear(Integer dayOfYear) {
		this.dayOfYear = dayOfYear;
	}
	
}
