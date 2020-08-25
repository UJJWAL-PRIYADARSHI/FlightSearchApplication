package com.flight.booking.FlightSearchApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flight.booking.FlightSearchApplication.domain.FlightDetail;

@Repository
public interface FlightRepositoryImpl extends FlightRepository {

	@Query(value = "select * from detail where src = ?1 and des = ?2 and tdate = ?3", nativeQuery = true)
	public List<FlightDetail> getFlightDetailsBySrcDesTravelDate(String src, String des, String tdate);
}