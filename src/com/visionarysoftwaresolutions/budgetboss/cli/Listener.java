package com.visionarysoftwaresolutions.budgetboss.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Listener {
	
	private Listener(){}
	
	public static String getInput(){
		String userInput = null;
		BufferedReader listener = new BufferedReader(new InputStreamReader(System.in));
		try {
			userInput = listener.readLine();
		} catch (IOException e) {
			System.out.println("You fucked up. I mean, it wasn't me. Un-Bosslike.");
		}
		return userInput;
	}		
}