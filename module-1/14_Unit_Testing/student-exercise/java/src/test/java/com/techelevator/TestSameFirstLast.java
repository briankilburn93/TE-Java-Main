package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSameFirstLast {

	SameFirstLast testMethods = new SameFirstLast();

	@Test
	public void test_for_one_two_three() {
		int[] intArray = {1,2,3};
		assertEquals("Incorrect String Return from getBits", false, testMethods.isItTheSame(intArray));	// Assert
	}
	
	@Test
	public void test_for_one_two_three_should_provide_false() {
		int[] intArray = {1,2,3,1};
		assertEquals("Incorrect String Return from getBits", true, testMethods.isItTheSame(intArray));	// Assert
	}
	
	@Test
	public void test_for_one_two_four_should_provide_false() {
		int[] intArray = {1,2,1};
		assertEquals("Incorrect String Return from getBits", true, testMethods.isItTheSame(intArray));	// Assert
	}

}
