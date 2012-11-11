package com.VSSBudgetBoss.main;

import com.VSSBudgetBoss.budget.*;
import com.VSSBudgetBoss.fileops.Salvation;

public class MainMenu {
	
	Budget currentBudget;
	
	public MainMenu(Budget currentBudget){
		this.currentBudget = currentBudget;
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
		if(userInput == 1)
			System.out.println(currentBudget.toString());
		if(userInput ==2){
			BudgetEditor editor = new BudgetEditor(currentBudget);
			while(editor.stillEditingBudget()){
				editor.displayEditorMainMenu();
			}
		}
		if(userInput == 3)
			choseToSaveBudget();
		if(userInput == 4)
			usingBudgetBoss = false;
	}
	
	private void choseToSaveBudget(){
		Salvation savior = new Salvation();
		savior.saveBudget(currentBudget.getName(), currentBudget, BudgetBoss.getDefaultDirectory());
	}
}
