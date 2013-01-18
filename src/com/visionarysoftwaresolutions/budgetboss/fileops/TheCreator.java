package com.visionarysoftwaresolutions.budgetboss.fileops;

import com.visionarysoftwaresolutions.budgetboss.app.BudgetBoss;
import com.visionarysoftwaresolutions.budgetboss.budget.Budget;
import com.visionarysoftwaresolutions.budgetboss.cli.*;

public class TheCreator {
	
	private TheCreator(){}
		
	public static void createBudget(){
		Printer.print("getBudgetName");
		String desiredName = Listener.create().getInput();
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
