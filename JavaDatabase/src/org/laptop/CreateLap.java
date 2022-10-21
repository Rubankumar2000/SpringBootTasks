package org.laptop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateLap {
	public static void createLaptop(String model,String place,String date,String brand) {
		 try {
			 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System", "root");
			 String str="insert into hr.Laptop values(?,?,?,?)";
			 PreparedStatement ps=con.prepareStatement(str);
			 ps.setString(1, model);
			 ps.setString(2, place);
			 ps.setString(3, date);
			 ps.setString(4, brand);
			 int c = ps.executeUpdate();
		     System.out.println(c + "data stored successfully");
		        
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }

	public static void deleteLaptop(String model) {
		 try {
			 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System", "root");
					String str="delete from hr.laptop where model=?1";
					PreparedStatement ps = con.prepareStatement(str);
					ps.setString(1, model);
					int c=ps.executeUpdate();
					System.out.println("data deleted..");
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	public static void viewLaptop() {
		 try {
			 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System", "root");
			String str="select * from hr.laptop";
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(str);
			System.out.println("Model  Place   Date  Brand");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateLaptop(String model,String place,String date,String brand) {
		 try {
			 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System", "root");
					String str="update hr.laptop set place=?,manufacture_date=?,brand=? where model=?";
					PreparedStatement ps = con.prepareStatement(str);
					ps.setString(1, place);
					ps.setString(4, model);
					ps.setString(2, date);
					ps.setString(3, brand);
					ps.executeUpdate();
					System.out.println("data updated..");
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

}
