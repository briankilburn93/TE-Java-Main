package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFrontTimes {

	FrontTimes testMethods = new FrontTimes();

	@Test
	public void test_for_Chocolate_two_times() {
		assertEquals("Incorrect String Return from getBits", "ChoCho", testMethods.generateString("Chocolate", 2));	// Assert
	}
	
	@Test
	public void test_for_string_length_two_of_Ch_three_times() {
		assertEquals("Incorrect String Return from getBits", "ChChCh", testMethods.generateString("Ch", 3));	// Assert
	}
	
	@Test
	public void test_for_null_two_times() {
		assertEquals("Incorrect String Return from getBits", "", testMethods.generateString(null, 2));	// Assert
	}
	
	@Test
	public void test_for_empty_string_three_times() {
		assertEquals("Incorrect String Return from getBits", "", testMethods.generateString("", 3));	// Assert
	}
}
