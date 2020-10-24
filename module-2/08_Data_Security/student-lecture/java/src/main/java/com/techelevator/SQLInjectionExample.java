package com.techelevator;

import java.util.Scanner;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/* This is a simple example using the dvdstore database to show how SQL Injection works
 * 
 * Try entering these values:
 * 
 * 1) 270
 * 2) 270 OR 1=1
 * 
 * What happens for scenario #2?
 * 
 */
public class SQLInjectionExample {

	public static void main(String[] args) {
		
		/* This datasource will be used for creating connections to the database.
		 * Below, we provide the information required to make database connections */
		BasicDataSource dvdstoreDataSource = new BasicDataSource();
		dvdstoreDataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore");
		dvdstoreDataSource.setUsername("postgres");
		dvdstoreDataSource.setPassword("postgres1");
		
		/* The JdbcTemplate is the main interface we use to interact with databases using
		 * Spring JDBC. */
		JdbcTemplate dvdstoreJdbcTemplate = new JdbcTemplate(dvdstoreDataSource);
		
		System.out.print("Enter customer id: ");
		try (Scanner keyboard = new Scanner(System.in)) {
			String customerIdInput = keyboard.nextLine();
			displayPaymentsForCustomer(customerIdInput, dvdstoreJdbcTemplate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void displayPaymentsForCustomer(String customerIdParam, JdbcTemplate jdbcTemplate) {
		
		// Create query using concatenation
		
		String query = "SELECT customer_id, amount FROM payment WHERE customer_id = " + customerIdParam;
		
		System.out.println("Executing: ");
		System.out.println(query);
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(query);
		
		
		// Create query using query params
		
//		String query = "SELECT customer_id, amount FROM payment WHERE customer_id = ?";
//		
//		System.out.println("Executing: ");
//		System.out.println("Query: " + query + ", param: " + customerIdParam);
		
//		SqlRowSet results = jdbcTemplate.queryForRowSet(query, customerIdParam);
		
		System.out.println();
		System.out.println("Payments:");
		while(results.next()) {  // The "next" method advances the cursor to the next row.  If a row exists, it returns true, otherwise false
			Integer customerId = results.getInt("customer_id");  // this is the title column from teh SELECT statment above
			Double amount = results.getDouble("amount");
			System.out.println("Customer id:" + customerId + " payment amount: $" + amount);
		}
	}
}
