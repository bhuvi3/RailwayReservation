package com.railreservation.auxiliary;

import java.io.Serializable;
import java.util.Date;

public class MyDate extends Date implements Serializable {
	private static final long serialVersionUID = 1L;
	//constructor
	
	public MyDate(long time) {
		// TODO Auto-generated constructor stub
		super(time);
	}
	public MyDate(){
		super();
	}
	@SuppressWarnings("deprecation")
	public MyDate(int y,int m,int d){
		//y=y-1900;
		super(y-1900,m-1,d);
	}
	//equality overridden functions
	@SuppressWarnings("deprecation")
	public boolean equals(Object obj) {
		if(obj instanceof Date){
			Date b=(Date) obj;
			if(this.getDate()==b.getDate() && this.getMonth()==b.getMonth() && this.getYear()==b.getYear()){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
        //return obj instanceof Date && getTime() == ((Date) obj).getTime();
    }
	@SuppressWarnings("deprecation")
	public int hashCode() {
		int d=this.getDate();
		int m=this.getMonth()+1;
		int y=this.getYear()+1900;
        //generating hashcode:appending ddmmyyyy
		int hash=(d*100 +m)*10000 +y;
		return hash;
        //return (int) ht ^ (int) (ht >> 32);
    }
}
