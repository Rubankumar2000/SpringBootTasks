package org.sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SampleController {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		boolean flag=true;
		while(flag) {
			int key=sc.nextInt();
		switch (key) {
		case 1: {
			SampleService.getAll();
			break;
		}
		case 2: {
			int id=sc.nextInt();
			String model=sc.next();
			String brand=sc.next();
			String date=sc.next();
			String city=sc.next();
			SampleService.insertMethod(id,model,brand,date,city);
			break;
		}
		case 3: {
			int id=sc.nextInt();
			SampleService.getById(id);
			break;
		}
		case 4: {
			flag=false;
			break;
		}
		default:
			System.out.println("Unexcepted Value");
			flag=false;
			break;
		}
	}
	}

}
