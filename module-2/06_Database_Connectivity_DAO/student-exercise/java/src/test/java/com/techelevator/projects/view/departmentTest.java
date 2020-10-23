package com.techelevator.projects.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;

public class departmentTest {
	private static SingleConnectionDataSource dataSource;
	private JDBCDepartmentDAO jdbcDepartmentDao;
	private Department setupDepartment;
	
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
		
		Long nextId = getNextDepartmentIdForTest(jdbcTemplate);
		setupDepartment = getDepartment("DepartmentName");
		
		
		String query = "INSERT INTO department VALUES" 
				+ "(?, ?)";
		jdbcTemplate.update(query, nextId, setupDepartment.getName());
		setupDepartment.setId(nextId);
		
		jdbcDepartmentDao = new JDBCDepartmentDAO(dataSource);
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void test_department_by_id() {
		Department result = jdbcDepartmentDao.getDepartmentById(setupDepartment.getId());
	
		assertNotNull(result);
		assertEquals(setupDepartment.getId(), result.getId());
	}
	
	@Test
	public void test_department_by_name() {
		Department result = getDepartment("ResultName");
		jdbcDepartmentDao.createDepartment(result);
		
		List<Department> departments = jdbcDepartmentDao.searchDepartmentsByName(result.getName());
		jdbcDepartmentDao.createDepartment(result);
	
		assertNotNull(result);
		
		for(Department dep : departments ) {
			assertEquals(result.getName(), dep.getName());
		}
	}
	
	@Test
	public void test_create_department() {
		Department newDept = getDepartment("testDepartment");
		
		jdbcDepartmentDao.createDepartment(newDept);
		
		Department resultDept = jdbcDepartmentDao.getDepartmentById(newDept.getId());
		
		assertNotNull(resultDept);
		assertEquals(newDept.getId(), resultDept.getId());
		assertEquals(newDept.getName(), resultDept.getName());
	}
	
	@Test
	public void test_update_department() {
		Department newDept = getDepartment("NewDept");
		jdbcDepartmentDao.createDepartment(newDept);
				
		Department result = jdbcDepartmentDao.getDepartmentById(newDept.getId());
		result.setName("SecondDept");
		jdbcDepartmentDao.saveDepartment(result);
		//result = jdbcDepartmentDao.getDepartmentById(newDept.getId());
	
		assertNotNull(result.getName());
		assertEquals("SecondDept", result.getName());
	}
	
	private Department getDepartment(String name) {
		Department department = new Department();
		department.setName(name);
		
		return department;
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
