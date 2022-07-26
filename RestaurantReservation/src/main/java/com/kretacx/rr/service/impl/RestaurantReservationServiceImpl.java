package com.kretacx.rr.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kretacx.rr.dto.ReservationRequest;
import com.kretacx.rr.dto.ReservationResponse;
import com.kretacx.rr.exception.RestaurantReservationException;
import com.kretacx.rr.model.Reservations;
import com.kretacx.rr.repository.RestaurantReservationRepository;
import com.kretacx.rr.service.RestaurantReservationService;
import com.kretacx.rr.util.RestaurantReservationUtil;

@Service
public class RestaurantReservationServiceImpl implements RestaurantReservationService {

	private static final Logger logger = LoggerFactory.getLogger(RestaurantReservationServiceImpl.class);
		
	@Autowired
	private RestaurantReservationRepository rrRepository;
	
	@Override
	public Boolean createNewReservation(ReservationRequest request) throws RestaurantReservationException {
		logger.info("Start - createNewReservation service");
		try {
			Reservations reservations = RestaurantReservationUtil.convertRequestToModelObject(request);
			reservations = rrRepository.save(reservations);
			if(null != reservations.getId()) {
				logger.info("Reservation id after save: "+reservations.getId());
				return true;
			}
		} catch(Exception exception) {
			throw new RestaurantReservationException("Exception While saving the reservation data into DB " +exception.getMessage());
		}
		logger.info("End - createNewReservation service");
		return false;
	}

	@Override
	public List<ReservationResponse> getAllReservations() throws RestaurantReservationException {
		logger.info("Start - getAllReservations service");
		List<ReservationResponse> reservationResponses = null;
		try {
			List<Reservations> resList = rrRepository.findAll();
			reservationResponses = RestaurantReservationUtil.convertModelToResponseList(resList);
		} catch(Exception exception) {
			throw new RestaurantReservationException("Exception while fetching all Reservations : "+exception.getMessage());
		}
 		logger.info("End - getAllReservations service "+ reservationResponses);
		return reservationResponses;
	}

	@Override
	public ReservationResponse getReservationById(Integer id) throws RestaurantReservationException {
		logger.info("Start - getReservationById service");
		ReservationResponse reservationResponses = null;
		try {
			Optional<Reservations> response = rrRepository.findById(id);
			if(response.isPresent())
				reservationResponses = RestaurantReservationUtil.convertModelToResponseObject(response.get());
		} catch(Exception exception) {
			throw new RestaurantReservationException("Exception while fetching Reservations by Id: "+exception.getMessage());
		}
 		logger.info("End - getReservationById service "+ reservationResponses);
		return reservationResponses;
	}

	@Override
	public ReservationResponse updateReservationById(Integer id, ReservationRequest rr) throws RestaurantReservationException {
		logger.info("Start - updateReservationById service");
		try {
			Optional<Reservations> res = rrRepository.findById(id);
			if(res.isPresent()) {
				Reservations reservations = RestaurantReservationUtil.convertRequestToModelObject(res.get(), rr);
				reservations = rrRepository.save(reservations);
				if(null != reservations.getId())   {
					logger.info("Reservation id after update: "+reservations.getId());
					ReservationResponse response = RestaurantReservationUtil.convertModelToResponseObject(reservations);
					return response;
				}
			}
		} catch(Exception exception) {
			throw new RestaurantReservationException("Exception While updating the reservation data into DB " +exception.getMessage());
		}
		logger.info("End - updateReservationById service");
		return null;
	}

	@Override
	public Boolean deleteReservationById(Integer id) throws RestaurantReservationException {
		logger.info("Start - deleteReservationById service");
		try {
			rrRepository.deleteById(id);
			logger.info("Delete Reservation for id : "+ id);
			return true;
		} catch(Exception exception) {
			throw new RestaurantReservationException("Exception While saving the reservation data into DB " +exception.getMessage());
		}
	}

}
