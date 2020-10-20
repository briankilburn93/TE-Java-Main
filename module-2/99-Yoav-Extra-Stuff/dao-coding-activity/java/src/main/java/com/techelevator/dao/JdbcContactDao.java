package com.techelevator.dao;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact getContactByID(Integer id) {
		String query = "SELECT id, first_name, last_name, phone, email, birthyear FROM contact WHERE id = ?";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, id);
		
		if(rowSet.next()) {
			Contact result = mapRowToContact(rowSet);
			return result;
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact update(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteContact(Contact contact) {
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
		
		return contact;
		
	}

}
