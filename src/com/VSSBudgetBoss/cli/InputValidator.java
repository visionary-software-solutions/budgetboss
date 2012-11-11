package com.VSSBudgetBoss.cli;

import java.io.File;

import com.VSSBudgetBoss.main.BudgetBoss;

public class InputValidator {
		
	public boolean inputIsNotYOrN(String toCheck){
		if(toCheck.equalsIgnoreCase("y"))
			return false;
		else if(toCheck.equalsIgnoreCase("n"))
			return false;
		else{
			BudgetBoss.printPrompt("invalidEntryYN");
			return true;
		}
	}
	
	private boolean inputNotAnInteger(String toCheck){
		try{
			Integer.parseInt(toCheck);
		}catch(NumberFormatException e){
			BudgetBoss.printPrompt("notEvenANumberGenius");
			return true;
		}
		return false;
	}
	
	public boolean pathIsInvalid(String toCheck){
		File directory = new File(toCheck);
		if(directory.isDirectory() && toCheck.endsWith("/"))
			return false;
		else{
			BudgetBoss.printPrompt("endInSlash");
			return true;
		}
	}
	
//	public boolean pathIsInvalid(String toCheck){
//		if(toCheck.equals("y") || toCheck.equals("Y"))
//			return false;
//		else if(thisPathIsValid(toCheck)){
//			BudgetBoss.setDefaultDirectory(toCheck);
//			return false;
//		}
//		else{
//			BudgetBoss.printPrompt("badPathInput");
//			System.out.println("The default directory is: " + BudgetBoss.getDefaultDirectory());
//			return true;
//		}
//	}

	public boolean validatesBudgetSelection(String toCheck, File[] foundBudgets){
		if(inputNotAnInteger(toCheck))
			return false;
		int highestChoice = foundBudgets.length;
		int userChoice = Integer.valueOf(toCheck);
		if(userChoice > highestChoice){
			BudgetBoss.printPrompt("thatsNotAChoice");
			return false;
		}
		else
			return true;
	}
	//For these two methods you should load the options into a string arraylist so you don't have to hardcode
	//the number of choices every time they change. And they will change.
	public boolean validatesMainMenuChoice(String toCheck){
		if(inputNotAnInteger(toCheck))
			return false;
		int userChoice = Integer.valueOf(toCheck);
		if(userChoice > 4){
			BudgetBoss.printPrompt("thatsNotAChoice");
			return false;
		}
		else
			return true;
	}
	
	public boolean validatesMainEditorChoice(String toCheck){
		if(inputNotAnInteger(toCheck))
			return false;
		int userChoice = Integer.valueOf(toCheck);
		if(userChoice > 5){
			BudgetBoss.printPrompt("thatsNotAChoice");
			return false;
		}
		else
			return true;
	}
}


