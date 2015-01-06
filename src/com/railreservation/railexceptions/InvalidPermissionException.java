package com.railreservation.railexceptions;

public class InvalidPermissionException extends RailException {
	private static final long serialVersionUID = 1L;
	private final String msg="RAIL EXCEPTION : INVALID PERMISSION EXCEPTION";
	public String getMsg(){
		return msg;
	}
}
