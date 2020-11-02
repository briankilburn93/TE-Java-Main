package com.techelevator.birthdaybook.dao;

import java.util.List;

import com.techelevator.birthdaybook.model.BirthdayEntry;

public interface BirthdayEntryDAO {
	
	BirthdayEntry create(BirthdayEntry note);
	
	BirthdayEntry getEntry(Long id);
	
	List<BirthdayEntry> getEntries();
	
	BirthdayEntry updateEntry(BirthdayEntry note, Long id);
	
	void deleteEntry(Long id);

}
