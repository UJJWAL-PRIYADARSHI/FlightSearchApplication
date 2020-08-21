package com.flight.booking.FlightSearchApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.booking.FlightSearchApplication.domain.FlightDetail;
import com.flight.booking.FlightSearchApplication.service.FlightSearchServiceImpl;

@RestController
public class FlightSearchController {

	@Autowired
	FlightSearchServiceImpl flightSearchServiceImpl;

	@RequestMapping(value = "/getFlightDetails", method = RequestMethod.GET)
	public List<FlightDetail> getFlightDetails(@RequestParam("src") String source,
			@RequestParam("des") String destination, @RequestParam("td") String travelDate,
			@RequestParam(value = "sortBy", required = false) String sortBy,
			@RequestParam(value = "sortOrder", required = false) String sortOrder) {
		return flightSearchServiceImpl.getFlightDetails(source, destination, travelDate, sortBy, sortOrder);
	}
}
