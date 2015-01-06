package com.railreservation.domain;

import java.io.Serializable;

//import java.util.Date;
import com.railreservation.auxiliary.*;

public class PNR implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//members
	private MyDate doj;
	private int trainNo;
	private int seatNo;
	//constructors
	public PNR(MyDate d,int t,int s){
		doj=d;
		trainNo=t;
		seatNo=s;
	}
	//methods
	public MyDate getDoj(){
		return doj;
	}
	public int getTrainNo(){
		return trainNo;
	}
	public int getSeatNo(){
		return seatNo;
	}
	@SuppressWarnings("deprecation")
	public String printDetails(){
		String temp=("DOJ: "+doj.getDate()+"/"+(doj.getMonth()+1)+"/"+(doj.getYear()+1900)+"\n"+"TrainNo: "+trainNo+"\n"+"SeatNo: "+seatNo);
		return temp;
	}
}
