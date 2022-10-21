package org.laptop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class Laptop {
 
	 public static void main(String[] args) throws ClassNotFoundException, SQLException
	    {
		 Scanner sc=new Scanner(System.in);
		 CreateLap cl=new CreateLap();
	     Class.forName("oracle.jdbc.driver.OracleDriver");
	     boolean flag=true;
	     do {
	     	int count=1;
	    	 System.out.println(count+++". Insert");
	    	 System.out.println(count+++". Update");
	    	 System.out.println(count+++". Delete");
	    	 System.out.println(count+++". View");
	    	System.out.println("Enter the value by order");
	    	int num=sc.nextInt();
	    	 switch (num) {
			case 1: {
				System.out.println("Enter model");
				 String model=sc.next();
				 System.out.println("Enter place");
				 String place=sc.next();
				 System.out.println("Enter date");
				 String date=sc.next();
				 System.out.println("Enter brand");
				 String brand=sc.next();
				 cl.createLaptop(model,place,date,brand);
				break;
			}
			case 2: {
				System.out.println("Enter model name");
				 String model=sc.next();
				 System.out.println("Enter place");
				 String place=sc.next();
				 System.out.println("Enter date");
				 String date=sc.next();
				 System.out.println("Enter brand");
				 String brand=sc.next();
				 cl.updateLaptop(model,place,date,brand);
				break;
			}
			case 3: {
				System.out.println("Enter model");
				String model=sc.next();
				cl.deleteLaptop(model);
				break;
			}
			case 4: {
				cl.viewLaptop();
				break;
			}
			case 5: {
				flag=false;
				break;
			}
			default:
				System.out.println("Enter a valid number.");
				break;
			}
			
		} while (flag);
	     
	    }
	 
	
	
	

}

