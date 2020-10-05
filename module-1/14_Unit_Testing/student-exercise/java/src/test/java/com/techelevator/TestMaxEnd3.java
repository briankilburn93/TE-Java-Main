package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMaxEnd3 {

	MaxEnd3 testMethods = new MaxEnd3();

	@Test
	public void test_for_one_two_three_to_become_three_three_three() {
		int[] intTestForArray = {1,2,3};
		int[] expectedResultIntArray = {3,3,3};
		assertArrayEquals("Incorrect String Return from getBits", expectedResultIntArray, testMethods.makeArray(intTestForArray));	// Assert
	}
	
	@Test
	public void test_for_eleven_five_nine_to_become_eleven_eleven_eleven() {
		int[] intTestForArray = {11,5,9};
		int[] expectedResultIntArray = {11,11,11};
		assertArrayEquals("Incorrect String Return from getBits", expectedResultIntArray, testMethods.makeArray(intTestForArray));	// Assert
	}
	
	@Test
	public void test_for_two_eleven_three_to_become_three_three_three() {
		int[] intTestForArray = {2,11,3};
		int[] expectedResultIntArray = {3,3,3};
		assertArrayEquals("Incorrect String Return from getBits", expectedResultIntArray, testMethods.makeArray(intTestForArray));	// Assert
	}

}
