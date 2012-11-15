package com.VSSBudgetBoss.fileops;

import com.VSSBudgetBoss.budget.Budget;
import com.VSSBudgetBoss.cli.*;
import com.VSSBudgetBoss.main.BudgetBoss;

public class TheCreator {
		
	public void createBudget(){
		Prompter.printPrompt("getBudgetName");
		String desiredName = Listener.getInput();
		System.out.println("Creating budget " + desiredName + "...\n");
		Budget newBudget = new Budget(desiredName);
		BudgetBoss.setCurrentBudget(newBudget);
		BudgetBoss.endNeedNewBudget();
	}
}
