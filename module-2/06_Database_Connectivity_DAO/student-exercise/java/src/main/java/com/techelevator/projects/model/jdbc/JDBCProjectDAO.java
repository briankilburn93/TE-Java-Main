package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;

public class JDBCProjectDAO implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCProjectDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Project> getAllActiveProjects() {
		String query = "SELECT * FROM project WHERE to_date > current_date OR to_date IS NULL";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query);
		
		List<Project> projectList = new ArrayList<>();
		
		while(rowSet.next()) {
			Project project = mapRowToProject(rowSet);
			projectList.add(project);
		}
		return projectList;
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String query = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?";
		jdbcTemplate.update(query, projectId, employeeId);
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		
	}
	
	
	
	private Project mapRowToProject(SqlRowSet row) {
		Project project = new Project();
		
		project.setId(row.getLong("project_id"));
		project.setName(row.getString("name"));
		project.setStartDate(row.getDate("from_date").toLocalDate());
		project.setEndDate(row.getDate("to_date").toLocalDate());
		
		return project;
	}

}
