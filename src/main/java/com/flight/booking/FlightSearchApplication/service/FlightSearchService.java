package com.flight.booking.FlightSearchApplication.service;

import java.util.List;

import com.flight.booking.FlightSearchApplication.domain.FlightDetail;

public interface FlightSearchService {

	public List<FlightDetail> getFlightDetails(String source, String city, String date, String sortBy,
			String sortOrder);
}
