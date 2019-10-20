package com.lti.user.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.user.daos.BusFilterDao;
import com.lti.user.entities.Bus;
import com.lti.user.exceptions.BusException;

@Service("busService")
@Scope("singleton")
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class BusServiceImpl implements BusService {

	@Resource
	BusFilterDao dao;
	
	@Override
	public List<Bus> listBus() throws BusException{
		
		return dao.listBus();
	}

	@Override
	public Bus viewBus(int busno) throws BusException {
		
		return dao.viewBus(busno);
	}

	@Override
	public List<Bus> listBusByDeparture(double from, double to) throws BusException{
		
		return dao.listBusByDeparture(from, to);
	}

	@Override
	public List<Bus> listBusByTimes(double deptFrom, double deptTo, double arrFrom, double arrTo) throws BusException {
		
		return dao.listBusByTimes(deptFrom, deptTo, arrFrom, arrTo);
	}

}
