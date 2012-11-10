package com.VSSBudgetBoss.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputListener {
	
	private String desiredInput;
	
	public String listenForInput(){
			BufferedReader listener = new BufferedReader(new InputStreamReader(System.in));
			try {
				desiredInput = listener.readLine();
			} catch (IOException e) {
				System.out.println("You fucked up. I mean, it wasn't me. Un-Bosslike.");
			}
			return desiredInput;
	}
					
	
		
}