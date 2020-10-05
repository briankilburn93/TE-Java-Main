package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAnimalGroupName {
	
	AnimalGroupName testMethods = new AnimalGroupName();

	@Test
	public void test_for_sentence_case_Elephant() {
		assertEquals("Incorrect String Return from getBits", "Herd", testMethods.getHerd("Elephant"));	// Assert
	}
	
	@Test
	public void test_for_lower_case_Elephant() {
		assertEquals("Incorrect String Return from getBits", "Herd", testMethods.getHerd("elephant"));	// Assert
	}
	
	@Test
	public void test_for_capital_case_Elephant() {
		assertEquals("Incorrect String Return from getBits", "Herd", testMethods.getHerd("ELEPHANT"));	// Assert
	}
	
	@Test
	public void test_for_null() {
		assertEquals("Incorrect String Return from getBits", "unknown", testMethods.getHerd(null));
	}
	
	@Test
	public void test_for_empty_String() {
		assertEquals("Incorrect String Return from getBits", "unknown", testMethods.getHerd(""));
	}
	
	@Test
	public void test_for_animal_that_does_not_exist() {
		assertEquals("Incorrect String Return from getBits", "unknown", testMethods.getHerd("Wolf"));
	}

}
