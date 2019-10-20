package com.lti.user.controllers;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lti.user.daos.SearchSeatDaoImpl;
import com.lti.user.entities.Passenger;

@Controller
public class BusController {

	@Resource
	private SearchSeatDaoImpl search;
	
	@RequestMapping("/seatList")
	public ModelAndView listBookedSeats() {
		ModelAndView mvc=null;
		Date date=new Date(22102019);
		List<Passenger> searchList=search.searchBookedSeat(604,1012,date);
		mvc=new ModelAndView();
		
		mvc.setViewName("searchList");
		mvc.addObject("list",searchList);
		return mvc;
	}
}
