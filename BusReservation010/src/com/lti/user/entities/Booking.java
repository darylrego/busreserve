package com.lti.user.entities;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {

	@Id
	@Column(name="ticket_no")
	private int ticketno;
	
	@Column(name="email")
	private String email;
	
	@Column(name="no_of_pass")
	private int noOfPassenger;
	
	@Column(name="cost")
	private double cost;
	
	@Column(name="journey_date")
	private Date journeyDate;
	
	@Column(name="busno")
	private int busno;
	
	@Column(name="booking_date")
	private Date bookingDate;
	
	@Column(name="card_no")
	private BigInteger cardNo;
	
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Booking(int ticketno, String email, int noOfPassenger, double cost, Date journeyDate, int busno,
			Date bookingDate, BigInteger cardNo) {
		super();
		this.ticketno = ticketno;
		this.email = email;
		this.noOfPassenger = noOfPassenger;
		this.cost = cost;
		this.journeyDate = journeyDate;
		this.busno = busno;
		this.bookingDate = bookingDate;
		this.cardNo = cardNo;
	}
	
	public int getTicketno() {
		return ticketno;
	}
	public void setTicketno(int ticketno) {
		this.ticketno = ticketno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNoOfPassenger() {
		return noOfPassenger;
	}
	public void setNoOfPassenger(int noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	public int getBusno() {
		return busno;
	}
	public void setBusno(int busno) {
		this.busno = busno;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public BigInteger getCardNo() {
		return cardNo;
	}
	public void setCardNo(BigInteger cardNo) {
		this.cardNo = cardNo;
	}
	
	@OneToMany(mappedBy="booking", fetch=FetchType.EAGER)
	List<Passenger> pList;	
	
	public List<Passenger> getpList() {
		return pList;
	}

	public void setpList(List<Passenger> pList) {
		this.pList = pList;
	}

	@Override
	public String toString() {
		return "Booking [ticketno=" + ticketno + ", email=" + email + ", noOfPassenger=" + noOfPassenger + ", cost="
				+ cost + ", journeyDate=" + journeyDate + ", busno=" + busno + ", bookingDate=" + bookingDate
				+ ", cardNo=" + cardNo + "]";
	}
	
	
}
