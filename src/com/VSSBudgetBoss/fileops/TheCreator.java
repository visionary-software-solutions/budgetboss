package com.VSSBudgetBoss.fileops;

import com.VSSBudgetBoss.budget.Budget;
import com.VSSBudgetBoss.cli.*;
import com.VSSBudgetBoss.main.BudgetBoss;

public class TheCreator {
	
	private static boolean budgetless = true;

	public void bestMakeABudgetNow(){
		BudgetBoss.printPrompt("createNewBudget");
		InputValidator validator = new InputValidator();
		InputListener listener = new InputListener();
		String toCheck = listener.listenForInput();
		while(validator.inputIsNotYOrN(toCheck))
			toCheck = listener.listenForInput();
		if(toCheck.equalsIgnoreCase("y"))
			getBudgetName();
		else{
			BudgetBoss.printPrompt("fuckThisProgram");
			budgetless = false;
		}
	}
	
	private void getBudgetName(){
		InputListener listener = new InputListener();
		BudgetBoss.printPrompt("getBudgetName");
		String desiredName = listener.listenForInput();
		System.out.println("Creating budget " + desiredName + "...");
		Budget newBudget = new Budget(desiredName);
		BudgetBoss.setCurrentBudget(newBudget);
		budgetless = false;
	}
	
	public static boolean isSlackingOnFinances(){
		return budgetless;
	}
	
	public static void notStillBudgetless(){
		budgetless = false;
	}
}
