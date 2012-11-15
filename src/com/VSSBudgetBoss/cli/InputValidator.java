package com.VSSBudgetBoss.cli;

import java.io.File;

import com.VSSBudgetBoss.main.*;

public class InputValidator {
		
	public boolean inputIsNotYOrN(String toCheck){
		if(toCheck.equalsIgnoreCase("y"))
			return false;
		else if(toCheck.equalsIgnoreCase("n"))
			return false;
		else{
			Prompter.printPrompt("invalidEntryYN");
			return true;
		}
	}
	
	public boolean inputNotAnInteger(String toCheck){
		try{
			Integer.parseInt(toCheck);
		}catch(NumberFormatException e){
			Prompter.printPrompt("notEvenANumberGenius");
			return true;
		}
		return false;
	}
	
	public boolean pathIsInvalid(String toCheck){
		File directory = new File(toCheck);
		if(toCheck.equalsIgnoreCase("y"))
			return false;
		if(toCheck.endsWith("/")){
			if(directory.isDirectory())
				return false;
		}
		if(toCheck.contains(" ")){
			Prompter.printPrompt("whitespaceGenius");
			System.out.println("The default is: " + BudgetBoss.getDefaultDirectory());
			return true;
		}
		if(!toCheck.endsWith("/")){
			Prompter.printPrompt("endsInSlash");
			System.out.println("The default is: " + BudgetBoss.getDefaultDirectory());
			return true;
		}else{
			Prompter.printPrompt("badPathInput");
			System.out.println("The default is: " + BudgetBoss.getDefaultDirectory());
			return true;
		}
	}

	public boolean inputNotABudget(String toCheck, int highestChoice){
		if(inputNotAnInteger(toCheck)){
			Prompter.printPrompt("notEvenANumberGenius");
			return true;
		}
		if(Integer.valueOf(toCheck).equals(0)){
			Prompter.printPrompt("youreAZero");
			return true;
		}
		int userChoice = Integer.valueOf(toCheck);
		if(userChoice > highestChoice){
			Prompter.printPrompt("thatsNotAChoice");
			return true;
		}
		else
			return false;
	}
	
	public boolean validatesMenuChoice(String toCheck, MasterMenu menu){
		if(inputNotAnInteger(toCheck))
			return false;
		if(Integer.valueOf(toCheck).equals(0)){
			Prompter.printPrompt("youreAZero");
			return false;
		}
		int userChoice = Integer.valueOf(toCheck);
		if(userChoice > menu.getNumberOfOptions()){
			Prompter.printPrompt("thatsNotAChoice");
			return false;
		}
		else
			return true;
	}
}


