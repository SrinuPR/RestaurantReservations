package com.kretacx.rr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kretacx.rr.model.Reservations;

@Repository
public interface RestaurantReservationRepository extends JpaRepository<Reservations, Integer> {

}
