package com.VSSBudgetBoss.fileops;

import com.VSSBudgetBoss.budget.Budget;
import com.VSSBudgetBoss.cli.*;
import com.VSSBudgetBoss.main.BudgetBoss;

public class TheCreator {
		
	public void createBudget(){
		Printer.printPrompt("getBudgetName");
		String desiredName = Listener.getInput();
		if(!(desiredName.equals("exit"))){
			System.out.println("Creating budget " + desiredName + "...\n");
			Budget newBudget = new Budget(desiredName);
			BudgetBoss.setCurrentBudget(newBudget);
			BudgetBoss.endNeedNewBudget();
		}else{
			BudgetBoss.endLoadSavedBudget();
			BudgetBoss.endNeedNewBudget();
			BudgetBoss.doneUsingBudgetBoss();
		}
	}
}
