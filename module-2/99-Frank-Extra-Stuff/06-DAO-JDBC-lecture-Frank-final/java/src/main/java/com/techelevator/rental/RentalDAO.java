package com.techelevator.rental;

import java.util.List;

public interface RentalDAO {
	/**********************************************************************************
	 * C.R.U.D. Methods
	 **********************************************************************************/

	/**
	 * 
	 * Return all Rental rows from the database
	 * 
	 * @return List<Rental>
	 */
	
	public List<Rental> getAllRentals();  
	
	/**
	 * 
	 * Return a single Rental row from the database for a given rentalID
	 * 
	 * @param rentalID
	 * @return Rental
	 */
	
	public Rental getRental(int rentalID);
	
	/**
	 * 
	 * Insert a single Rental row from the database given a Rental object
	 * Return the rental object for the row added
	 * 
	 * @return Rental
	 */
	
	public Rental addRental(Rental aRental);
	
	/**
	 * 
	 * Update a Rental row in the database using a given Rental object
	 * 
	 * @param aRental  - Rental object set with data to be update in the database
	 * @return status  - true if row was updated in database / false if not
	 */
	
	public boolean changeRental(Rental aRental);

	/**
	 * 
	 * Delete a Rental row from the database using a given a rentalID
	 * 
	 * @param rentalId  - RentalId of rental to delete in database
	 * @return status   - true if row was deleted / false if not
	 */
	
	public boolean removeRental(int rentalID);
	
}
