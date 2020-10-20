package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.dao.ContactDao;
import com.techelevator.dao.JdbcContactDao;
import com.techelevator.domain.Contact;

public class AddressBook {

	public static void main(String[] args) {
		
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/addressbook");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		// Create and use ContactDao
		ContactDao dao = new JdbcContactDao(dataSource);
		
		Contact contact = dao.getContactByID(1);
		
		System.out.println(contact);
		
		
	}

}
