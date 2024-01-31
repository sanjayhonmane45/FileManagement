package com.cg.flightmgmt;

import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.flightmgmt.dao.AirportDao;
import com.cg.flightmgmt.dao.FlightDao;
import com.cg.flightmgmt.dao.ScheduleDao;
import com.cg.flightmgmt.dao.ScheduledFlightDao;
import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import com.cg.flightmgmt.repository.AirportRepository;
import com.cg.flightmgmt.repository.FlightRepository;
import com.cg.flightmgmt.repository.ScheduleRepository;
import com.cg.flightmgmt.repository.ScheduledFlightRepository;

@SpringBootTest
public class ScheduledFlightTest 
{
	@Autowired
	private ScheduledFlightRepository repo;
	@Autowired
	 ScheduledFlightDao dao;
	@Autowired
	private FlightRepository repo1;
	@Autowired
	private AirportRepository repo2;
	@Autowired
	private ScheduleRepository repo3;
	
	@Test
	public void testSave1() {




		BigInteger bigInteger=new BigInteger("25");
		BigInteger bigInteger1=new BigInteger("33");
		Flight flight=new Flight(bigInteger,"XYZ","ABC",27);
		Airport air=new Airport(22,"mum","Marines");
		Airport air1=new Airport(23,"Thane","talav");
          repo1.save(flight);
          repo2.save(air);
          repo2.save(air1);
		LocalDateTime localDateTime1 =
		LocalDateTime.of(2019, 03, 28, 14, 33, 48, 640000);

		LocalDateTime localDateTime2 =
		LocalDateTime.of(2000, 03, 28, 14, 33, 48, 640000);


		Schedule schedule=new Schedule(bigInteger1,air1, air,localDateTime1,localDateTime2);
		repo3.save(schedule);
		ScheduledFlight sch=new ScheduledFlight(bigInteger,flight, 50,schedule);
		repo.save(sch);
		



		}	
	public void testviewByFlightId()
	{
	BigInteger bigInteger=new BigInteger("63");
	List<ScheduledFlight> testForView=new ArrayList<>();
	testForView=dao.viewScheduledFlight(bigInteger);

	assertNotNull(testForView);
	}
	
	public void testview()
	{
	List<ScheduledFlight> testForView=new ArrayList<>();
	testForView=dao.viewScheduledFlights();

	assertNotNull(testForView);
	}
	
	public void delete() throws FlightNotFoundException
	{
	BigInteger bigInteger=new BigInteger("559");
	dao.deleteFlightSchedule(bigInteger);
	}
}
