package com.cg.flightmgmt;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.flightmgmt.dao.BookingDao;
import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.Passenger;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.BookingNotFoundException;
import com.cg.flightmgmt.repository.AirportRepository;
import com.cg.flightmgmt.repository.BookingRepository;
import com.cg.flightmgmt.repository.FlightRepository;
import com.cg.flightmgmt.repository.PassangerRepository;
import com.cg.flightmgmt.repository.ScheduleRepository;
import com.cg.flightmgmt.repository.ScheduledFlightRepository;
import com.cg.flightmgmt.repository.UserRepository;

@SpringBootTest
public class BookingTest 
{
	@Autowired
	private UserRepository repo1;
	@Autowired
	private PassangerRepository repo2;
	@Autowired
	private FlightRepository repo3;
	@Autowired
	private AirportRepository repo4;
	@Autowired
	private ScheduleRepository repo5;
	@Autowired
	private ScheduledFlightRepository repo6;
	@Autowired
	private BookingRepository repo;
	@Autowired
	BookingDao dao;
	

	public void ViewTest()
	{
	List<Booking> testForView=new ArrayList<>();
	testForView=dao.viewBookings();
	assertNotNull(testForView);
	}
	
public void ViewTestById() throws BookingNotFoundException
{
BigInteger id=new BigInteger("49");
assertNotNull(dao.viewBooking(id));
}
@Test
	public void saveTest()
	{
	User user=new User();
	BigInteger bigInteger=new BigInteger("232");
	user.setUserId(bigInteger);
	user.setEmail("Tanmay35@gmail.com");
	user.setMobileNumber("8879011755");
	user.setPassword("Sanjay");
	user.setUserName("Sanju");
	user.setUserType("Macbook");
     repo1.save(user);
	BigInteger pnrNumber=new BigInteger("236778");
	BigInteger passengerUIN=new BigInteger("6789");
	Passenger p=new Passenger(pnrNumber, "OMI",17,passengerUIN,786.0);
    
	BigInteger pnrNumber1=new BigInteger("1463783");
	BigInteger passengerUIN1=new BigInteger("3657");
	Passenger p1=new Passenger(pnrNumber1, "Enrique",18,passengerUIN1,895.0);
	 
	List<Passenger> list=new ArrayList<>();
	list.add(p1);
	list.add(p);
	int noOfPassangers=list.size();



	BigInteger fid=new BigInteger("2455");
	BigInteger bigInteger1=new BigInteger("3983");
	Flight flight=new Flight(fid,"DFG","XCS",23);
	Airport air=new Airport(299,"navi","Gate");
	Airport air1=new Airport(439,"Malyan","balav");
    repo3.save(flight);
    repo4.save(air);
    repo4.save(air1);
	
	


	LocalDateTime localDateTime3 =
	LocalDateTime.of(2019, 03, 28, 14, 33, 48, 640000);



	LocalDateTime localDateTime2 =
	LocalDateTime.of(2000, 03, 28, 14, 33, 48, 640000);



	Schedule schedule=new Schedule(bigInteger1,air1, air,localDateTime3,localDateTime2);
	repo5.save(schedule);
	ScheduledFlight sch=new ScheduledFlight(bigInteger,flight, 50,schedule);

    repo6.save(sch);

	BigInteger bookingId=new BigInteger("2001");
	String dInStr = "2016-09-01";
	LocalDate d1 = LocalDate.parse(dInStr);
	
	Booking b=new Booking();
	b.setBookingDate(d1);
	b.setBookingId(bookingId);
	b.setFlight(sch);
	b.setNoOfPassangers(noOfPassangers);
	b.setPassengerList(list);
	b.setTicketCost(50.0);
	User user1=new User();
	BigInteger bigInteger11=new BigInteger("777");
	user1.setUserId(bigInteger11);
	user1.setEmail("Prem2@gmail.com");
	user1.setMobileNumber("7899045755");
	user1.setPassword("Prem1");
	user1.setUserName("Pammu");
	user1.setUserType("desktop");
     repo1.save(user1);
	b.setUserId(user1);
	repo.save(b);

	}
	
}
