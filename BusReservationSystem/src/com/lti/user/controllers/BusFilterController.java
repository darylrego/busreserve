package com.lti.user.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lti.user.entities.Bus;
import com.lti.user.exceptions.BusException;
import com.lti.user.services.BusService;

/*
 * http://localhost:9090/BusReservationSystem/
 */
@Controller
public class BusFilterController {
	
	@Resource
	private BusService service;
	
	ModelAndView mdv=null;

	@RequestMapping("/busList")
	public ModelAndView getBusList()
	{	
		
		List<Bus> busList=null;
		
		try
		{
			mdv=new ModelAndView();
			busList=service.listBus();	
			mdv.setViewName("BusList");
			mdv.addObject("list",busList);

		} 
		catch (BusException e) 
		{
			e.printStackTrace();
		}
		return mdv;
	}

	@RequestMapping("/searchBusByNo")
	public String searchB() {
		return "searchBus";
	}
	@RequestMapping("/getBusByNo")
	public ModelAndView getByBusNo(@RequestParam("busno")int busno) {
	
	Bus bus=null;
	System.out.println("into bus by busnos");
	//int busno=Integer.parseInt(request.getParameter("busno"));
	try {
		bus = service.viewBus(busno);
		System.out.println(bus);
		mdv=new ModelAndView();
		mdv.setViewName("getBusByNo");
		mdv.addObject("bus",bus);
	} catch (BusException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return mdv;
}

	@RequestMapping("/searchByDepart")
	public String searchBusByDepart() {
		return "searchByDepart";
	}
	@RequestMapping("/byDeptTime")
	public ModelAndView getBusByDeptTime(@RequestParam("fromTime") double from,@RequestParam("toTime") double to) {
	List<Bus> listByDepart=null;
	
	try {
		mdv=new ModelAndView();
		listByDepart=service.listBusByDeparture(from, to);
		System.out.println(listByDepart);
		mdv.setViewName("getBusByDepart");
		mdv.addObject("listByDepart",listByDepart);
	} catch (BusException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return mdv;
}
	@RequestMapping("/searchBetween")
	public String searchBus() {
		return "searchBetween";
	}
	@RequestMapping("/betweenBus")
	public ModelAndView getBusBetween(@RequestParam("deptTime1") double from1,@RequestParam("deptTime2") double from2,@RequestParam("arrTime1") double to1,@RequestParam("arrTime2") double to2) {
	List<Bus> listByTimes=null;
	try {
		mdv=new ModelAndView();
		listByTimes=service.listBusByTimes(from1, from2, to1, to2);
		mdv.setViewName("getBus");
		mdv.addObject("listBus",listByTimes);
	} catch (BusException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return mdv;
}
}
