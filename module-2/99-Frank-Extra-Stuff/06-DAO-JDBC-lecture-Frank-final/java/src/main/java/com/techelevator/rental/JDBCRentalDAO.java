package com.techelevator.rental;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCRentalDAO implements RentalDAO{

private JdbcTemplate myJdbcTemplate;  // declare an JdbcTemplate variable
	
	// constructor that takes datasource and assigns to JdbcTemplate object
	
	public JDBCRentalDAO(DataSource aDataSource) {
		this.myJdbcTemplate = new JdbcTemplate(aDataSource);  // instantiate and initialize JdbcTemplate with datasource
	}

	
	@Override
	public List<Rental> getAllRentals() {
		
		List<Rental> allRentals = new ArrayList<Rental>();
		
		// Note use of coalesce in Select to convert any null return_date to a specific value
		//      also note as to assign value returned from coalesce to return_date (the column name)
		
		String getRentalsSQL =  "Select rental_id"
	                          + "      ,rental_date"
	    		              + "      ,inventory_id"
	    		              + "      ,coalesce(return_date,TO_TIMESTAMP('01/01/0001 00:00:00', 'MM/DD/YYYY HH24:MI:SS')) as return_date"
	    		              + "      ,customer_id"
	    		              + "      ,staff_id"
				              + " from Rental";
		try {
			SqlRowSet sqlResults = myJdbcTemplate.queryForRowSet(getRentalsSQL);
		
			while (sqlResults.next()) {  // Loop through each row in the SqlRowSet
				allRentals.add(mapRowToRental(sqlResults));  // Create a Rental from row and add to ArrayList	
			}	 
		}
		catch (DataAccessException daeObject) {
			System.out.println("!!!!!!!!! Uh-Oh !!!!!!!!! Uh-Oh !!!!!!!!!");
			System.out.println("Data Access Exception (DAE) trying to get Rentals from database: ");
			System.out.println("DAE Cause: " + daeObject.getCause());
			System.out.println("DAE Message: " + daeObject.getMessage());
			System.out.println("Stack Trace: ");
			daeObject.printStackTrace();
			System.out.println("returning null List to caller");
		    return null;
		}
		catch (Exception exceptionObject) {
			System.out.println("!!!!!!!!! Uh-Oh !!!!!!!!! Uh-Oh !!!!!!!!!");
			System.out.println("Un-expected Exception in mapRowToRental(): ");
			System.out.println("Cause reported as: " + exceptionObject.getCause());
			System.out.println("Exception Message: " + exceptionObject.getMessage());
			System.out.println("returning null List to caller");
		    return null;
		}
		
		return allRentals;
	}

	@Override
	public Rental getRental(int rentalId) {
		
		 Rental aRental = null;    // Return object - initially unknown of rental requested will be found
		
		 String getARentalSQL =  "Select rental_id"
                               + "      ,rental_date"
	                           + "      ,inventory_id"
	                           + "      ,coalesce(return_date,TO_TIMESTAMP('01/01/0001 00:00:00', 'MM/DD/YYYY HH24:MI:SS')) as return_date"
	                           + "      ,customer_id"
	                           + "      ,staff_id"
	                           + " from Rental"
	                           + " where rental_id = ?";  // ? willbe rpelaced by parameter passed to method when run
		
		 SqlRowSet sqlResults = myJdbcTemplate.queryForRowSet(getARentalSQL, rentalId);  // Run SQL with rentalId parameter passed
		
		 if (sqlResults.next()) {                   // If row found in rental table
			 aRental = mapRowToRental(sqlResults);  //     Create Rental object from irt and assign to return object
		 }
		
	return aRental;  // aRental will either be a valid Rental object or null depending in whether or not row was found in table
	}

	
	@Override
	public Rental addRental(Rental newRental) {
		
		Rental aRental = newRental;  // copy of parameter so we don't change parameter
		
		aRental.setRentalId((int) getNextRentalId());  // Get next serial value for rentalId and set in Rental Object
		
		String addRentalSQL = "Insert into Rental ("
				            + " rental_Id "  
				            + ",rental_Date "  
				            + ",inventory_Id "  
				            + ",customer_Id " 
				            + ",return_Date "  
				            + ",staff_Id"
				            + ")"
				            + "Values (?,?,?,?,?,?)"; // one placeholder ? for each column value in row
		 myJdbcTemplate.update(addRentalSQL ,aRental.getRentalId()   
				                            ,aRental.getRentalDate()  
				                            ,aRental.getInventoryId()  
				                            ,aRental.getCustomerId()  
				                            ,aRental.getReturnDate()   
				                            ,aRental.getStaffId()
				               );
		return newRental;
	}

	@Override
	public boolean changeRental(Rental aRental) {
		String changeRentalSQL = "update rental "
				               + " Set   rental_Date  = ?"
				               + "      ,inventory_Id = ?"
				               + "      ,customer_Id  = ?"
				               + "      ,return_Date  = ?"
				               + "      ,staff_Id     = ?"
				               + " where rental_Id    = ?";
	
		int numRowsAffected = myJdbcTemplate.update(changeRentalSQL
				                                   , aRental.getRentalDate()
				                                   , aRental.getInventoryId()
				                                   , aRental.getCustomerId()
				                                   , aRental.getReturnDate()
				                                   , aRental.getStaffId()
				                                   , aRental.getRentalId());
		
	return numRowsAffected == 1;  // Since rentalId is the primary key only 1 or 0 rows can be updated		return false;
	}

	@Override
	public boolean removeRental(int rentalId) {
	
		String removeRentalSQL = "Delete from rental where rentalId = ?";
		
		int numRowsAffected = myJdbcTemplate.update(removeRentalSQL, rentalId);
		
	return numRowsAffected == 1;  // Since rentalId is the primary key only 1 or 0 rows can be updated
	}
	/**********************************************************************************
	 * Helper / Support Methods
	 **********************************************************************************/
     //*********************************************************************************
	 // Instantiate Rental Object populated from SQL result
	 //*********************************************************************************
	
	private Rental mapRowToRental(SqlRowSet resultsFromSQL) { 
		
		Rental aRental = new Rental();  // Create a default Rental object
		try {
		aRental.setRentalId(resultsFromSQL.getInt("rental_id"));                  // Get next serial value and set RentalId
		aRental.setStaffId(resultsFromSQL.getInt("staff_id"));        // Set staff id from SQL result
		aRental.setCustomerId(resultsFromSQL.getInt("customer_id"));  // Set customer id from SQL result
		aRental.setInventoryId(resultsFromSQL.getInt("inventory_id"));// Set inventory id from SQL result
		aRental.setRentalDate((LocalDateTime)resultsFromSQL.getTimestamp("rental_date").toLocalDateTime()); // Set rental date from SQL result
		aRental.setReturnDate((LocalDateTime)resultsFromSQL.getTimestamp("return_date").toLocalDateTime()); // Set return date from SQL result
		}
		catch (DataAccessException daeObject) {
			System.out.println("!!!!!!!!! Uh-Oh !!!!!!!!! Uh-Oh !!!!!!!!!");
			System.out.println("Data Access Exception (DAE) in mapRowToRental(): ");
			
			System.out.println("DAE Cause: " + daeObject.getMostSpecificCause());
			System.out.println("DAE Message: " + daeObject.getMessage());
			System.out.println("Stack Trace: ");
			daeObject.printStackTrace();
			System.out.println("returning null Rental object to caller");
		    return null;
		}
		catch (Exception exceptionObject) {
			System.out.println("!!!!!!!!! Uh-Oh !!!!!!!!! Uh-Oh !!!!!!!!!");
			System.out.println("Un-expected Exception in mapRowToRental(): ");
			System.out.println("Cause reported as: " + exceptionObject.getCause());
			System.out.println("Exception Message: " + exceptionObject.getMessage());
			exceptionObject.printStackTrace();
			System.out.println("returning null Rental object to caller");
		    return null;
		}
		return aRental;
	
	}
	
	 //*********************************************************************************
	 // return the next serial value for rental_id from the data base manager
	 //*********************************************************************************
	
	private long getNextRentalId() {
		SqlRowSet nextIdResult = myJdbcTemplate.queryForRowSet("SELECT nextval('rental_rental_id_seq')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new Rental");
		}
	}


	
	
	
}
