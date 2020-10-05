package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStringBits {
	
	StringBits testMethods = new StringBits();	// Instantiate an object with the methods to be tested

	@Test
	public void test_for_Hello() {
		//String expectedResult = "Hlo"; 	// Arrange - setup expected result
		//String testData = "Hello";		// Arrange - setup test data
		//String actualResult = testMethods.getBits(testData); // Act - test method
		//assertEquals("Incorrect String Return from getBits", expectedResult, actualResult);	// Assert
	
		assertEquals("Incorrect String Return from getBits", "Hlo", testMethods.getBits("Hello"));	// Assert
		
		//Pick you poison!
	}
	
	@Test
	public void test_for_null() {
		assertEquals("Incorrect String Return from getBits", "", testMethods.getBits(null));
	}
	
	@Test
	public void test_for_empty_String() {
		assertEquals("Incorrect String Return from getBits", "", testMethods.getBits(""));
	}
	
	@Test
	public void test_for_single_character() {
		assertEquals("Incorrect String Return from getBits", "H", testMethods.getBits("H"));
	}
	
//@Test //Test for a null being passed
//@Test //Test for an empty String being passed
//@Test //Test for a single character String being passed

}
