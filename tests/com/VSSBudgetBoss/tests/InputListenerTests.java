package com.VSSBudgetBoss.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.VSSBudgetBoss.cli.Listener;

public class InputListenerTests {

	@Test
	public void testListenForInput() {
		String userInput = null;
		//Given: An input listener
		Listener listener = new Listener();
		//When: It is waiting for user input
		userInput = listener.listenForInput();
		//And: user input is received (Type anything into the console)
		//Then: The input is recorded
		assertNotNull(userInput);
	
	}

}
