package com.lti.user.daos;

import java.util.List;

import com.lti.user.entities.Bus;
import com.lti.user.exceptions.BusException;

public interface BusFilterDao {

	public List<Bus> listBus() throws BusException;
	public Bus viewBus(int busno) throws BusException;
	public List<Bus> listBusByDeparture(double from, double to)  throws BusException;
	public List<Bus> listBusByTimes(double deptFrom, double deptTo, double arrFrom, double arrTo) throws BusException;
	
}
