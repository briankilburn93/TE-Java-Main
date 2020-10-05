package com.techelevator;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestWordCount {

	WordCount testMethods = new WordCount();	// Instantiate an object with the methods to be tested

	@Test
	public void test_for_two_ba_one_black_one_sheep_output() {
		String[] testStringArray = {"ba", "ba", "black", "sheep"};
		Map<String, Integer> testMapOutput = new HashMap<>();
		testMapOutput.put("ba", 2);
		testMapOutput.put("black", 1);
		testMapOutput.put("sheep", 1);
		assertEquals("Incorrect String Return from getBits", testMapOutput, testMethods.getCount(testStringArray));
	}
	
	@Test
	public void test_for_empty_String_Array() {
		String[] testStringArray = {""};
		Map<String, Integer> testMapOutput = new HashMap<>();
		testMapOutput.put("", 1);
		assertEquals("Incorrect String Return from getBits", testMapOutput, testMethods.getCount(testStringArray));
	}

}
