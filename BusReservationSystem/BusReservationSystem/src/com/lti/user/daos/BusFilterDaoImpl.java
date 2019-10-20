package com.lti.user.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.user.entities.Bus;
import com.lti.user.exceptions.BusException;

@Repository
@Scope("singleton")	
@Transactional(propagation=Propagation.REQUIRED)
public class BusFilterDaoImpl implements BusFilterDao{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Bus> listBus() throws BusException{
		Query query=manager.createQuery("from Bus ");
		List<Bus> busList=query.getResultList();
		return busList;
	}

	@Override
	public Bus viewBus(int busno) {
		Bus bus=manager.find(Bus.class, busno);
		
		return bus;
	}

	// List by arrival similar to this
	@Override
	public List<Bus> listBusByDeparture(double from, double to) throws BusException {
		Query query2=manager.createQuery("from Bus where departureTime>=:from and departureTime<=:to order by busno");
		query2.setParameter("from",from);
		query2.setParameter("to",to);
		
		return query2.getResultList();
	}

	
	@Override
	public List<Bus> listBusByTimes(double deptFrom, double deptTo, double arrFrom, double arrTo) throws BusException{
		Query query3=manager.createQuery("from Bus where departureTime between :deptFrom and :deptTo and arrivalTme between :arrFrom and :arrTo order by busno");
		query3.setParameter("deptFrom", deptFrom);
		query3.setParameter("deptTo", deptTo);
		query3.setParameter("arrFrom", arrFrom);
		query3.setParameter("arrTo", arrTo);
		
		return query3.getResultList();
	}
	
	
}
