package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNonStart {

	NonStart testMethods = new NonStart();

	@Test
	public void test_for_Hello_There() {
		assertEquals("Incorrect String Return from getBits", "ellohere", testMethods.getPartialString("Hello", "There"));	// Assert
	}
	
	@Test
	public void test_for_two_character_lengths_te_st() {
		assertEquals("Incorrect String Return from getBits", "et", testMethods.getPartialString("te", "st"));	// Assert
	}
	
	@Test
	public void test_for_one_character_lengths_n_o() {
		assertEquals("Incorrect String Return from getBits", "", testMethods.getPartialString("n", "o"));	// Assert
	}
	

}
