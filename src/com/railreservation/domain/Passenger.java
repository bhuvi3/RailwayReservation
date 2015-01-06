package com.railreservation.domain;

import java.io.Serializable;

public class Passenger implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//members
	private String name;
	private boolean ticketStatus;//false=>WL;true=>CNF
	//constructors
	public Passenger(String name){
		this.name=name;
		this.ticketStatus=false;
	}
	
	//methods
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public boolean getStatus(){
		return ticketStatus;
	}
	public void setStatus(boolean s){
		this.ticketStatus=s;
	}
}
