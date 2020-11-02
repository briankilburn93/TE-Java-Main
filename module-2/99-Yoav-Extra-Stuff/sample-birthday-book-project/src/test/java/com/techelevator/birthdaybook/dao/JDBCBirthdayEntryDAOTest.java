package com.techelevator.birthdaybook.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.BaseTest;
import com.techelevator.birthdaybook.model.BirthdayEntry;
import com.techelevator.birthdaybook.model.exception.EntryNotFoundException;

public class JDBCBirthdayEntryDAOTest extends BaseTest {
	
	private JDBCBirthdayEntryDao dao;
	
	@Before
	public void setUp() {
		dao = new JDBCBirthdayEntryDao(dataSource);
	}

	@Test
	public void create_withValidData_shouldCreateRecord() {
		
		BirthdayEntry entry = getBirthdayEntry("Test", 1, 5, 1970, "Test note");
		
		BirthdayEntry savedEntry = dao.create(entry);
		
		assertNotNull(savedEntry);
		assertNotNull(savedEntry.getId());
	}
	
	@Test
	public void getEntry_withValidId_shouldReturnRecord() throws Exception{
		
		BirthdayEntry entry = getBirthdayEntry("Test", 1, 5, 1970, "Test note");
		
		BirthdayEntry savedEntry = dao.create(entry);
		
		BirthdayEntry result = dao.getEntry(savedEntry.getId());
		
		assertNotNull(result);
		assertEquals(savedEntry.getId(), result.getId());
	}
	
	@Test(expected = EntryNotFoundException.class)
	public void getEntry_withInvalidId_shouldThrowEntryNotFoundException() throws Exception {
		
		BirthdayEntry entry = getBirthdayEntry("Test", 1, 5, 1970, "Test note");
		
		BirthdayEntry savedEntry = dao.create(entry);
		
		BirthdayEntry result = dao.getEntry(savedEntry.getId() + 1);
		
		assertNotNull(result);
		assertEquals(savedEntry.getId(), result.getId());
	}
	
	@Test
	public void getEntries_withValidData_shouldReturnMultipleRecords() throws Exception {
		
		BirthdayEntry entry = getBirthdayEntry("Test", 1, 5, 1970, "Test note");
		
		dao.create(entry);
		
		BirthdayEntry entry2 = getBirthdayEntry("Test2", 1, 5, 1969, "Test note2");
		
		dao.create(entry2);
		
		List<BirthdayEntry> result = dao.getEntries();
		
		assertTrue(result.size() > 1);
	}
	
	@Test
	public void updateEntry_withValidData_shouldUpdateRecord() throws Exception{
		
		BirthdayEntry entry = getBirthdayEntry("Test", 1, 5, 1970, "Test note");
		
		BirthdayEntry savedEntry = dao.create(entry);
		
		savedEntry.setBirthYear(1999);
		dao.updateEntry(savedEntry, savedEntry.getId());
		
		BirthdayEntry result = dao.getEntry(savedEntry.getId());
		
		assertNotNull(result);
		assertEquals(1999, result.getBirthYear().intValue());
	}
	
	@Test(expected = EntryNotFoundException.class)
	public void updateEntry_withInvalidRecord_shouldThrowEntryNotFoundException() throws Exception{
		
		BirthdayEntry entry = getBirthdayEntry("Test", 1, 5, 1970, "Test note");
		
		BirthdayEntry savedEntry = dao.create(entry);
		
		savedEntry.setId(savedEntry.getId() + 1);
		savedEntry.setBirthYear(1999);
		dao.updateEntry(savedEntry, savedEntry.getId() + 1);
	}
	
	@Test(expected = EntryNotFoundException.class)
	public void updateEntry_withInvalidData__shouldThrowEntryNotFoundException() throws Exception {
		
		BirthdayEntry entry = getBirthdayEntry("Test", 1, 5, 1970, "Test note");
		
		BirthdayEntry savedEntry = dao.create(entry);
		
		savedEntry.setBirthYear(1999);
		dao.updateEntry(savedEntry, savedEntry.getId() + 1);
	}
	
	@Test
	public void deleteEntry_withValidId_shouldNotThrowException() throws Exception {
		
		BirthdayEntry entry = getBirthdayEntry("Test", 1, 5, 1970, "Test note");
		
		BirthdayEntry savedEntry = dao.create(entry);
		
		BirthdayEntry result = dao.getEntry(savedEntry.getId());
		
		assertNotNull(result);
		
		dao.deleteEntry(savedEntry.getId());
	}
	
	@Test(expected = EntryNotFoundException.class)
	public void deleteEntry_withValidId_shouldDeleteRecord() throws Exception {
		
		BirthdayEntry entry = getBirthdayEntry("Test", 1, 5, 1970, "Test note");
		
		BirthdayEntry savedEntry = dao.create(entry);
		
		BirthdayEntry result = dao.getEntry(savedEntry.getId());
		
		assertNotNull(result);
		
		dao.deleteEntry(savedEntry.getId());
		
		result = dao.getEntry(savedEntry.getId());
	}
	
	@Test(expected = EntryNotFoundException.class)
	public void deleteEntry_withInValidId_shouldThrowException() throws Exception {
		
		BirthdayEntry entry = getBirthdayEntry("Test", 1, 5, 1970, "Test note");
		
		BirthdayEntry savedEntry = dao.create(entry);
		
		assertNotNull(savedEntry);
		
		dao.deleteEntry(savedEntry.getId() + 1);
	}

}
