package com.bridgelabz.employeepayrollservice;

import java.sql.DriverManager;
import java.sql.Statement ;
import java.util.Enumeration;
import java.sql.Driver;
import java.sql.Connection;




public class EmployeePayrollConnection {
	Connection con ;

	public Connection dataBaseconnection(){
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/employee_payroll_service?userSSL=false";
		String username="root";
		String password="edac20";

	try {
		Class.forName(driver);
		
	}catch(Exception e) {
		throw new IllegalStateException("driver not found");
		
	}
	listDrivers();

	try {
		con=DriverManager.getConnection(url,username,password);
		Statement stmt=con.createStatement();
		
		
	}catch(Exception e) {
		System.out.println(e);
		
	}
	return con;
	}

	private static void listDrivers() {
	
		Enumeration<Driver> driverList=DriverManager.getDrivers();
		while(driverList.hasMoreElements()) {
			Driver driverClass=(Driver)driverList.nextElement();
			System.out.println(" "+driverClass.getClass().getName());
		}
		
	}


	

}
