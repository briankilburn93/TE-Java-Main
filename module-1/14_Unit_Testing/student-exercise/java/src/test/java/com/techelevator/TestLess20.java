package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLess20 {

	Less20 testMethods = new Less20();

	@Test
	public void test_at_number_eighteen() {
		assertEquals("Incorrect String Return from getBits", true, testMethods.isLessThanMultipleOf20(18));	// Assert
	}
	
	@Test
	public void test_at_number_nineteen() {
		assertEquals("Incorrect String Return from getBits", true, testMethods.isLessThanMultipleOf20(19));	// Assert
	}
	
	@Test
	public void test_at_number_twenty() {
		assertEquals("Incorrect String Return from getBits", false, testMethods.isLessThanMultipleOf20(20));	// Assert
	}

}
