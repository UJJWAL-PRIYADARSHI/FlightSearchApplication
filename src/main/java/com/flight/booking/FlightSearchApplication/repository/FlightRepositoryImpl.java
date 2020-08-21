package com.flight.booking.FlightSearchApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flight.booking.FlightSearchApplication.domain.FlightDetail;

@Repository
public interface FlightRepositoryImpl extends FlightRepository {

	@Query(value = "select * from flight_detail where sourceCity = ?1 and destination = ?2 and travelDate = ?3", nativeQuery = true)
	public List<FlightDetail> getFlightDetailsBySrcDesTravelDate(String source, String destination, String travelDate);

}