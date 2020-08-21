package com.flight.booking.FlightSearchApplication.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.booking.FlightSearchApplication.domain.FlightDetail;
import com.flight.booking.FlightSearchApplication.repository.FlightRepositoryImpl;

@Service
public class FlightSearchServiceImpl implements FlightSearchService{

	@Autowired
	FlightRepositoryImpl flightRepositoryImpl;
	
	@Override
	public List<FlightDetail> getFlightDetails(String source, String city, String date, String sortBy, String sortOrder) {
		List<FlightDetail> details = flightRepositoryImpl.getFlightDetailsBySrcDesTravelDate(source, city, date);
		
		//Defalt sorting if sortBy is null or empty
		Collections.sort(details, (s, v)-> s.getAirlineName().compareTo(v.getAirlineName()));
		
		if (!(null == sortBy)) {
			if(null == sortOrder) sortOrder = "asc";
			Collections.sort(details, getComparator(sortBy,sortOrder));
		}
		
		return details;
	}
	
	private Comparator<FlightDetail> getComparator(String sortBy, String sortOrder){
		
		switch(sortBy) {
		case "airline":
			return sortOrder.equalsIgnoreCase("asc") ? 
					(s, v)-> s.getAirlineName().compareTo(v.getAirlineName()) :
						(v, s)-> s.getAirlineName().compareTo(v.getAirlineName());
						
		case "departure":
			return sortOrder.equalsIgnoreCase("asc") ? 
					(s, v)-> s.getDeparture().compareTo(v.getDeparture()) :
						(v, s)-> s.getDeparture().compareTo(v.getDeparture());
		case "duration":
			return sortOrder.equalsIgnoreCase("asc") ? 
					(s, v)-> s.getDuration()- v.getDuration() :
						(v, s)-> s.getDuration() -v.getDuration();
		case "price" :
			return sortOrder.equalsIgnoreCase("asc") ?
					(s, v)-> s.getPrice()- v.getPrice() :
						(v, s)-> s.getPrice()-v.getPrice();
		default :
			return sortOrder.equalsIgnoreCase("asc") ? 
					(s, v)-> s.getAirlineName().compareTo(v.getAirlineName()) :
						(v, s)-> s.getAirlineName().compareTo(v.getAirlineName());
		}
	}
}
