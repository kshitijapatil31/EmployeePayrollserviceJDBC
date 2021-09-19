package com.brigdelabz.employeepayrollservicetest;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.employeepayrollservice.EmployeePayrollService;

import com.bridgelabz.employeepayrollservice.EmployeePayrollConnection;

public class EmployeePayrollTest {

	
	
	@Test
	public void connectionIsSuccessfull_shouldReturnTrue() {
		EmployeePayrollConnection employeePayroll=new EmployeePayrollConnection();
		Assert.assertTrue(employeePayroll.dataBaseconnection()!=null);
		
	}
	@Test
	public void givenEmployeeData_shouldReturnListOfEmployeeData(){
		EmployeePayrollService employeePayroll=new EmployeePayrollService();
        String sql="select * from employeepayroll";
		int size=employeePayroll.readData(sql);
		Assert.assertEquals(4, size);
	}
	@Test
	public void updateEmployeeSalary_shouldPassTest() throws SQLException  {
		EmployeePayrollService employeePayroll=new EmployeePayrollService();
    	  int employee =employeePayroll.updateData("terisa",3000000.00);
       
       assertEquals(2,employee);
      
	}
	@Test
	public void updateEmployeeSalary_UsingPreparedStatement_ShouldPassTest() throws SQLException {
		EmployeePayrollService employeePayroll=new EmployeePayrollService();
		
		int employee=employeePayroll.updatesalary("terisa",3000000.00);
		assertEquals(2,employee);
	}
	
	@Test
	public void givenStartAndEndDate_retriveAllEmployee() {
		EmployeePayrollService employeePayroll=new EmployeePayrollService();
        Date startDate=Date.valueOf("2018-01-01");
        Date endDate=Date.valueOf("2019-01-31");
		int size=employeePayroll.employeeData(startDate,endDate);
		Assert.assertEquals(2, size);
	}
	
	@Test
	public void givenEmployeeData_shouldReturnSumOFSalary() throws SQLException{
		EmployeePayrollService employeePayroll=new EmployeePayrollService();
        String sql="select name,gender,sum(basicPay) from employeepayroll  group by gender";
		int size=employeePayroll.sumSalary(sql);
		Assert.assertEquals(2, size);
	}
	@Test
	public void givenEmployeeData_shouldReturnMaxOFSalary() throws SQLException{
		EmployeePayrollService employeePayroll=new EmployeePayrollService();
        String sql="select  name,gender,max(basicPay) from employeepayroll  group by gender";
		int size=employeePayroll.maxSalary(sql);
		Assert.assertEquals(2, size);
	}
	@Test
	public void givenEmployeeData_shouldReturnMinOFSalary() throws SQLException{
		EmployeePayrollService employeePayroll=new EmployeePayrollService();
        String sql="select  name,gender,min(basicPay) from employeepayroll  group by gender";
		int size=employeePayroll.minSalary(sql);
		Assert.assertEquals(2, size);
	}
	@Test
	public void givenEmployeeData_shouldReturnCountOFSalary() throws SQLException{
		EmployeePayrollService employeePayroll=new EmployeePayrollService();
        String sql="select name,gender, count(basicPay) from employeepayroll  group by gender";
		int size=employeePayroll.countSalary(sql);
		Assert.assertEquals(2, size);
	}
}
