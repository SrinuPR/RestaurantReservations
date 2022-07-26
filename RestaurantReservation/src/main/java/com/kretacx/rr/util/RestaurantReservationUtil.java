package com.kretacx.rr.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kretacx.rr.dto.ReservationDateResponse;
import com.kretacx.rr.dto.ReservationRequest;
import com.kretacx.rr.dto.ReservationResponse;
import com.kretacx.rr.model.Reservations;

public class RestaurantReservationUtil {
	
	public static boolean validatePOSTRequest(ReservationRequest request) {
		if(null == request) {
			return false;
		}
		if(null == request.getUserName() || null == request.getPartySize() || null == request.getRestaurantName()) {
			return false;
		}
		return true;
	}

	public static Reservations convertRequestToModelObject(ReservationRequest request) {
		Reservations reservations =  new Reservations();
		reservations.setUserName(request.getUserName());
		if(null != request.getReservationDate())
			reservations.setDateAndTime(request.getReservationDate());
		else 
			reservations.setDateAndTime(new Date());
		reservations.setPartySize(request.getPartySize());
		reservations.setRestaurantName(request.getRestaurantName());
		return reservations;
	}
	
	public static Reservations convertRequestToModelObject(Reservations reservations, ReservationRequest request) {
		reservations.setUserName(request.getUserName());
		if(null != request.getReservationDate())
			reservations.setDateAndTime(request.getReservationDate());
		else 
			reservations.setDateAndTime(new Date());
		reservations.setPartySize(request.getPartySize());
		reservations.setRestaurantName(request.getRestaurantName());
		return reservations;
	}

	public static List<ReservationResponse> convertModelToResponseList(List<Reservations> resList) throws ParseException {
		if(null != resList && resList.size() > 0) {
			List<ReservationResponse> responseList = new ArrayList<ReservationResponse>();
			for(Reservations r: resList) {
				ReservationResponse response = convertModelToResponseObject(r);
				responseList.add(response);
			}
			return responseList;
		}
		return null;
	}
	
	public static ReservationResponse convertModelToResponseObject(Reservations r ) throws ParseException {
		ReservationResponse response = new ReservationResponse(
				r.getId(),
				getDateResponse(r.getDateAndTime()),
				r.getUserName(),
				r.getRestaurantName(),
				r.getPartySize()
				);
		return response;
	}
	
	private static ReservationDateResponse getDateResponse(Date date) throws ParseException {
		if(null != date) {
			DateFormat df = new SimpleDateFormat(RestaurantReservationConstants.STRING_PATTERN);
			String reservationDate = df.format(date);
			df = new SimpleDateFormat(RestaurantReservationConstants.DATE_PATTERN);
			Date d = df.parse(reservationDate);
			reservationDate = df.format(d);
			LocalDate localDate = LocalDate.parse(reservationDate);
			return new ReservationDateResponse(localDate.getDayOfMonth(), 
							localDate.getDayOfWeek().name(),
							localDate.getDayOfYear());
		}
		return null;
	}

}
