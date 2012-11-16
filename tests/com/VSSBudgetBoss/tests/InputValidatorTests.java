package com.VSSBudgetBoss.tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.VSSBudgetBoss.cli.InputValidator;

public class InputValidatorTests {
	
	InputValidator validator;
	
	@Before
	public void setup(){
	//Given: An input is required from a user
	validator = new InputValidator();
	}
		
	@Test
	public void testNonIntegerRejection(){
		//And: The input must be an integer (for selecting menu options numerically)
		//When: The user inputs something
		//Then: The input will only validate if it is an integer
		assertFalse(validator.inputNotAnInteger("8"));
		assertFalse(validator.inputNotAnInteger("1"));
		assertTrue(validator.inputNotAnInteger("toCheck"));
	}
	
	@Test
	public void testValidatePathLinux(){
		//And: A valid directory path is needed
		//When: The user inputs something
		//Then: The input will only validate if it is a valid path, ending in "/"
		String currentUser = System.getProperty("user.name");
		assertTrue(validator.pathIsInvalid("/home/" + currentUser + "/Documents"));
		assertFalse(validator.pathIsInvalid("/home/" + currentUser + "/Documents/"));
		assertTrue(validator.pathIsInvalid("/home/" + currentUser + "/notevenarealdirectory/"));
	}
}
	