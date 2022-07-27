package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbc = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String password = "hbstudent";
		try {
			System.out.println("Connecting to DB");
			
			Connection myConn = DriverManager.getConnection(jdbc, user, password);
			
			System.out.println("Successful connection");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
