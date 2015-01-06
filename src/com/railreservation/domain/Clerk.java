package com.railreservation.domain;

import java.util.ArrayList;
//import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import com.railreservation.auxiliary.*;

import com.railreservation.railexceptions.NoTrainException;
import com.railreservation.railexceptions.RailException;

public class Clerk implements Employee {
	//members
	private int empId;
	private String name;
	private final String empType="Clerk";
	public static int noOfClerks=0;
	//constructors
	public Clerk(int empId,String name){
		this.empId=empId;
		this.name=name;
		noOfClerks++;
	}
	//constructor
	public Clerk(){//just for a temporary admin(less-secure method)
		
	}
	//implemented
	public String printProfile() {
		// TODO Auto-generated method stub
		String profile=new String("Employee Id :"+empId +"\n"+"Name :"+name+ "\n"+"Type :"+empType+ "\n");
		return profile;
	}
	//specific
	private ArrayList<Train> getValidTrainsForSD(String source,String dest,ArrayList<Train> trains){//immutable
		ArrayList<Train> validTrains=new ArrayList<Train>();
		try {
			ArrayList<Train> trainList=trains;
			for(Train t : trainList){
				if(t.getSource().equals(source) && t.getDestination().equals(dest)){
					validTrains.add(t.getCopy());//returning a copy a train
				}
			}
			System.out.println("(private call_2)number of trains available for this day for given S-D:"+validTrains.size());
			return validTrains;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
	private ArrayList<Train> getValidTrainsOfDoj(MyDate doj){//immutable//problem here
		try {
			HashMap<Train,HashMap<String,ArrayList<Ticket>>> trainMap=(ReservationSystem.getMasterRecord(this)).getTrainMapOfDoj(doj);
			System.out.println("(private call_1)number of trains available for this day:"+trainMap.size());
			return (new ArrayList<Train>(trainMap.keySet()));
		} catch (RailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<Train> showTrains(String source,String dest,MyDate doj){
		try {
			//HashMap<Train,HashMap<String,ArrayList<Ticket>>> trainMap=(ReservationSystem.getMasterRecord(this)).getTrainMapOfDoj(doj);
			ArrayList<Train> trainsOfDoj=getValidTrainsOfDoj(doj);
			System.out.println("number of trains available for this day:"+trainsOfDoj.size());
			ArrayList<Train> trainsDojSD=getValidTrainsForSD(source,dest,trainsOfDoj);
			System.out.println("number of trains available for this day for given S-D:"+trainsOfDoj.size());
			return trainsDojSD;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public String checkAvail(MyDate doj,int trainNo){
		
		try {
			HashMap<Train,HashMap<String,ArrayList<Ticket>>> trainMap=ReservationSystem.getMasterRecord(this).getTrainMapOfDoj(doj);
			/*if(trainMap==null){
				throw (new NoTrainException());
			}
			else{*/
				Set<Train> trainList=trainMap.keySet();
				System.out.println("(Check Avail)trainList size :"+trainList.size());
				for(Train t:trainList){
					if(t.getNum()==trainNo){
						HashMap<String,ArrayList<Ticket>> statusMap=trainMap.get(t);
						//checking through WL first then going through AVL
						if((statusMap.get("WL")).isEmpty()){
							int avail=100-statusMap.get("CNF").size();
							int rac=t.getRac().size();
							if(avail==0){
								return(new String("WL: 1"+"RAC:"+rac));
							}
							else{
								return (new String("AVL:"+avail+"RAC:"+rac));
							}
						}
						else{
							int rac=t.getRac().size();
							int wl=statusMap.get("WL").size();
							wl=wl+1;
							return(new String("WL:"+wl+"RAC:"+rac));
						}
					}
					//break;
				}
				//throw new NoTrainException();
			//}
		}catch(NoTrainException e){
			e.printStackTrace();
			return "No Train";
		}
		catch (RailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "No Train";
		}
		return "SUBMIT first then press";	
	}
	public String reserveTicket(MyDate doj,int trainNo,Passenger pass){
		String fail="Ticket booking failed";
		try {
			HashMap<Train,HashMap<String,ArrayList<Ticket>>> trainMap=ReservationSystem.getMasterRecord(this).getTrainMapOfDoj(doj);
			//if(trainMap==null){
			//	throw (new NoTrainException());
			//}
			//else{
				Set<Train> trainList=trainMap.keySet();//to make it mutable 
				for(Train t:trainList){
					if(t.getNum()==trainNo){//temp variables:t=>train;n=>ticket
						//continue here
						HashMap<String,ArrayList<Ticket>> statusMap=trainMap.get(t);
						//both status map and trainList are mutable
						//reserve algorithm
						int avail=statusMap.get("CNF").size();
						int wl=statusMap.get("WL").size();
						if(avail<100){
							pass.setStatus(true);
							Ticket n=new Ticket(pass);
							(statusMap.get("CNF")).add(n);//adding NEW ticket to the original record
							int seatNo=avail+1;
							String tick=printTicket(doj,t.getNum(),seatNo);
							return tick;
						}
						else{
							if(t.getRac().isEmpty()){
								
								pass.setStatus(false);
								Ticket n=new Ticket(pass);
								(statusMap.get("WL")).add(n);
								int seatNo=wl+1;
								//printTicket(doj,t.getNum(),seatNo);
								return (new String("WL:"+seatNo));
							}
							else{
								pass.setStatus(true);
								int r=t.getRac().get(0);
								t.getRac().remove(0);
								(statusMap.get("CNF").get(r)).setPassenger(pass);
								String tick=printTicket(doj,t.getNum(),r);//r=>seatNo taken from rac
								return tick;
							}
						}
						//checking through WL first then going through AVL
						/*if((statusMap.get("WL")).isEmpty()){
							int avail=statusMap.get("CNF").size();
							int isZero=100-avail;
							if(isZero==0){
								statusMap.get("WL").add(newTicket);
								return(new String("WL: 1"));
							}
							else{
								statusMap.get("CNF").add(newTicket);
								avail=avail+1;
								return (new String("AVL:"+avail));
							}
						}
						else{
							int wl=statusMap.get("WL").size();
							wl=wl+1;
							statusMap.get("WL").add(newTicket);
							return(new String("WL:"+wl));
						}*/
					}
					//break;
				}
				//throw new NoTrainException();
			//}
		}catch(NoTrainException e){
			e.printStackTrace();
			return fail;
		}
		catch (RailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return fail;
		}
		return fail;
	}
	public String cancelTicket(PNR pnr){//you can cancel only if ticket is confirmed
		//parse t
		//copy same code as reserve ticket
		//make that index null, and update status of ticket in wl to cnf
		//add this number to the cancelledseatslist in train.
		String fail="Ticket cancellation failed";
		MyDate doj=pnr.getDoj();
		int trainNo=pnr.getTrainNo();
		int seatNo=pnr.getSeatNo();
		if(seatNo>=100){
			return fail;
		}
		try {
			HashMap<Train,HashMap<String,ArrayList<Ticket>>> trainMap=(ReservationSystem.getMasterRecord(this)).getTrainMapOfDoj(doj);
			//if(trainMap==null){
			//	throw (new NoTrainException());
			//}
			//else{
				Set<Train> trainList=trainMap.keySet();//to make it mutable 
				for(Train t:trainList){
					if(t.getNum()==trainNo){//temp variables:t=>train;n=>ticket
						//continue here
						HashMap<String,ArrayList<Ticket>> statusMap=trainMap.get(t);
						//both status map and TrainList are mutable
						//cancel algorithm
						if((statusMap.get("WL")).isEmpty()){
							statusMap.get("CNF").get(seatNo).removePassenger();
							t.getRac().add(seatNo);
							return new String("Ticket cancelled and record updated");
						}
						else{
							statusMap.get("CNF").set(seatNo, statusMap.get("WL").get(0));//replaces the value...
							statusMap.get("WL").remove(0);
							return new String("Ticket cancelled and record updated");
						}
						//checking through WL first then going through AVL
						/*if((statusMap.get("WL")).isEmpty()){
							int avail=statusMap.get("CNF").size();
							int isZero=100-avail;
							if(isZero==0){
								statusMap.get("WL").add(newTicket);
								return(new String("WL: 1"));
							}
							else{
								statusMap.get("CNF").add(newTicket);
								avail=avail+1;
								return (new String("AVL:"+avail));
							}
						}
						else{
							int wl=statusMap.get("WL").size();
							wl=wl+1;
							statusMap.get("WL").add(newTicket);
							return(new String("WL:"+wl));
						}*/
					//}
					//break;
				//}
				//throw new NoTrainException();
			
					}
				}
			}catch(NoTrainException e){
			e.printStackTrace();
			return fail;
		}
		catch (RailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return fail;
		}
		return fail;
	}
	
	private String printTicket(MyDate doj, int trainNo, int seatNo) {
		// TODO Auto-generated method stub
		PNR pnr=new PNR(doj,trainNo,seatNo);
		return pnr.printDetails();
	}
	
	public ArrayList<Train> showAllTrains(){
		try {
			return ReservationSystem.getTrainList(this);
		} catch (RailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
