package com.flight.booking.FlightSearchApplication.domain;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "flight_detail")
@Getter
@Setter
public class FlightDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "f_no")
	private long flightNo;
	
	@Column(name= "a_name")
	private String airlineName;
	
	@Column(name = "departure")
	private LocalTime departure;
	
	@Column(name= "arrival")
	private LocalTime arrival;
	
	@Column(name = "duration")
	private int duration;
	
	@Column(name = "no_of_stop")
	private int NoOfStop;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "sourceCity")
	private String sourceCity;
	
	@Column(name = "destination")
	private String destination;
	
	@Column(name = "travelDate")
	private String travelDate;
}
