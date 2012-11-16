package com.VSSBudgetBoss.cli;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.ResourceBundle;

import org.fusesource.jansi.AnsiConsole;

public class Prompter {
	
	public static ResourceBundle cliOutput = ResourceBundle.getBundle("cliOutput");


	public static void printPrompt(String toGet){
		System.out.println(cliOutput.getString(toGet));
	}
}
