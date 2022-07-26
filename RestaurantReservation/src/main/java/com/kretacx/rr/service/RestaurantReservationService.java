package com.kretacx.rr.service;

import java.util.List;

import com.kretacx.rr.dto.ReservationRequest;
import com.kretacx.rr.dto.ReservationResponse;
import com.kretacx.rr.exception.RestaurantReservationException;

public interface RestaurantReservationService {

	public Boolean createNewReservation(ReservationRequest request) throws RestaurantReservationException;
	
	public List<ReservationResponse> getAllReservations() throws RestaurantReservationException;
	
	public ReservationResponse getReservationById(Integer id) throws RestaurantReservationException;
	
	public ReservationResponse updateReservationById(Integer id, ReservationRequest rr) throws RestaurantReservationException;
	
	public Boolean deleteReservationById(Integer id) throws RestaurantReservationException;

}
