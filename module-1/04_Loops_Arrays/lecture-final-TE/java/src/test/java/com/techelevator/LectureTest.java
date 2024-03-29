package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LectureTest {

    Lecture exercises = new Lecture();	//-- Instantiate an object for class with methods to test

    @Test
    public void testReturnArray() {
    	//--			expected array created here	 , method will return an array
    	//-- can do it like this or...
        //assertArrayEquals(new int[] { 80, 8080, 443 }, exercises.returnArray());
        
        //-- like this, where you set up test data first
        int[] testArray = new int[] {80, 8080, 442}; 				//-- Arrange - setup test data
        assertArrayEquals(testArray, exercises.returnArray());		//-- Act and assert
    }

    @Test
    public void testReturnFirstElement() {
        assertEquals("That's not the first element in that array", 80, exercises.returnFirstElement());
    }

    @Test
    public void testReturnLastElement() {
    	//--			error message,			   expected value,		actual value returned
        assertEquals("That's not the last element", 443, exercises.returnLastElement());
    }

    @Test
    public void testReturnFirstElementOfParam() {
        assertEquals("That's not the first element from {5, 10, 15}", 5,
                exercises.returnFirstElementOfParam(new int[] { 5, 10, 15 }));
        assertEquals("That's not the first element from {10, 20, 30, 40, 50}", 10,
                exercises.returnFirstElementOfParam(new int[] { 10, 20, 30, 40, 50 }));
    }

    @Test
    public void testReturnLastElementOfParam() {
        assertEquals("That's not the last element from {5, 10, 15}", 15,
                exercises.returnLastElementOfParam(new int[] { 5, 10, 15 }));
        assertEquals("That's not the last element from {10, 20, 30, 40, 50}", 50,
                exercises.returnLastElementOfParam(new int[] { 10, 20, 30, 40, 50 }));
    }

    @Test
    public void testReturnVariableFromBlock() {
        assertEquals(15, exercises.returnVariableFromBlock(3));
    }

    @Test
    public void testReturnOperationInBlock() {
        assertTrue("Not true yet!", exercises.returnOperationInBlock());
    }

    @Test
    public void testReturnVariableInScope() {
        assertEquals("Not that one, try again.", 5.0, exercises.returnInScopeVariable(), 0.001);
    }

    @Test
    public void testReturnCounterFromLoop() {
        assertTrue("Not true yet!", exercises.returnCounterFromLoop());
    }

    @Test
    public void testReturnCorrectCount() {
        assertTrue("Not Correct Yet!", exercises.returnCorrectCount());
    }

    @Test
    public void testReturnCorrectCountTimes() {
        assertTrue("Not Correct Yet!", exercises.returnCountCorrectTimes());
    }

    @Test
    public void testReturnSumEveryOtherNumber() {
        assertTrue("Not Correct Yet!", exercises.returnSumEveryOtherNumber());
    }
}