package com.techelevator.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Controller to authenticate users.
 */

public class DepartmentController {
	
public void logAPICall(String message) {
	 LocalDateTime now = LocalDateTime.now();
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm/dd/yyyy HH:mm:ss.A");
     String timeNow = now.format(formatter);
     System.out.println(timeNow + "-" + message);
 }
}


