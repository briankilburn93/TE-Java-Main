package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCigarParty {

	CigarParty testMethods = new CigarParty();

	@Test
	public void test_for_under_required_cigars_and_not_weekend() {
		assertEquals("Incorrect String Return from getBits", false, testMethods.haveParty(30, false));	// Assert
	}
	
	@Test
	public void test_for_between_forty_and_sixty_and_not_weekend() {
		assertEquals("Incorrect String Return from getBits", true, testMethods.haveParty(50, false));	// Assert
	}
	
	@Test
	public void test_for_between_forty_and_sixty_and_is_the_weekend() {
		assertEquals("Incorrect String Return from getBits", true, testMethods.haveParty(70, true));	// Assert
	}

}
