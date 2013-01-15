package com.visionarysoftwaresolutions.budgetboss.cli.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import com.visionarysoftwaresolutions.budgetboss.cli.*;

public class TakeInputTests {

	@Test
	public void testStringConsole() {
		//Given: A String is needed. The source is the directly from the user via the console.
		String isNeeded;
		RequiredInputs takeInput = TakeInput.create();
		Reader mockReader = Mockito.mock(BufferedReader.class);
		takeInput.setReader(mockReader);
		try {
			Mockito.when(((BufferedReader) mockReader).readLine()).thenReturn("Input from console!");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//When: TakeInput prompts for the input from the console
		isNeeded = takeInput.getStringConsole();
		//Then: TakeInput will get the correct String from the user
		Assert.assertTrue(isNeeded.equals("Input from console!"));
	}
}
