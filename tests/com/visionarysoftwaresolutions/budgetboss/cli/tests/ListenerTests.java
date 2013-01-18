package com.visionarysoftwaresolutions.budgetboss.cli.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import com.visionarysoftwaresolutions.budgetboss.cli.*;

public class ListenerTests {

	@Test
	public void testGetInput() {
		//Given: A String is needed. The source is the directly from the user via the console.
		String isNeeded;
		Listener listener = Listener.create();
		BufferedReader mockReader = Mockito.mock(BufferedReader.class);
		listener.setReader(mockReader);
		try{
			Mockito.when(mockReader.readLine()).thenReturn("Input from console!");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//When: Listener prompts for the input from the console
		isNeeded = listener.getInput();
		//Then: TakeInput will get the correct String from the user
		Assert.assertTrue(isNeeded.equals("Input from console!"));
	}
	
	@Test
	public void testMulitpleInstantiationsRealInput(){
		//This ensures that the reader doesn't close before the end of the program
		String firstInput = Listener.create().getInput();
		String secondInput = Listener.create().getInput();
	}
}
