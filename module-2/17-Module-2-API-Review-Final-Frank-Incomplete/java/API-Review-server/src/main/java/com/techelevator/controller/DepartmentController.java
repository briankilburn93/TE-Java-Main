package com.techelevator.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.Department;
import com.techelevator.model.DepartmentDAO;
import com.techelevator.model.Employee;
import com.techelevator.model.EmployeeDAO;

/**
 * Controller to get the department data via API call
 */
@RestController  // Tell the server there are controllers in this file
public class DepartmentController {
	
	private DepartmentDAO deptDAO;      // Define a reference to the DepartmentDAO
	private EmployeeDAO   employeeDAO;  // Define a reference to the EmployeeDAO
	
	// Create a constructor for the controller class that takes a DAO object as a parameter
	//     Spring dependency injection will create an instance of the DAO and pass it to the constructor
	public DepartmentController(DepartmentDAO aDeptDAO, EmployeeDAO empDAO) {   
		this.deptDAO     = aDeptDAO;    // assign the DAO object passed to our DAO reference
	    this.employeeDAO = empDAO;
	}
	
// We want a controller to return all departments in the Department table
// Is there a DAO method to return all departments? Yes - getAllDepartments() in DepartmentDAO
// What path do we want the API caller to use to getAllDepartments? /departments

// identify the method to handle GET requests for that path /departments
@RequestMapping(path="/departments", method=RequestMethod.GET)  
public List<Department> getAllDepartments() {
	logAPICall("GET-/departments");  // Log the API call
	return deptDAO.getAllDepartments();
}
	
// We want a controller to return a specific department in the Department table
// Is there a DAO method to return a specific department? - getDepartmentById(Long id)
// What paths do we want the API caller to use? /departments/{id}

@RequestMapping(path="/departments/{id}", method=RequestMethod.GET)
public Department getDepartment(@PathVariable Long id) {
	logAPICall("GET-/departments/" + id);
	return deptDAO.getDepartmentById(id);
}

// We want a controller to return departments in the Department table based on the name
// Is there a DAO method to return a specific department? - searchDepartmentsByName(String nameSearch)
// Is there a default department name we want to use? Yes - empty string
// What paths do we want the API caller to use? /departments/search?name=whatever
@RequestMapping(path="/departments/search", method=RequestMethod.GET)
//      Get the parameter name from the query string and store it in the method parameter nameSearch
//      Provide a default value of empty string if name is not specified in the query string
//                        if name if an empty string - all departments by the DAO
public List<Department> getDepartmentByName(@RequestParam(value="name", defaultValue="") String nameSearch) {
	logAPICall("GET-/departments/search?name=" + nameSearch);
	return deptDAO.searchDepartmentsByName(nameSearch);
}

// We want to add a department
// Do we have DAO? Yes - createDepartment(Department newDepartment)
// What path? /departments with a POST request
@RequestMapping(path="/departments", method=RequestMethod.POST)
// The data for the new Department will in the request body for the POST
// @RequestBody tells the server to take the JSON from the body of a POST or PUT
//           and create an object of the class given with name given
//           here we are creating a Department Object called aDepartment from JSON 
 //                 in the request body of the POST
public Department addDepartment(@RequestBody Department aDepartment) {
	logAPICall("POST-/departments " + aDepartment);
	return deptDAO.createDepartment(aDepartment);
}


// Write a message to the Server console - used to keep a record of server interactions
public void logAPICall(String message) {
	 LocalDateTime now = LocalDateTime.now();
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss.A");
     String timeNow = now.format(formatter);
     System.out.println(timeNow + ": " + message);
 }
}

