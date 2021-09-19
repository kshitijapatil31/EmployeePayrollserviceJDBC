package com.bridgelabz.employeepayrollservice;

import java.sql.Connection;
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
				"update payroll set basePay='%.2f'where empId In(select empId from employee where empName='%s');", pay,
				name);
	
		return stmt.executeUpdate(sql);
	}

	public int updatesalary(String name, double pay) throws SQLException  {
	
		Connection con = employee.dataBaseconnection();
		Statement stmt = con.createStatement();
		String sql = String.format(
				"update payroll set basePay='%.2f'where empId In(select empId from employee where empName='%s');", pay,
				name);
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		
		return preparedStatement.executeUpdate(sql);
	}

}
