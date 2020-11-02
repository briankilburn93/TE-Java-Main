package com.techelevator.birthdaybook.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.birthdaybook.model.BirthdayEntry;

@Component
public class JDBCBirthdayEntryDao implements BirthdayEntryDAO {
	
	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCBirthdayEntryDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public BirthdayEntry getEntry(Long id) {
		
		return null;
	}
	
	@Override
	public List<BirthdayEntry> getEntries() {
		
		return null;
	}

	@Override
	public BirthdayEntry create(BirthdayEntry entry) {
		String sql = "INSERT INTO birthday_entry VALUES (DEFAULT, ?, ?, ?, ?, ?) RETURNING id";
		
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, entry.getName(), entry.getBirthDay(),
				entry.getBirthMonth(), entry.getBirthYear(), entry.getNotes());
		
		if (rowSet.next()) {
			entry.setId(rowSet.getLong(1));
		}
		
		return entry;
	}

	@Override
	public BirthdayEntry updateEntry(BirthdayEntry entry, Long id) {
		if (entry.getId().equals(id)) {
			try {
				// update here
			} catch (DataAccessException e) {
				// this will happen if tried to update not fpund record
			}
		} else {
			// if id in entry does not match id in path
		}
		
		return null;
	}

	@Override
	public void deleteEntry(Long id)  {
		
	}
	
	private BirthdayEntry mapRowToBirthdayEntry(SqlRowSet row) {
		
		return null;
	}

}
