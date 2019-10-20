package com.lti.user.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="passenger")
public class Passenger {

	@Id
	@Column(name="pass_no")
	private int passengerNo;
	
	@Column(name="pass_name")
	private String passengerName;
	
	@Column(name="age")
	private int age;
	
	@Column(name="gender")
	private char gender;
	
	@Column(name="seat_no")
	private int seatNo;
	
	@Column(name="ticket_no")
	private int ticketNo;
	
	@Column(name="busno")
	private int busNo;
	
	@Column(name="email")
	private String email;
	
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Passenger(int passengerNo, String passengerName, int age, char gender, int seatNo, int ticketNo, int busNo,
			String email) {
		super();
		this.passengerNo = passengerNo;
		this.passengerName = passengerName;
		this.age = age;
		this.gender = gender;
		this.seatNo = seatNo;
		this.ticketNo = ticketNo;
		this.busNo = busNo;
		this.email = email;
	}
	
	public int getPassengerNo() {
		return passengerNo;
	}
	public void setPassengerNo(int passengerNo) {
		this.passengerNo = passengerNo;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	public int getBusNo() {
		return busNo;
	}
	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TICKET_NO")
	private Booking booking; 
	
	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "Passenger [passengerNo=" + passengerNo + ", passengerName=" + passengerName + ", age=" + age
				+ ", gender=" + gender + ", seatNo=" + seatNo + ", ticketNo=" + ticketNo + ", busNo=" + busNo
				+ ", email=" + email + ", booking=" + booking + "]";
	}

}
