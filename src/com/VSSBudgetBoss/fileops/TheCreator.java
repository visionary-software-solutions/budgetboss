package com.VSSBudgetBoss.fileops;

import com.VSSBudgetBoss.budget.Budget;
import com.VSSBudgetBoss.cli.*;
import com.VSSBudgetBoss.main.BudgetBoss;

public class TheCreator {
	
	private static boolean needANewBudget = true;

	public void bestMakeABudgetNow(){
		Prompter.printPrompt("createNewBudget");
		InputValidator validator = new InputValidator();
		String toCheck = Listener.getInput();
		while(validator.inputIsNotYOrN(toCheck))
			toCheck = Listener.getInput();
		if(toCheck.equalsIgnoreCase("y"))
			getBudgetName();
		else{
			Prompter.printPrompt("fuckThisProgram");
			needANewBudget = false;
		}
	}
	
	private void getBudgetName(){
		Prompter.printPrompt("getBudgetName");
		String desiredName = Listener.getInput();
		System.out.println("Creating budget " + desiredName + "...");
		Budget newBudget = new Budget(desiredName);
		BudgetBoss.setCurrentBudget(newBudget);
		needANewBudget = false;
	}
	
	public static boolean isSlackingOnFinances(){
		return needANewBudget;
	}
	
	public static void budgetLoaded(){
		needANewBudget = false;
	}
}
