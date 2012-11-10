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
		String validatedInput = validator.inputIsEitherYOrN(listener.listenForInput());
		if(validatedInput.equals("y"))
			getBudgetName();
		else if(validatedInput.equals("n")){
			BudgetBoss.printPrompt("fuckThisProgram");
			budgetless = false;
		}
		else
			BudgetBoss.cliOutput.getString("invalidEntryYN");
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
