package com.railreservation.railexceptions;

public class RailException extends Exception{
	private static final long serialVersionUID = 1L;
	private final String msg="RAIL EXCEPTION";
	public String getMsg(){
		return msg;
	}
}
