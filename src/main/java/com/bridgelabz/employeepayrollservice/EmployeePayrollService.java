package com.bridgelabz.employeepayrollservice;

import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement ;
import java.util.Enumeration;

import java.sql.Driver;

import java.sql.Connection;

public class EmployeePayrollService {

	public static void main(String[] args) {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/employee_payroll_service";
		String username="root";
		String password="edac20";
	try {
		Class.forName(driver);
		
	}catch(Exception e) {
		throw new IllegalStateException("driver not found");
		
	}
	listDrivers();

	try {
		Connection con=DriverManager.getConnection(url,username,password);
		Statement stmt=con.createStatement();
		System.out.println("Connection is established"+con);
		con.close();
	}catch(Exception e) {
		System.out.println(e);
		
	}
	}

	private static void listDrivers() {
	
		Enumeration<Driver> driverList=DriverManager.getDrivers();
		while(driverList.hasMoreElements()) {
			Driver driverClass=(Driver)driverList.nextElement();
			System.out.println(" "+driverClass.getClass().getName());
		}
		
	}

}
