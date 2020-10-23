package com.techelevator.projects.view;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.jdbc.JDBCEmployeeDAO;

public class employeeTest {
	private static SingleConnectionDataSource dataSource;
	private JDBCEmployeeDAO jdbcEmployeeDao;
	private Employee setupEmployee;

	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		dataSource.setAutoCommit(false);
	}
	
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	
	@Before
	public void setup() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Long nextId = getNextEmployeeIdForTest(jdbcTemplate);
		Long nextIdDep = getNextDepartmentIdForTest(jdbcTemplate);
		setupEmployee = getFirstName("FirstName", "LastName", LocalDate.now(), "M", LocalDate.now());
		
		String query = "INSERT INTO employee VALUES" 
				+ "(?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(query, nextId, setupEmployee.getFirstName(), setupEmployee.getLastName(), setupEmployee.getBirthDay(), setupEmployee.getGender(), setupEmployee.getHireDate());
		setupEmployee.setId(nextId);
		
		jdbcEmployeeDao = new JDBCEmployeeDAO(dataSource);
	}
	
	
	
	
	
	
	
	private Long getNextEmployeeIdForTest(JdbcTemplate jdbcTemplate) {
		String query = "SELECT nextval('seq_employee_id')";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query);
				
				if(rowSet.next()) {
					return rowSet.getLong(1);
				}
				return null;
	}
	
	private Long getNextDepartmentIdForTest(JdbcTemplate jdbcTemplate) {
		String query = "SELECT nextval('seq_department_id')";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query);
				
				if(rowSet.next()) {
					return rowSet.getLong(1);
				}
				return null;
	}

}
