package com.flight.booking.FlightSearchApplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flight.booking.FlightSearchApplication.domain.FlightDetail;

@Repository
public interface FlightRepository extends CrudRepository<FlightDetail, Long> {

}
