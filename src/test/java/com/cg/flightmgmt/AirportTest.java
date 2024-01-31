package com.cg.flightmgmt;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.flightmgmt.dao.AirportDao;
import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.exception.AirportNotFoundException;
import com.cg.flightmgmt.repository.AirportRepository;

import antlr.collections.List;

@SpringBootTest
public class AirportTest 
{

	@Autowired
	private AirportRepository repo;
	
	@Autowired
	AirportDao dao;
	
	
	public void testSave() {
		
		Airport air=new Airport(12,"Thane","Korum");
		dao.addAirport(air);
		assertNotNull(repo.findById(12).get());
	}

	public void TestViewAirport()
	{
		
		java.util.List<Airport> testForView =new ArrayList<>();
		
		testForView=repo.findAll();
		assertNotNull(testForView);
		
	}
	@Test
	public void TestViewAirportbyCode() throws AirportNotFoundException
	{
		assertNotNull(dao.viewAirport(110));
	}
}
