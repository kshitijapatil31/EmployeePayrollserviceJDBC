package com.bridgelabz.employeepayrollservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
public class EmployeePayrollService {
	Statement stmt;
	Connection con;
	public int readData(String sql){
		int k=0;
		EmployeePayrollConnection employee=new EmployeePayrollConnection();
		try {
			
			con=employee.dataBaseconnection();
			 stmt=con.createStatement();
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

	public int updateData(String name,double pay)throws SQLException  {
		String sql=null;
		EmployeePayrollConnection employee=new EmployeePayrollConnection();
		try {
			
			Connection con=employee.dataBaseconnection();
			stmt=con.createStatement();
		    sql=String.format("update payroll set basicPay='%.2f'where empId In(select empId from employee where name='%s');", pay,name);
			ResultSet rs=stmt.executeQuery(sql);
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	
		return stmt.executeUpdate(sql);
	}

	
}
