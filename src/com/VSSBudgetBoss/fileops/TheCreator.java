package com.VSSBudgetBoss.fileops;

import com.VSSBudgetBoss.budget.Budget;
import com.VSSBudgetBoss.cli.*;
import com.VSSBudgetBoss.main.BudgetBoss;

public class TheCreator {
	
	private boolean budgetless = true;

	public void bestMakeABudgetNow(){
		Prompts.createNewBudgetPrompt();
		InputValidator validator = new InputValidator();
		InputListener listener = new InputListener();
		String validatedInput = validator.inputIsEitherYOrN(listener.listenForInput());
		if(validatedInput.equals("y"))
			getBudgetName();
		else if(validatedInput.equals("n")){
			Prompts.fuckThisProgram();
			budgetless = false;
		}
		else
			Prompts.invalidEntryPromptYOrN();
	}
	
	private void getBudgetName(){
		InputListener listener = new InputListener();
		Prompts.getBudgetNamePrompt();
		String desiredName = listener.listenForInput();
		Prompts.creatingBudget(desiredName);
		Budget newBudget = new Budget(desiredName);
		BudgetBoss.setCurrentBudget(newBudget);
		budgetless = false;
	}
	
	public boolean isSlackingOnFinances(){
		return budgetless;
	}
}
