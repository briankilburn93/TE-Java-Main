package com.techelevator.dao;

import java.util.List;

import com.techelevator.domain.Contact;

public interface ContactDao {
	

	// create a Contact
	Contact create(Contact contact);

	// get a contact by id
	Contact getContactByID(Integer id);

	// get a List of all Contacts
	List<Contact> getAllContacts();

	// update a Contact
	Contact update(Contact contact);

	// delete Contact
	void deleteContact(Contact contact);

}
