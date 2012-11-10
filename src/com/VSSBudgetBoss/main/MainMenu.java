package com.VSSBudgetBoss.main;

import com.VSSBudgetBoss.budget.Budget;
import com.VSSBudgetBoss.fileops.Salvation;

public class MainMenu {
	
	Budget toEdit;
	
	public MainMenu(Budget toEdit){
		this.toEdit = toEdit;
	}
	
	private boolean usingBudgetBoss = true;
	
	public boolean stillUsingBudgetBoss(){
		return usingBudgetBoss;
	}

	public void displayMenu() {
		BudgetBoss.printPrompt("mainMenu");
	}
	
	public void menuSelection(String toSelect){
		int userInput = Integer.valueOf(toSelect);
		if(userInput == 3)
			choseToSaveBudget();
		if(userInput == 4)
			usingBudgetBoss = false;
	}
	
	private void choseToSaveBudget(){
		Salvation savior = new Salvation();
		savior.saveBudget(toEdit.getName(), toEdit, BudgetBoss.getDefaultDirectory());
	}
}
