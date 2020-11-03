package com.techelevator.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.DepartmentDAO;
import com.techelevator.model.Employee;
import com.techelevator.model.EmployeeDAO;



public class EmployeeController {
	
private EmployeeDAO   employeeDAO;  // Define a reference to the EmployeeDAO

// Create a constructor for the controller class that takes a DAO object as a parameter
//  Spring dependency injection will create an instance of the DAO and pass it to the constructor
	public EmployeeController(EmployeeDAO empDAO) {   
		this.employeeDAO = empDAO;
	}
	
	
	@RequestMapping(path="/employees", method=RequestMethod.GET)
	public List<Employee> allEmployees() {
		logAPICall("GET-/employees");
		return employeeDAO.getAllEmployees();
	}

	public void logAPICall(String message) {
		 LocalDateTime now = LocalDateTime.now();
	     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss.A");
	     String timeNow = now.format(formatter);
	     System.out.println(timeNow + ": " + message);
	 }
}
