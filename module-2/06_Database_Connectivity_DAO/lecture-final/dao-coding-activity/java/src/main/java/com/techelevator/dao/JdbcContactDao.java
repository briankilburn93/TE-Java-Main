package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.domain.Contact;

public class JdbcContactDao implements ContactDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcContactDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Contact create(Contact contact) {
		String query = "INSERT INTO contact (first_name, last_name, phone, email, birthyear) VALUES" 
				+ "(?, ?, ?, ?, ?)";
		jdbcTemplate.update(query, contact.getFirstName(), contact.getLastName(), contact.getPhone(), contact.getEmail(), contact.getBirthYear());
		return contact;
	}

	@Override
	public Contact getContactById(Integer id) {
		String query = "SELECT id, first_name, last_name, phone, email, birthyear FROM contact WHERE id = ?";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, id);
		
		if(rowSet.next()) {
			Contact result = mapRowToContact(rowSet);
			return result;
		}
		
		return null;
	}

	@Override
	public List<Contact> getAllContacts() {
		String query = "SELECT id, first_name, last_name, phone, email, birthyear FROM contact";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query);
		
		List<Contact> result = new ArrayList<>();
		while(rowSet.next()) {
			Contact contact = mapRowToContact(rowSet);
			result.add(contact);
		}
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public Contact update(Contact contact) {
		String query = "UPDATE contact SET first_name = ?, last_name = ?, phone = ?, email = ?, birthyear = ? WHERE id = ?";
		jdbcTemplate.update(query, contact.getFirstName(), contact.getLastName(), contact.getPhone(), contact.getEmail(), contact.getBirthYear(), contact.getId());
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Contact contact) {
		// TODO Auto-generated method stub
		
	}
	
	private Contact mapRowToContact(SqlRowSet row) {
		Contact contact = new Contact();
		Integer id = row.getInt("id");
		contact.setId(id);
		contact.setFirstName(row.getString("first_name"));
		contact.setLastName(row.getString("last_name"));
		contact.setPhone(row.getString("phone"));
		contact.setEmail(row.getString("email"));
		contact.setBirthYear(row.getInt("birthyear"));
		
		return contact;
	}
		
	

}
