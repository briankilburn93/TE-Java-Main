package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDateFashion {

	DateFashion testMethods = new DateFashion();

	@Test
	public void test_for_date_at_ten_while_your_outfit_is_a_five() {
		assertEquals("Incorrect String Return from getBits", 2, testMethods.getATable(5, 10));	// Assert
	}
	
	@Test
	public void test_for_date_outfit_rating_at_two() {
		assertEquals("Incorrect String Return from getBits", 0, testMethods.getATable(5, 2));	// Assert
	}
	
	@Test
	public void test_for_date_and_you_outfit_rated_at_a_five_each() {
		assertEquals("Incorrect String Return from getBits", 1, testMethods.getATable(5, 5));	// Assert
	}

}
