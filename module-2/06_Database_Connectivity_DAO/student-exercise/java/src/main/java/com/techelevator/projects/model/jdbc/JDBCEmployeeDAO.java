package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;

public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCEmployeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		
		String query = "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date FROM employee";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query);
		
		List<Employee> employeeList = new ArrayList<>();
		
		while(rowSet.next()) {
			Employee employee = mapRowToEmployee(rowSet);
			employeeList.add(employee);
		}
		return employeeList;
	}
	

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		
		String query = "SELECT * FROM employee WHERE first_name = ? AND last_name = ?";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, firstNameSearch, lastNameSearch);
		
		List<Employee> result = new ArrayList<>();
		
		while(rowSet.next()) {
			Employee employee = mapRowToEmployee(rowSet);
			result.add(employee);
		}
		return result;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		String query = "SELECT * FROM employee WHERE department_id = ?";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, id);
		
		List<Employee> result = new ArrayList<>();
		
		while(rowSet.next()) {
			Employee employee = mapRowToEmployee(rowSet);
			result.add(employee);
		}
		return result;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		String query = "SELECT * FROM employee e LEFT JOIN project_employee pe ON pe.employee_id = e.employee_id WHERE project_id IS NULL";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query);
		List<Employee> result = new ArrayList<>();
		
		while(rowSet.next()) {
			Employee employee = mapRowToEmployee(rowSet);
			result.add(employee);
		}
		
		return result;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		String query = "SELECT e.*, p.name FROM employee e " + 
                "JOIN project_employee pe ON pe.employee_id = e.employee_id " + 
                "JOIN project p ON p.project_id = pe.project_id " + 
                "WHERE p.project_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, projectId);

        List<Employee> employeeList = new ArrayList<>();

        while (rowSet.next()) {
        Employee employee = mapRowToEmployee(rowSet);
        employeeList.add(employee);

        }

        return employeeList;
	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		String query ="UPDATE employee SET department_id = ? WHERE employee_id = ?";
		jdbcTemplate.update(query, departmentId, employeeId);
	}
	
	
	
	private Employee mapRowToEmployee(SqlRowSet row) {
		Employee employee = new Employee();
		
		employee.setId(row.getLong("employee_id"));
		employee.setFirstName(row.getString("first_name"));
		employee.setLastName(row.getString("last_name"));
		employee.setDepartmentId(row.getLong("department_id"));
		employee.setBirthDay(row.getDate("birth_date").toLocalDate());
		employee.setHireDate(row.getDate("hire_date").toLocalDate());
		employee.setGender(row.getString("gender").charAt(0));
		
		return employee;
	}

}
