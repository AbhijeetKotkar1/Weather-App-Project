/*
 * 
 * @author ABHIJEET KOTKAR
 * 
 */

package com.util;

import java.util.Collections;
import java.sql.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		//Creating a new LinkedList of Weather class objects.
		LinkedList<Weather> list = new LinkedList<>();
	
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		//Weather w[]= new Weather[3];
		
		try{
			
			//Connection to the Oracle Database.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(
		 			"jdbc:oracle:thin:@localhost:1521:XE","ask","ask");
			
			
			//Storing the entries of table WEATHERS into ResultSet rs.
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from weather");
			
			
			
			/*
				while(rs.next()){
					for(int count=1;count<=columns;count++){
						System.out.println(rsData.getColumnLabel(count)+rs.getString(count));
					}
				}
			*/		
			
			//Retrieving data from the database and storing into LinkedList.
			while(rs.next()){
				String city = rs.getString(1);
				String condition=rs.getString(2);
				int maxTemperature=rs.getInt(3);
				int minTemperature=rs.getInt(4);
				Date date=rs.getDate(5);
				
				//Weather w1 = new Weather(city,condition,maxTemperature,minTemperature);

				//Adding Objects of class Weather into the LinkedList.
				list.add(new Weather(city,condition,maxTemperature,minTemperature,date));
				
				//w[i] = new Weather(city,condition,maxTemperature,minTemperature);
				//i++;
			}
				
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
			if(rs!=null)
				con.close();
			if(stmt!=null)
				stmt.close();
			if(con!=null)
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		//LinkedList<Weather> list = new LinkedList<>();
		
		//for(int j=0;j<3;j++)
		//	list.add(w[j]);
		//list.add(w1);
		//list.add(w2);
		//list.add(w3);
		
		//for(Weather obj:list)
		//	System.out.println(obj);
		
		
		//Creating a ListIterator to iterate through the list.
		ListIterator<Weather> it = list.listIterator();
		
		try(Scanner in = new  Scanner(System.in)){
			
			int choice;
			

			do{
			System.out.println("Enter 1.To view the first entry");
			System.out.println("Enter 2.To view the next entry in LinkedList");
			System.out.println("Enter 3.To view the previous entry in the LinkedList");
			System.out.println("Enter 4.To sort the LinkedList using Max Temperature");
			System.out.println("Enter 5.To sort the LinkedList using Min Temperature");
			System.out.println("Enter 6.To display all entries");
			System.out.println("Enter 7.To exit");
			
			choice=in.nextInt();
			
			switch(choice){
			
				case 1:
					//System.out.println("First Entry of list");
					System.out.println(it.next());
					break;
					
				case 2:
					if(it.hasNext())
						System.out.println(it.next());
					else
						System.out.println("\nReached end of list\n");
					break;
					
				case 3:
					if(it.hasPrevious())
						System.out.println(it.previous());
					else
						System.out.println("\nReached end of list\n");
					break;
					
				case 4:
						Collections.sort(list,new Comparator<Weather>(){

						public int compare(Weather o1, Weather o2) {
							if(o1.getMaxTemperature() < o2.getMaxTemperature())
								return -1;
							else if(o1.getMaxTemperature() > o2.getMaxTemperature())
								return 1;
							else
								return 0;
							
						}
						
					});
					System.out.println("Sorted");
					for(Weather l:list){
						System.out.println(l);
					}
					break;
					
				case 5:
					Collections.sort(list,new Comparator<Weather>(){

						public int compare(Weather o1, Weather o2) {
							if(o1.getMinTemperature() < o2.getMinTemperature())
								return -1;
							else if(o1.getMinTemperature() > o2.getMinTemperature())
								return 1;
							else
								return 0;
							
						}
						
					});
					System.out.println("Sorted");for(Weather l:list){
						System.out.println(l);
					}
					break;
					
				case 6:
					for(Weather l:list){
						System.out.println(l);
					}
					break;
					
			}
			}while(choice!=7);
		}
		
		
	}
	
}


/*			DATEBASE
 *  CITY	CONDITION	MAXTEMPERATURE	MINTEMPERATURE	DATE1
	Mumbai	Cloudy			30					19	02/02/2013
	Thane	Clear			40					9	01/01/2012
	Pune	Rain			20					9	03/03/2014
		row(s) 1 - 3 of 3
 */

 