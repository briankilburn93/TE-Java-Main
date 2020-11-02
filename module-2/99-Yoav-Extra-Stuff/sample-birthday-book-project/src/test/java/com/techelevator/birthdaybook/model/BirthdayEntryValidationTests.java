package com.techelevator.birthdaybook.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class BirthdayEntryValidationTests {
	
	private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterClass
    public static void close() {
        validatorFactory.close();
    }

    public BirthdayEntryValidationTests() {
    	
    }
	
	@Test
	public void should_have_no_violations() {
		BirthdayEntry entry = new BirthdayEntry("Test1", 1, 2, 1970, "notes1");
		
        Set<ConstraintViolation<BirthdayEntry>> violations = validator.validate(entry);

        assertTrue(violations.isEmpty());
	}
	
	@Test
	public void nameShouldNotBeBlank() {
		BirthdayEntry entry = new BirthdayEntry("", 1, 2, 1970, "notes1");
		
	    Set<ConstraintViolation<BirthdayEntry>> violations = validator.validate(entry);
	    assertEquals(violations.size(), 1);
	    
	    ConstraintViolation<BirthdayEntry> violation = violations.iterator().next();
	    assertEquals("The field name should not be blank.", violation.getMessage());
        assertEquals("name", violation.getPropertyPath().toString());
	        
	}
	
	@Test
	public void birthDayShouldBe1OrMore() {
		BirthdayEntry entry = new BirthdayEntry("Test1", 0, 2, 1970, "notes1");
		
	    Set<ConstraintViolation<BirthdayEntry>> violations = validator.validate(entry);
	    assertEquals(violations.size(), 1);
	    
	    ConstraintViolation<BirthdayEntry> violation = violations.iterator().next();
	    assertEquals("The field birth day must be at least 1", violation.getMessage());
        assertEquals("birthDay", violation.getPropertyPath().toString());
	        
	}
	
	@Test
	public void birthDayShouldBe31OrLess() {
		BirthdayEntry entry = new BirthdayEntry("Test1", 40, 2, 1970, "notes1");
		
	    Set<ConstraintViolation<BirthdayEntry>> violations = validator.validate(entry);
	    assertEquals(violations.size(), 1);
	    
	    ConstraintViolation<BirthdayEntry> violation = violations.iterator().next();
	    assertEquals("The field birth day must be less than or equal to 31", violation.getMessage());
        assertEquals("birthDay", violation.getPropertyPath().toString());      
	}
	
	@Test
	public void birthMonthShouldBe1OrMore() {
		BirthdayEntry entry = new BirthdayEntry("Test1", 1, 0, 1970, "notes1");
		
	    Set<ConstraintViolation<BirthdayEntry>> violations = validator.validate(entry);
	    assertEquals(violations.size(), 1);
	    
	    ConstraintViolation<BirthdayEntry> violation = violations.iterator().next();
	    assertEquals("The field birth month must be at least 1", violation.getMessage());
        assertEquals("birthMonth", violation.getPropertyPath().toString());      
	}
	
	@Test
	public void birthMonthShouldBe12OrLess() {
		BirthdayEntry entry = new BirthdayEntry("Test1", 1, 15, 1970, "notes1");
		
	    Set<ConstraintViolation<BirthdayEntry>> violations = validator.validate(entry);
	    assertEquals(violations.size(), 1);
	    
	    ConstraintViolation<BirthdayEntry> violation = violations.iterator().next();
	    assertEquals("The field birth month must be less than or equal to 12", violation.getMessage());
        assertEquals("birthMonth", violation.getPropertyPath().toString());      
	}
	
	@Test
	public void birthYearShouldBePositive() {
		BirthdayEntry entry = new BirthdayEntry("Test1", 1, 10, 0, "notes1");
		
	    Set<ConstraintViolation<BirthdayEntry>> violations = validator.validate(entry);
	    assertEquals(violations.size(), 1);
	    
	    ConstraintViolation<BirthdayEntry> violation = violations.iterator().next();
	    assertEquals("The field birth year must be positive.", violation.getMessage());
        assertEquals("birthYear", violation.getPropertyPath().toString());      
	}
	

}
