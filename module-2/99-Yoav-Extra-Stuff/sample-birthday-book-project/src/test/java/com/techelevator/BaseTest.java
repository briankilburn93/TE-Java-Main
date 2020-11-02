package com.techelevator;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.birthdaybook.model.BirthdayEntry;

public class BaseTest {

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	protected static SingleConnectionDataSource dataSource;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/birthdaybook");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/* The following line disables autocommit for connections
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
	}
	
	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	

	
	public static BirthdayEntry getBirthdayEntry(String name, Integer birthDay, Integer birthMonth,
			Integer birthYear, String notes) {
		BirthdayEntry entry = new BirthdayEntry();
		
		entry.setName(name);
		entry.setBirthDay(birthDay);
		entry.setBirthMonth(birthMonth);
		entry.setBirthYear(birthYear);
		entry.setNotes(notes);
		
		return entry;
	}

}
