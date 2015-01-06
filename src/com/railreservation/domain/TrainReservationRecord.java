package com.railreservation.domain;

import java.io.Serializable;
import java.util.*;
import com.railreservation.auxiliary.*;

import com.railreservation.railexceptions.InvalidPermissionException;
//used just as typedef
public class TrainReservationRecord implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//members
	HashMap<MyDate,HashMap<Train,HashMap<String,ArrayList<Ticket>>>> record=new HashMap<MyDate,HashMap<Train,HashMap<String,ArrayList<Ticket>>>>();
	/*important points:
	 *ADDING:
	 * whenever new {key,value} is added actually a new copy of objects referred by the parameters is added.
	 * this ensures that for each day a separate train with its own seat map is maintained
	 * same goes with add function of array list.
	 * GETTING:
	 * whenever getting a value mapped to a key in my record, the object equality overriden function in "Train" and "MyDate" ensures
	 * that the hashmap's .get() method gives me back the right value.
	 * the same goes with getting in array list
	 * REMOVING
	 * same with the removing functions
	*/
	//methods
	public void updateToday(ArrayList<Train> trainList,MyDate today){//actually today+1 would have been better
		MyDate newMyDate=addDays(today,29);//returns a new object
		record.remove(addDays(today,-1));//date equality ensues the identical object is removed
		record.put(newMyDate, getTrainMapForNewDay(trainList,newMyDate));
	}
	private MyDate addDays(MyDate d, int days)//immutable
    {
        MyDate newDate=new MyDate(d.getTime());
		newDate.setTime(d.getTime() + days * 1000 * 60 * 60 * 24);
        return newDate;//returning new object
    }
	public HashMap<Train, HashMap<String, ArrayList<Ticket>>> getTrainMapOfDoj(MyDate doj){//mutable(checked)
		HashMap<Train,HashMap<String,ArrayList<Ticket>>> trainMap=record.get(doj);
		System.out.println("record is of size: "+record.size());
		System.out.println("TrainMap (getTrainMapOfDoj) : "+trainMap.keySet().size());
		return trainMap;
		//ArrayList<Train> trainList=new ArrayList<Train>((record.get(doj)).keySet());//MyMyDate objects are equal only if dd/mm/yyyy is equal
		/*Set<Train> trainList=(record.get()).keySet();//MyMyDate objects are equal only if dd/mm/yyyy is equal

		System.out.println("(inside record)TrainListOfDOJ:trainList is of size: "+trainList.size());
		for(Train t : trainList){
			for(Integer i : t.getDaysOfTrl()){
				if(doj.getDay()==i.intValue()){
					trainMap=record.get(doj);//MyMyDate objects are equal only if dd/mm/yyyy is equal
					return trainMap;
				}
			}
		}*/
		//return null;
	}
	public void loadInitialRecord(Admin a,ArrayList<Train> trainList,MyDate init){//initially reads from train list and adds 
		MyDate newMyDate=init;//doing from the next day is better
		for(int i=0;i<30;i++){
			record.put(newMyDate, getTrainMapForNewDay(trainList,newMyDate));
			newMyDate=addDays(newMyDate,1);//incrementing newMyDate and getting a NEW object with next date
			System.out.println("record initialized:"+i);
		}
		System.out.println("record loaded:");
		System.out.println("record is of size: "+record.size());
	}
	@SuppressWarnings("deprecation")
	private HashMap<Train, HashMap<String, ArrayList<Ticket>>> getTrainMapForNewDay(ArrayList<Train> trainList,MyDate day){//returns NEW TRAIN MAP for that particular day
		HashMap<Train,HashMap<String,ArrayList<Ticket>>> trainMap=new HashMap<Train,HashMap<String,ArrayList<Ticket>>>();
		System.out.println("LOADING: parameter trainlist size:"+trainList.size());
		int j=1;
		for(Train t : trainList){
			System.out.println("LOADING: train to master record :"+j);
			for(Integer i : t.getDaysOfTrl()){
				if(day.getDay()==i.intValue()){
					HashMap<String,ArrayList<Ticket>> seatMap=new HashMap<String,ArrayList<Ticket>>();
					seatMap.put("WL", new ArrayList<Ticket>());
					seatMap.put("CNF", new ArrayList<Ticket>());//AVL=>available booked as CNF(confirmed)
					trainMap.put(t.getCopy(),seatMap);//this is a NEW train copy that is added into the record
					//return trainMap;
				}
			}
			j++;
		}
		System.out.println("LOADING: curr trainmap size:"+trainMap.keySet().size());
		return trainMap;//null should be returned to ensure if no trains run on that day
	}
	public void clearMasterRecord(Admin e) throws InvalidPermissionException{
		for(Employee t : ReservationSystem.getEmployeeList()){
			if(t==e){
				System.out.println("RECORD WASHED OUT");
				this.record.clear();
			}
		}
		throw  new InvalidPermissionException();
	}
}
