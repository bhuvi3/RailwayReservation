package com.railreservation.domain;

import java.util.*;
import com.railreservation.auxiliary.*;
import com.railreservation.railexceptions.*;

public class ReservationSystem {//a total static class
	//members
	private static Integer noOfEmp = 1;//simple counter for history of employees
	private static TrainReservationRecord masterRecord = new TrainReservationRecord();
	private static ArrayList<Employee> employeeList = new ArrayList<Employee>();
	private static ArrayList<Train> trainList = new ArrayList<Train>();
	private static DataSource loginAuth = new DataSource();
	//constructors
	//methods
	public static Integer getNoOfEmp(Employee e){
		return noOfEmp;
	}
	/*public static void removeEmployee(Employee e){//only admin access
		
	}
	public static void getEmployee(Employee e){//only admin access
		
	}*/
	public static ArrayList<Employee> getEmployeeList(){
		return employeeList;
	}
	/*public static void updateMasterRecord(Employee e){//reads from train list and writes to the masterRecord//only admin access
		
	}*/
	public static TrainReservationRecord getMasterRecord(Employee e) throws RailException{
		//for(Employee t : employeeList){
		//	if(t==e){
				return masterRecord;
			//}
		//}
	//	throw  new InvalidPermissionException();
	}
	
	public static DataSource getLoginAuth(Employee e) throws RailException{
		//for(Employee t : employeeList){
			//if(t==e){
				return loginAuth;
			//}
		//}
		//throw  new InvalidPermissionException();
	}
	/*public static void addTrain(Employee e){//only admin access
		
	}
	public static void removeTrain(Employee e){//only admin access
		
	}
	public static void updateTrainList(Employee e){//only admin access
		
	}*/
	public static ArrayList<Train> getTrainList(Employee e) throws RailException{
		//for(Employee t : employeeList){
			//if(t==e){
				return trainList;
			//}
		//}
		//throw  new InvalidPermissionException();
	}
	public static void setTrainList(ArrayList<Train> trains) throws RailException{
		//for(Employee t : employeeList){
			//if(t==e){
				trainList=trains;
			//}
		//}
		//throw  new InvalidPermissionException();
	}
	public static void setMasterRecord(TrainReservationRecord loadedMR) throws RailException{
		//for(Employee t : employeeList){
			//if(t==e){
				masterRecord=loadedMR;
			//}
		//}
		//throw  new InvalidPermissionException();
	}
	public static int Login(int Id,int password){
		int regPass=loginAuth.getPassword(Id);//why only final modifier is permitted?(and no other access modifiers are permitted?)
		if(regPass==password){
			int empType=loginAuth.getEmpType(Id);
			String name=loginAuth.getEmpName(Id);
			if(empType==1){//admin
				employeeList.add(new Admin(Id,name));
			}
			else if(empType==2){//clerk
				employeeList.add(new Clerk(Id,name));
			}
			return empType;//empType will never return 0 here as getPassword() checks for that condition
		}
		else if(regPass==0){
			return 0;// empId is not registered
		}
		else{
			return -1; //if wrong password
		}
	}
	public static void printTrainNos(){
		int n=trainList.size();
		System.out.println(n);
		for(Train t:trainList){
			System.out.println(t.getNum());
		}
	}
}
