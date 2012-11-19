package com.visionarysoftwaresolutions.budgetboss.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.visionarysoftwaresolutions.budgetboss.app.BudgetBoss;

public class Listener {
	
	private String desiredInput;
	
	public static String getInput(){
		Listener listener = new Listener();
		String input = listener.listenForInput();
		return input;
	}
	
	private String listenForInput(){
			BufferedReader listener = new BufferedReader(new InputStreamReader(System.in));
			try {
				desiredInput = listener.readLine();
			} catch (IOException e) {
				System.out.println("You fucked up. I mean, it wasn't me. Un-Bosslike.");
			}
			return desiredInput;
	}
					
	
		
}