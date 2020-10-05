package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLucky13 {

	Lucky13 testMethods = new Lucky13();

	@Test
	public void test_for_zero_two_four_should_provide_true() {
		int[] intArray = {0,2,4};
		assertEquals("Incorrect String Return from getBits", true, testMethods.getLucky(intArray));	// Assert
	}
	
	@Test
	public void test_for_one_two_three_should_provide_false() {
		int[] intArray = {1,2,3};
		assertEquals("Incorrect String Return from getBits", false, testMethods.getLucky(intArray));	// Assert
	}
	
	@Test
	public void test_for_one_two_four_should_provide_false() {
		int[] intArray = {1,2,4};
		assertEquals("Incorrect String Return from getBits", false, testMethods.getLucky(intArray));	// Assert
	}

}
