package com.bridgelabz.employeepayrollservice;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
public class EmployeePayrollDBService {

	public int readData(String sql){
		int k=0;
		EmployeePayrollService employee=new EmployeePayrollService();
		try {
			
			Connection con=employee.dataBaseconnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				k++;
				int id=rs.getInt("Id");
				String name=rs.getString("name");
				double basicPay=rs.getDouble("basicPay");
				LocalDate startDate=rs.getDate("start").toLocalDate();
				char gender=rs.getString("gender").charAt(0);
				System.out.println(id+" "+name+" "+" "+basicPay+" "+gender);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return k;
	}

	
}
