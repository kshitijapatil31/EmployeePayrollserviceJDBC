package com.bridgelabz.employeepayrollservice;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import java.sql.PreparedStatement;

public class EmployeePayrollService {
	
	EmployeePayrollConnection employee = new EmployeePayrollConnection();
	public int readData(String sql) {
		int k = 0;
		
		try {

			Connection con = employee.dataBaseconnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				k++;
				int id = rs.getInt("Id");
				String name = rs.getString("name");
				double basicPay = rs.getDouble("basicPay");
				LocalDate startDate = rs.getDate("start").toLocalDate();
				char gender = rs.getString("gender").charAt(0);
				System.out.println(id + " " + name + " " + " " + basicPay + " " + gender);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return k;
	}

	public int updateData(String name, double pay) throws SQLException {
	

		Connection con = employee.dataBaseconnection();
		Statement stmt = con.createStatement();
		String sql = String.format(
				"update employeepayroll set basicPay='%.2f'where name='%s';", pay,name);
	
		return stmt.executeUpdate(sql);
	}

	public int updatesalary(String name, double pay) throws SQLException  {
	
		Connection con = employee.dataBaseconnection();
		Statement stmt = con.createStatement();
		String sql = String.format(
				"update employeepayroll set basicPay='%.2f'where name='%s';", pay,name);
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		
		return preparedStatement.executeUpdate(sql);
	}
	
	public int employeeData(Date startDate,Date endDate) {
		int k = 0;
		
		try {

			Connection con = employee.dataBaseconnection();
			Statement stmt = con.createStatement();
			String sql = String.format("Select * from employeepayroll where start between '%tF' and '%tF';",startDate,endDate);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				k++;
				int id = rs.getInt("Id");
				String name = rs.getString("name");
				double basicPay = rs.getDouble("basicPay");
				LocalDate sDate = rs.getDate("start").toLocalDate();
				char gender = rs.getString("gender").charAt(0);
				System.out.println(id + " " + name + " " + " " + basicPay + " " + gender);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return k;
	}

	public int sumSalary(String sql) throws SQLException {
		
	int k=0;
		Connection con = employee.dataBaseconnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			k++;		
			String name = rs.getString("name");
			double basicPay = rs.getDouble("sum(basicPay)");
			char gender = rs.getString("gender").charAt(0);
			System.out.println( " " + name + " " + " " + basicPay + " " + gender);
		}
			return k;
		
	}

	public int maxSalary(String sql) throws SQLException {
		int k=0;
		Connection con = employee.dataBaseconnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			k++;		
			String name = rs.getString("name");
			double basicPay = rs.getDouble("max(basicPay)");
			char gender = rs.getString("gender").charAt(0);
			System.out.println( " " + name + " " + " " + basicPay + " " + gender);
		}
			return k;
		
	}

	public int minSalary(String sql) throws SQLException {
		int k=0;
		Connection con = employee.dataBaseconnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			k++;		
			String name = rs.getString("name");
			double basicPay = rs.getDouble("min(basicPay)");
			char gender = rs.getString("gender").charAt(0);
			System.out.println( " " + name + " " + " " + basicPay + " " + gender);
		}
			return k;
		
	}

	public int countSalary(String sql) throws SQLException {
		int k=0;
		Connection con = employee.dataBaseconnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			k++;		
			String name = rs.getString("name");
			double basicPay = rs.getDouble("count(basicPay)");
			char gender = rs.getString("gender").charAt(0);
			System.out.println( " " + name + " " + " " + basicPay + " " + gender);
		}
			return k;
		
	}

}
