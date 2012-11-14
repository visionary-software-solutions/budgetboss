package com.VSSBudgetBoss.cli;

import java.util.ResourceBundle;

public class Prompter {
	
	public static ResourceBundle cliOutput = ResourceBundle.getBundle("cliOutput");


	public static void printPrompt(String toGet){
		System.out.println(cliOutput.getString(toGet));
	}
}
