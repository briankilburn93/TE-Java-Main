package com.techelevator;



import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;
import com.techelevator.rental.JDBCRentalDAO;
import com.techelevator.rental.Rental;
import com.techelevator.rental.RentalDAO;

public class DAOExample {

	public static void main(String[] args) {
	
		Scanner userInput = new Scanner(System.in);  // In case we want to ask user a question
		
		BasicDataSource dvdstoreDataSource = new BasicDataSource();
		dvdstoreDataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore");
		dvdstoreDataSource.setUsername("postgres");
		dvdstoreDataSource.setPassword("postgres1");
		
		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
		
		RentalDAO myRentalDAO = new JDBCRentalDAO(dvdstoreDataSource);
		
		CityDAO aCityDao      = new JDBCCityDAO(worldDataSource);  // Instantiate CityDAO object
	
		
		System.out.println("Welcome to a demonstation of using DAOs for accessing databases from Java\n");
		
		System.out.println("First we will add a new city in Kansas named Smallville to the City table");
		System.out.println("and retrieve it...\n");
		
		City smallville = new City();       // Instantiate object to be added to database
		smallville.setCountryCode("USA");   // Use the object
		smallville.setDistrict("KS");       //      setter methods
		smallville.setName("Smallville");   //          to populated
		smallville.setPopulation(42080);    //             the instance data members
		
		// Note the primary key, cityID, was not populated as the save method will obtain
		//      the next serial value and populate the cityId when saving to the data base
		//
		// After the save() method, the object passed will have the cityId populated
		//      with the correct primary key value.
		//
		// If a cityId was populated before the call to the save() method
		//      it will be overlaid (changed) by the save() method
		
		aCityDao.save(smallville);          // Use the dao save method to save the object in the database
		
		City theCity = aCityDao.findCityById(smallville.getId()); // use dao to find the City in the database we just added
		System.out.println("City retrieved :" + theCity);         // Display the City retrieved from the database
		
		printDashes(80);    // Helper method for main() to display dashes across the screen
//-------------------------------------------------------------------------------------------------------------			
		System.out.print("Do you want to list all Rentals (y/n) ");
		if (userInput.nextLine().substring(0,1).toLowerCase().equals("y")) {
			System.out.println("OK, please wait a sec while I go get them...\n");
		
			List<Rental> theRentals = myRentalDAO.getAllRentals();
		
			for (Rental aRental : theRentals) {
				System.out.println("Rental #" + aRental.getRentalId());
				System.out.println(aRental);
				printDashes(80);    // Helper method for main() to display dashes across the screen
			}
		}
		
		System.out.println("Looking for specific Rentals\n");
		int rentalWeWant = 10286;   // This rental exists in Rental table
		System.out.println("Rental " + rentalWeWant + ": " + myRentalDAO.getRental(rentalWeWant));

		printDashes(80);    // Helper method for main() to display dashes across the screen	
		
		rentalWeWant = 0;   // This rental DOES NOT exist in Rental table
		System.out.println("Rental " + rentalWeWant + ": " + myRentalDAO.getRental(rentalWeWant));

		printDashes(80);    // Helper method for main() to display dashes across the screen
		
		//-------------------------------------------------------------------------------------------------------------			
		
		rentalWeWant = 10286;   // This rental exists in Rental table
		
		System.out.println("Changing return date for Rental " + rentalWeWant + " to now...\n");
		
		Rental aRental = myRentalDAO.getRental(rentalWeWant);  // Get the Rental from the table
		System.out.println("Rental " + rentalWeWant + ": " + aRental);
		
		aRental.setReturnDate(LocalDateTime.now());            // Change the return_date
		
		myRentalDAO.changeRental(aRental);                     // Call DAO change method
		
		System.out.println("Rental " + aRental.getRentalId() + ": " + myRentalDAO.getRental(aRental.getRentalId()));
	
		printDashes(80);    // Helper method for main() to display dashes across the screen

	
	//-------------------------------------------------------------------------------------------------------------			
	
		int staffId = 2;
		int custId = 352;
		int invId  = 319;
		
		Rental aNewRental = new Rental(invId, custId, staffId);
		
		System.out.println("Adding Rental Object: " + aNewRental);
		
		Rental addedRental = myRentalDAO.addRental(aNewRental);
		
		System.out.println("new Rental Object in table: " + addedRental);
		
	//-------------------------------------------------------------------------------------------------------------			
		
		System.out.println("\n Thanks for participating in our humble demonstration!\n");
		
		
}
	public static void printDashes(int numDashes) {
		for (int i=0; i < numDashes; i++) {
			System.out.print("-");
		}
		System.out.println("");
	}
}
