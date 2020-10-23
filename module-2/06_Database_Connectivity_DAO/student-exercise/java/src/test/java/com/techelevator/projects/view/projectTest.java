package com.techelevator.projects.view;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.jdbc.JDBCProjectDAO;

public class projectTest {
	private static SingleConnectionDataSource dataSource;
	private JDBCProjectDAO jdbcProjectDao;
	private Project setupProject;
	
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
		
		Long nextId = getNextProjectIdForTest(jdbcTemplate);
		setupProject = getProject("ProjectName", LocalDate.now(), LocalDate.now());
		
		String query = "INSERT INTO project VALUES" 
				+ "(?, ?, ?, ?)";
		jdbcTemplate.update(query, nextId, setupProject.getName(), setupProject.getStartDate(), setupProject.getEndDate());
		setupProject.setId(nextId);
		
		jdbcProjectDao = new JDBCProjectDAO(dataSource);
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	
	
	private Long getNextProjectIdForTest(JdbcTemplate jdbcTemplate) {
		String query = "SELECT nextval('seq_project_id')";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query);
				
				if(rowSet.next()) {
					return rowSet.getLong(1);
				}
				return null;
	}
	
	private Project getProject(String name, LocalDate startDate, LocalDate endDate) {
		Project project = new Project();
		project.setName(name);
		project.setStartDate(startDate);
		project.setEndDate(endDate);
		
		return project;
	}
	
}
