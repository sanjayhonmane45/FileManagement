package com.cg.flightmgmt;

import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.flightmgmt.dao.FlightDao;
import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import com.cg.flightmgmt.repository.FlightRepository;
@SpringBootTest
public class FlightTest 
{
	@Autowired
	private FlightRepository repo;
	@Autowired
	FlightDao dao;
	
	public void testSave() {
		BigInteger bigInteger=new BigInteger("112");
		Flight flight=new Flight(bigInteger,"ZOOM","AIR",26);
		dao.addFlight(flight);
		assertNotNull(repo.findById(bigInteger).get());
	}
	
	public void ViewFlight() throws FlightNotFoundException
	{
		BigInteger bigInteger=new BigInteger("7");
		assertNotNull(dao.viewFlight(bigInteger));
		
	}
	
	public void deleteFlight() throws FlightNotFoundException
	{
		BigInteger bigInteger=new BigInteger("112");
		Flight flight=dao.viewFlight(bigInteger);
		repo.delete(flight);
	}
	@Test
	public void ModifyFlight() throws FlightNotFoundException
	{
	BigInteger bigInteger=new BigInteger("112");
	Flight flight=new Flight(bigInteger,"CARGO","AIR",26);
	assertNotNull(dao.modifyFlight(flight));
	}
}
