package com.railreservation.domain;

//import java.util.Date;
import java.io.*;
import java.util.ArrayList;

import com.railreservation.auxiliary.*;

import com.railreservation.railexceptions.RailException;

public class Admin implements Employee {
	//members
	private int empId;
	private String name;
	private final String empType="Administrator";
	public static int noOfAdmins=1;
	//constructors
	public Admin(int empId,String name){
		this.empId=empId;
		this.name=name;
		noOfAdmins++;
	}
	public Admin(){//just for a temporary admin(less-secure method)
		
	}
	//methods
	//implemented
	public String printProfile() {
		// TODO Auto-generated method stub
		String profile=new String("Employee Id :"+empId +"\n"+"Name :"+name+ "\n"+"Type :"+empType+ "\n");
		return profile;
	}
	//specific
	public void loadInitialRecord(){
		MyDate today=new MyDate();
		try {
			(ReservationSystem.getMasterRecord(this)).loadInitialRecord(this,ReservationSystem.getTrainList(this),today);
			System.out.println("RELOADED INITIAL RECORD");
		} catch (RailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void loadMasterRecord(){
		try {
			FileInputStream fs=new FileInputStream("C:\\Users\\Bhuvan\\workspace\\RailwayReservation\\master_record.dat");
			ObjectInputStream os=new ObjectInputStream(fs);
			TrainReservationRecord loadedMR=(TrainReservationRecord) os.readObject();
			ReservationSystem.setMasterRecord(loadedMR);
			System.out.println("LOADED MASTER_RECORD OBJECT");
			int n=(ReservationSystem.getTrainList(this).size());
			System.out.println("Train_List SIZE:"+n);
			os.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("PROBLEM LOADING MASTER_RECORD OBJECT");
			e.printStackTrace();
		}
	}
	public void saveMasterRecord(){
		try {
			FileOutputStream fs=new FileOutputStream("C:\\Users\\Bhuvan\\workspace\\RailwayReservation\\master_record.dat");
			ObjectOutputStream os=new ObjectOutputStream(fs);
			os.writeObject(ReservationSystem.getMasterRecord(this));
			System.out.println("SAVED MASTER_RECORD OBJECT");
			os.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("PROBLEM SAVING MASTER_RECORD OBJECT");
			e.printStackTrace();
		}
	}
	public void loadTrainList(){
		try {
			FileInputStream fs=new FileInputStream("C:\\Users\\Bhuvan\\workspace\\RailwayReservation\\train_list.dat");
			ObjectInputStream os=new ObjectInputStream(fs);
			@SuppressWarnings("unchecked")
			ArrayList<Train> loadedTrains=(ArrayList<Train>) os.readObject();
			ReservationSystem.setTrainList(loadedTrains);
			System.out.println("LOADED TRAINLIST OBJECT");
			int n=(ReservationSystem.getTrainList(this).size());
			System.out.println("TRAINLIST SIZE:"+n);
			os.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("PROBLEM LOADING TRAINLIST OBJECT");
			e.printStackTrace();
		}
	}
	public void saveTrainList(){
		try {
			FileOutputStream fs=new FileOutputStream("C:\\Users\\Bhuvan\\workspace\\RailwayReservation\\train_list.dat");
			ObjectOutputStream os=new ObjectOutputStream(fs);
			os.writeObject(ReservationSystem.getTrainList(this));
			System.out.println("SAVED TRAINLIST OBJECT");
			os.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("PROBLEM SAVING TRAINLIST OBJECT");
			e.printStackTrace();
		}
	}
	public void updateToday(){
		MyDate today=new MyDate();
		try {
			(ReservationSystem.getMasterRecord(this)).updateToday(ReservationSystem.getTrainList(this), today);
		} catch (RailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addEmployee(int empId,int pwd,int type,String name){//empId is just an static increasing number=>Admin.noOfAdmins+Clerk.noOfClerks;
		try {
			(ReservationSystem.getLoginAuth(this)).setInitEmpDetails(this, empId,pwd,type,name);
		} catch (RailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void removeEmployee(int empId){
		try {
			(ReservationSystem.getLoginAuth(this)).removeEmpDetails(this, empId);
		} catch (RailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addTrain(Train newTrain){
		System.out.println("Admin adding train");
		try {
			(ReservationSystem.getTrainList(this)).add(newTrain);
			System.out.println("train added");
			System.out.println((ReservationSystem.getTrainList(this)).size());
		} catch (RailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void removeTrain(int tnum){
		try {
			ArrayList<Train> trainList=ReservationSystem.getTrainList(this);
			for(Train t: trainList){
				if(t.getNum()==tnum){
					//int i=trainList.indexOf(t);
					System.out.println("Removing Train:"+tnum);
					int n=(ReservationSystem.getTrainList(this)).size();
					System.out.println("The trainlist size(before):"+n);
					(ReservationSystem.getTrainList(this)).remove(t);//remove(i);
					n=(ReservationSystem.getTrainList(this)).size();
					System.out.println("The trainlist size(after):"+n);
					break;
				}
			}
		} catch (RailException e) {
			// TODO Auto-generated catch block
			System.err.println("Wrong Train Number");
			e.printStackTrace();
		}
	}
}
