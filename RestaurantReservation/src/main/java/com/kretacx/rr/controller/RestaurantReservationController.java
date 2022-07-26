package com.kretacx.rr.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kretacx.rr.dto.ReservationRequest;
import com.kretacx.rr.dto.ReservationResponse;
import com.kretacx.rr.exception.RestaurantReservationException;
import com.kretacx.rr.service.RestaurantReservationService;
import com.kretacx.rr.util.RestaurantReservationUtil;

@RestController
@RequestMapping(value = "/v1/reservations")
public class RestaurantReservationController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestaurantReservationController.class);
	
	@Autowired
	RestaurantReservationService restaurantReservationService;
	
	@RequestMapping(value = "" , method =RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> createNewReservation(@RequestBody(required = true) ReservationRequest request) {
		logger.info("Entered into createNewReservation Controller ");
		if(!RestaurantReservationUtil.validatePOSTRequest(request)) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		try {
			Boolean result = restaurantReservationService.createNewReservation(request);
			logger.info("Response from Service : "+result);
			return new ResponseEntity<Boolean>(result, result ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (RestaurantReservationException e) {
			e.printStackTrace();
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReservationResponse>> getAllReservations() {
		logger.info("Enterd into getAllReservations api ");
		try {
			List<ReservationResponse> reservationResponses = restaurantReservationService.getAllReservations();
			return new ResponseEntity<>(reservationResponses, HttpStatus.OK); 
		} catch(RestaurantReservationException exception) {
			exception.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReservationResponse> getReservationsById(@PathVariable(name = "id", required = true) Integer id) {
		logger.info("Enterd into getReservationsById api ");
		try {
			ReservationResponse reservationResponses = restaurantReservationService.getReservationById(id);
			return new ResponseEntity<>(reservationResponses, HttpStatus.OK); 
		} catch(RestaurantReservationException exception) {
			exception.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.PUT, 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReservationResponse> updateReservationsById(@PathVariable(name = "id", required = true) Integer id, 
									@RequestBody ReservationRequest request ) {
		logger.info("Enterd into updateReservationsById api ");
		try {
			ReservationResponse reservationResponses = restaurantReservationService.updateReservationById(id, request);
			return new ResponseEntity<>(reservationResponses, HttpStatus.OK); 
		} catch(RestaurantReservationException exception) {
			exception.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> deleteReservationsById(@PathVariable(name = "id", required = true) Integer id) {
		logger.info("Enterd into getReservationsById api ");
		try {
			Boolean result = restaurantReservationService.deleteReservationById(id);
			return new ResponseEntity<>(result, HttpStatus.OK); 
		} catch(RestaurantReservationException exception) {
			exception.printStackTrace();
			return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
