package com.railreservation.domain;

import java.io.Serializable;
//import java.util.Date;
import java.util.ArrayList;
//import com.railreservation.auxiliary.*;

public class Train implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//members
	private String name,source,destination;
	private int number;
	private int fare;
	private String dep;
	private String arr;
	//private Time jrnHrs;
	private ArrayList<Integer> daysOfTrl;//{0-sunday}
	private ArrayList<Integer> rac;
	//constructor
	public Train(String name,String source,String destination,int number, int fare,String dep,String arr,ArrayList<Integer> daysOfTrl){
		this.name=name;
		this.source=source;
		this.destination=destination;
		this.number=number;
		this.fare=fare;
		this.dep=dep;
		this.arr=arr;
		this.daysOfTrl=daysOfTrl;
		this.rac=new ArrayList<Integer>();
	}
	public Train(Train t){
		
	}
	//methods
	public void setSource(String src){
		source = src;
	}
	public String getSource(){
		return source;
	}
	public void setDestination(String dest){
		destination = dest;
	}
	public String getDestination(){
		return destination;
	}
	public void setName(String Name){
		name = Name;
	}
	public String getName(){
		return name;
	}
	public void setNum(int num){
		number = num;
	}
	public int getNum(){
		return number;
	}
	/*public void setSeats(int seats){
		this.seats = seats;
	}
	public int getSeat(){
		return seats;
	}*/
	public void setFare(int fare){
		this.fare=fare;
	}
	public int getFare(){
		return fare;
	}
	/*public Time getjrnHrs() {
		return jrnHrs;
	}*/
	public void setArrTime(String t){
		arr=t;
	}
	public String getArrTime(){
		return arr;
	}
	public void setDepTime(String t){
		dep=t;
	}
	public String getDepTime(){
		return dep;
	}
	public void setDaysOfTrl(ArrayList<Integer> dot){
		daysOfTrl=dot;
	}
	public ArrayList<Integer> getDaysOfTrl(){
		return daysOfTrl;
	}
	public ArrayList<Integer> getRac(){
		return rac;
	}
	public String printTrainDetails(){
		String temp=new String("TrainName: "+this.name+"\n"+"TrainNo: "+this.number+"\n"+"Source: "+this.source+"\n"+"Destination: "+this.destination+"\n"+"Arrival Time: "+this.arr+"\n"+"TrainNo: "+this.number+"\n"+"Departure Time: "+this.dep+"\n"+"Fare: "+this.fare+"\n"+"DOT: "+printDOT());
		return temp;
	}
	public Train getCopy(){
		return new Train(this.name,this.source,this.destination,this.number,this.fare,this.dep,this.arr,this.daysOfTrl);
	}
	private String printDOT(){
		String dot="";
		for(Integer i:daysOfTrl){
			dot=dot.concat(i+",");
		}
		return dot;
	}
	//equality handling methods
	public boolean equals(Object ot){
		Train t=(Train)ot;
		if(this.number==t.getNum()){
			return true;
		}
		else{
			return false;
		}
	}
	public int hashCode(){
		return this.number;
	}
}

