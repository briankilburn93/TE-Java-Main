package com.techelevator.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.DepartmentDAO;
import com.techelevator.model.Employee;
import com.techelevator.model.EmployeeDAO;

@RestController // Tells the server there are controllers in this file
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

	@RequestMapping(path="/employees/namesearch",method=RequestMethod.GET)
	public List<Employee> searchEmployeeName(@RequestParam(value="firstName",defaultValue="") String firstNameSearch
	                                        ,@RequestParam(value="lastName",defaultValue="")  String lastNameSearch ) {
		
		List<Employee> anEmployee = employeeDAO.searchEmployeesByName(firstNameSearch, lastNameSearch);
		logAPICall("GET-/employees/namesearch" + firstNameSearch + " " + lastNameSearch);
		return anEmployee;
	}
	
	public void logAPICall(String message) {
		 LocalDateTime now = LocalDateTime.now();
	     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss.A");
	     String timeNow = now.format(formatter);
	     System.out.println(timeNow + ": " + message);
	 }
}
