package com.railreservation.railexceptions;

public class NoTrainException extends RailException {
	private static final long serialVersionUID = 1L;
	private final String msg="RAIL EXCEPTION : NO TRAIN EXCEPTION";
	public String getMsg(){
		return msg;
	}
}
