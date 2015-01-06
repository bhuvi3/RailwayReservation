package com.railreservation.domain;

import java.io.Serializable;

public class Ticket implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//members
	private Passenger pass;
	//constructors
	public Ticket(Passenger p){
		pass=p;
	}
	public Ticket(){
		pass=null;
	}
	//methods
	public Passenger getPassenger(){
		return pass;
	}
	public void setPassenger(Passenger p){
		pass=p;
	}
	public void removePassenger(){
		pass=null;
	}
}

