package com.lti.user.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
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
			//System.out.println(busList);
			
			/*// Pass on this data to JSP
			request.setAttribute("list",busList);*/

		} 
		catch (BusException e) 
		{
			e.printStackTrace();
		}
		return busList;
	}

	@RequestMapping(value="/busList/{id}", method=RequestMethod.GET, produces="application/json")
	public Bus getBusByBusNO(@PathVariable("id") int busno) {
	//System.out.println("Search bus by no:");
	//Scanner sc=new Scanner(System.in);
	//busno=sc.nextInt();
	Bus bus=null;
	try {
		bus = service.viewBus(busno);
		System.out.println(bus);
	} catch (BusException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return bus;
}
	@RequestMapping(value="/busList/{fromTime}/{toTime}", method=RequestMethod.GET, produces="application/json")
	public List<Bus> getBusByDeptTime(@PathVariable("fromTime") double from,@PathVariable("toTime") double to) {
	List<Bus> listByDepart=null;
	try {
		listByDepart=service.listBusByDeparture(from, to);
	} catch (BusException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return listByDepart;
}
	@RequestMapping(value="/busList/{deptTime1}/{deptTime2}/{arrTime1}/{arrTime2}", method=RequestMethod.GET, produces="application/json")
	public List<Bus> getBusBetween(@PathVariable("deptTime1") double from1,@PathVariable("deptTime2") double from2,@PathVariable("arrTime1") double to1,@PathVariable("arrTime2") double to2) {
	List<Bus> listByTimes=null;
	try {
		listByTimes=service.listBusByTimes(from1, from2, to1, to2);
	} catch (BusException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return listByTimes;
}
}
