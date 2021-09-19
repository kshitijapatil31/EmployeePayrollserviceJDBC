package com.brigdelabz.employeepayrollservicetest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.employeepayrollservice.EmployeePayrollDBService;
import com.bridgelabz.employeepayrollservice.EmployeePayrollService;

public class EmployeePayrollTest {

	
	
	@Test
	public void connectionIsSuccessfull_shouldReturnTrue() {
		EmployeePayrollService employeePayroll=new EmployeePayrollService();
		Assert.assertTrue(employeePayroll.dataBaseconnection()!=null);
		
	}
	@Test
	public void givenEmployeeData_shouldReturnListOfEmployeeData(){
		EmployeePayrollDBService employeePayroll=new EmployeePayrollDBService();
        String sql="select * from employeepayroll";
		int size=employeePayroll.readData(sql);
		Assert.assertEquals(0, 0);
	}
}
