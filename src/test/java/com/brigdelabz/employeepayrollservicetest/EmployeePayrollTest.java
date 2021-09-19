package com.brigdelabz.employeepayrollservicetest;

import static org.junit.Assert.assertEquals;

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
}
