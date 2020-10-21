package com.techelevator.dao;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.domain.Contact;

public class JdbcContactDaoTest {

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	private JdbcContactDao jdbcContactDao;
	private Contact	setupContact;
	
//	* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/addressbook");
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
	
	@Before
	public void setup() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Integer nextId = getNextContactIdForTest(jdbcTemplate);
		setupContact = getContact("TestFirstName", "TestLastName", "TestPhone",
				"TestFirstEmail", 1980);
		
		
		String query = "INSERT INTO contact VALUES" 
				+ "(?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(query, nextId, setupContact.getFirstName(), setupContact.getLastName(),
				setupContact.getPhone(), setupContact.getEmail(), setupContact.getBirthYear());
		setupContact.setId(nextId);
		
		jdbcContactDao = new JdbcContactDao(dataSource);
	}
	
	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	private Contact getContact(String firstName, String lastName, String phone,
			String email, Integer birthYear) {
		Contact contact = new Contact();
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setPhone(phone);
		contact.setEmail(email);
		contact.setBirthYear(birthYear);
		
		return contact;
	}
	
	private Integer getNextContactIdForTest(JdbcTemplate jdbcTemplate) {
		String query = "SELECT nextval('seq_contact_id')";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query);
		
		if(rowSet.next()) {
			return rowSet.getInt(1);
		}
		
		return null;
	}

	private void assertEqual(Integer id, Integer id2) {
		// TODO Auto-generated method stub
		
	}
}
