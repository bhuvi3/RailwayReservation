package com.railreservation.test;

import java.util.ArrayList;
import java.util.HashMap;

import com.railreservation.auxiliary.MyDate;
import com.railreservation.domain.Clerk;
import com.railreservation.domain.ReservationSystem;
import com.railreservation.domain.Train;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<MyDate,String> tmap= new HashMap<MyDate,String>();
		MyDate doj=new MyDate();
		MyDate dd=new MyDate();
		MyDate td=new MyDate(2013,11,12);
		tmap.put(doj, "its today");
		System.out.println(doj);
		System.out.println(td);
		String s=tmap.get(td);
		System.out.println(s);
	}

}
