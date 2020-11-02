package com.techelevator.birthdaybook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.birthdaybook.dao.BirthdayEntryDAO;
import com.techelevator.birthdaybook.model.BirthdayEntry;

@RestController
@RequestMapping("/birthdayentries")
public class BirthdayBookController {
	
	@Autowired
	private BirthdayEntryDAO birthdayEntryDao;
	
	public BirthdayBookController(BirthdayEntryDAO birthdayEntryDao) {
		this.birthdayEntryDao = birthdayEntryDao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<BirthdayEntry> getEntries() {
		return birthdayEntryDao.getEntries();
	}
	
	// Implement method to get one BirthdayEntry by Id
	
	// Implement method to create a BirthdayEntry
	
	// Implement method to update a BirthdayEntry
	
	// Implement method to delete a BirthdayEntry
	

}
