package org.sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SampleService {
	static Connection con;
	static Statement st;
	static PreparedStatement ps;
	public static void getAll() throws SQLException {
		con=DBConnection.getConnectionDetails();
		st= con.createStatement();
		ResultSet rs = st.executeQuery(DBQuery.getAll);
		System.out.println("ID   Model   Brand   Date		City");
		while(rs.next()) {
			System.out.println(rs.getString(1)+"    "+rs.getString(2)+"    "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5));
		}
	}
	public static void insertMethod(int id,String model,String brand,String date,String city) throws SQLException {
		con = DBConnection.getConnectionDetails();
		ps = con.prepareStatement(DBQuery.insert);
		ps.setInt(1, id);
		ps.setString(2, model);
		ps.setString(3, brand);
		ps.setString(4, date);
		ps.setString(5, city);
		int c = ps.executeUpdate();
		System.out.println(c + " Data inserted Successfully");
	} 
	public static void getById(int id) throws SQLException {
		con=DBConnection.getConnectionDetails();
		ps=con.prepareStatement(DBQuery.getById);
		ps.setInt(1, id);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
		}
	}

}
