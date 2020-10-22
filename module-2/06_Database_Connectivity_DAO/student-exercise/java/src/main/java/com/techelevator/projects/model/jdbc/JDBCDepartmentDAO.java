package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;

public class JDBCDepartmentDAO implements DepartmentDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCDepartmentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Department> getAllDepartments() {
		String query = "SELECT department_id, name FROM department";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query);
		
		List<Department> result = new ArrayList<>();
		while(rowSet.next()) {
			Department department = mapRowToDepartment(rowSet);
			result.add(department);
		}
		return result;
	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		String query = "SELECT department_id, name FROM department WHERE name LIKE ('%' || ? || '%')";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, nameSearch);
		
		List<Department> result = new ArrayList<>();
		while(rowSet.next()) {
			Department dept = mapRowToDepartment(rowSet);
			result.add(dept);
		}
		return result;
	}

	@Override
	public void saveDepartment(Department updatedDepartment) {
		String query = "UPDATE department SET name = ? WHERE department_id = ?";
		jdbcTemplate.update(query, updatedDepartment.getName(), updatedDepartment.getId());
	}

	@Override
	public Department createDepartment(Department newDepartment) {
		String query = "INSERT INTO Department VALUES(?,?)";
		Long nextId = getNextDepartmentId();
		
		jdbcTemplate.update(query, nextId, newDepartment.getName());
		newDepartment.setId(nextId);
		
		return newDepartment;
	}

	@Override
	public Department getDepartmentById(Long id) {
		String query = "SELECT department_id, name FROM department WHERE department_id = ?";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, id);
		
		if(rowSet.next()) {
			Department result = mapRowToDepartment(rowSet);
			return result;
		}
		return null;
	}
	
	private Department mapRowToDepartment(SqlRowSet row) {
		Department dept = new Department();
		dept.setId(row.getLong("department_id"));
		dept.setName(row.getString("name"));
		
		return dept;
	}
	
	private Long getNextDepartmentId() {
		String query = "SELECT nextval('seq_department_id')";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query);
				
				if(rowSet.next()) {
					return rowSet.getLong(1);
				}
				return null;
	}

}
