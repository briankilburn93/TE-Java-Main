package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

public class AddressBook {

	public static void main(String[] args) {
		
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/addressbook");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		// Create and use ContactDao
		
	}

}
