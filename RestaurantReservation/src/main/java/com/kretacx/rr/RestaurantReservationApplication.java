package com.kretacx.rr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurantReservationApplication {

	private static final Logger logger = LoggerFactory.getLogger(RestaurantReservationApplication.class);
	
	public static void main(String[] args) {
		logger.info("Application ready to Start");
		SpringApplication.run(RestaurantReservationApplication.class, args);
		logger.info("Application Started");
	}

}
