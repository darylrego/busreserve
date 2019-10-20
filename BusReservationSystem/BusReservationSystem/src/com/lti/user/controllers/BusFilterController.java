package com.lti.user.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.user.entities.Bus;
import com.lti.user.exceptions.BusException;
import com.lti.user.services.BusService;

/*
 * http://localhost:8091/BusReservationSystem/
 */
@RestController
public class BusFilterController {
	
	@Resource
	private BusService service;
	
	@RequestMapping(value="/busList", method=RequestMethod.GET, produces="application/json")
	public List<Bus> getBusList()
	{	
		List<Bus> busList=null;
		
		try
		{
			busList=service.listBus();	
			System.out.println(busList);
		} 
		catch (BusException e) 
		{
			e.printStackTrace();
		}
		return busList;
	}

}
