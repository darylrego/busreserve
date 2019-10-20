package com.lti.user.daos;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.user.entities.Bus;
import com.lti.user.entities.Passenger;
import com.lti.user.exceptions.BusException;

@Repository
@Scope("singleton")	
//@Transactional(propagation=Propagation.REQUIRED)
public class SearchSeatDaoImpl {

	@PersistenceContext
	private EntityManager manager;
	
	//int ticketNo,
	public List<Passenger> searchBookedSeat(int busno,int ticketno, Date journeyDate) {
		
			//String qry="select seat_no from passenger p where p.busno=:busno and p.ticket_no=(select ticket_no from booking b where b.ticket_no:ticketno and b.journey_date='29-OCT-2019')";
		String qry="select seat_no from passenger p join booking b using(ticket_no) where p.busno=:busno and b.journey_date=:jd ";	
		Query query=manager.createNativeQuery(qry);
			query.setParameter("busno", busno);
			//query.setParameter("ticketno", ticketno);
			query.setParameter("jd",journeyDate);
			List<Passenger> seatList=query.getResultList();
			System.out.println(seatList);
			return seatList;
		}

	}
