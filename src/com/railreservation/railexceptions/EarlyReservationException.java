package com.railreservation.railexceptions;

public class EarlyReservationException extends RailException {
	private static final long serialVersionUID = 1L;
	private final String msg="RAIL EXCEPTION : EARLY RESERVATION EXCEPTION";
	public String getMsg(){
		return msg;
	}
}
