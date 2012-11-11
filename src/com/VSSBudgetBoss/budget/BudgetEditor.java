package com.VSSBudgetBoss.budget;

import com.VSSBudgetBoss.cli.*;
import com.VSSBudgetBoss.main.BudgetBoss;

public class BudgetEditor {
	
	Budget toEdit;
	
	private boolean stillEditing = true;

	public BudgetEditor(Budget toEdit){
		this.toEdit = toEdit;
	}
	
	public boolean stillEditingBudget(){
		return stillEditing;
	}
	
	//For these menu selections, there HAS to be a way pull out the method blocks in the ifs and 
	//then call those methods from an array or something, based on the numerical input.
	//Or something similar, rather than hardcoding and if-checking the numeric choices.
	//Look that shit up, you.
	
	public void displayEditorMainMenu(){
		BudgetBoss.printPrompt("editorMainMenu");
		InputListener listener = new InputListener();
		InputValidator validator = new InputValidator();
		String userInput = listener.listenForInput();
		if(validator.validatesMainEditorChoice(userInput)){
			int input = Integer.valueOf(userInput);
			if (input == 1)
				System.out.println(toEdit.toString());
			if (input == 2){
				BudgetBoss.printPrompt("getNewName");
				String newBudgetName = listener.listenForInput();
				toEdit.setName(newBudgetName);
			}
			if (input == 3){
				BudgetBoss.printPrompt("getNewStartDate");
				String newStartDate = listener.listenForInput();
				toEdit.setStartDate(newStartDate);
			}
			if (input == 4){
				BudgetBoss.printPrompt("getNewEndDate");
				String newEndDate = listener.listenForInput();
				toEdit.setEndDate(newEndDate);
			}
			if (input == 5){
				stillEditing = false;
			}
		}

	}
}
