package com.railreservation.auxiliary;

import java.io.*;

import com.railreservation.domain.*;

public class DataSource {
	//members
	//This dataFile initially contains one Admin with his details stored in proper format.
	//(ParseType)userId:password:empType;name
	private final File dataFile= new File("C:\\Users\\Bhuvan\\workspace\\RailwayReservation\\login.txt");//(ParseType)userId:password:empType;name\n//emptype=1 if admin and 2 if clerk
	//constructors
	//methods
	public int getEmpType(int empId){
		try{
			FileReader fs=new FileReader(dataFile);
			BufferedReader in=new BufferedReader(fs);
			String line=null;
			while((line = in.readLine())!=null){
				String[] tokens=line.split(":");
				if(Integer.parseInt(tokens[0])==empId){//usage of wrapper classes
					in.close();
					return Integer.parseInt(tokens[2]);
				}
			}
			in.close();
			return 0;//indicates that the employee ID doesn't exist... invalid employee
		}
		catch(IOException e){
			System.err.println("dataFile not found");
			e.printStackTrace();
			return 0;
		}
	}
	public int getPassword(int empId){
		try{
			FileReader fs=new FileReader(dataFile);
			BufferedReader in=new BufferedReader(fs);
			String line=null;
			while((line = in.readLine())!=null){
				String[] tokens=line.split(":");
				if(Integer.parseInt(tokens[0])==empId){//usage of wrapper classes
					in.close();
					return Integer.parseInt(tokens[1]);
				}
			}
			in.close();
			return 0;//indicates that the employee ID doesn't exist... invalid employee
		}
		catch(IOException e){
			System.err.println("dataFile not found");
			e.printStackTrace();
			return 0;
		}
	}
	/*public void setEmployee(int empId,int pwd){//for changing password
		
	}*/
	public void setInitEmpDetails(Admin a,int Id,int password,int type,String name){
		//admins similar function addEmployee is calls this function
		try {
			FileWriter fw= new FileWriter(dataFile,true);
			BufferedWriter out=new BufferedWriter(fw);
			out.write(Id+":"+password+":"+type+":;"+name);
			out.newLine();
			out.close();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void removeEmpDetails(Admin a,int empId){
		//admins similar function removeEmployee is calls this function
				try {
					FileWriter fw= new FileWriter(dataFile);
					BufferedWriter out=new BufferedWriter(fw);
					FileReader fs=new FileReader(dataFile);
					BufferedReader in=new BufferedReader(fs);
					String line=null;
					while((line = in.readLine())!=null){
						String[] tokens=line.split(":");
						if(Integer.parseInt(tokens[0])==empId){//usage of wrapper classes
							//somehow delete that complete line
							in.close();
							out.close();
						}
					}
					in.close();
					out.close();
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	public String getEmpName(int Id) {
		try{
			FileReader fs=new FileReader(dataFile);
			BufferedReader in=new BufferedReader(fs);
			String line=null;
			while((line = in.readLine())!=null){
				String[] tokens=line.split(":");
				
				if(Integer.parseInt(tokens[0])==Id){//usage of wrapper classes
					String tokens1[]=line.split(";");
					System.out.println(tokens[1]);
					in.close();
					return tokens1[1];
				}
			}
			in.close();
			return "0";//indicates that the employee ID doesn't exist... invalid employee
		}
		catch(IOException e){
			System.err.println("dataFile not found");
			e.printStackTrace();
			return "0";
		}
	}
}
