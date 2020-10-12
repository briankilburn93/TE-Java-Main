package com.techelevator.frank;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;

public class HobbyCollectionApp {

	public static void main(String[] args) throws FileNotFoundException {
		
		//Use LocalDateTime.now() to get the current date and time to millisecond
		//	LocalDate.now() current date
		//	LocalTime.now to get the time to millisecond
		 
		System.out.println("Welcome to My Hobby Collection Program!");
		System.out.println("You started it on: " + LocalDateTime.now());
		
		// Instantiate a default CollectionOfThings object
		CollectionOfThings myCollection = new CollectionOfThings();
		
		// Display the contents of the CollectionOfThings object
		myCollection.displayCollection();
		
		System.out.println("\nI Hope you enjoyed My Hobby Collection Program!");
		System.out.println("You ended it on: " + LocalDateTime.now());
	}
}
