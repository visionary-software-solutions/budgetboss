package com.VSSBudgetBoss.cli;

import java.io.File;

import com.VSSBudgetBoss.budget.Budget;

public class PrompterLogic {
	
	static boolean openPromptCleared = false;
	static boolean budgetExists = false;
	
	private void openPromptCleared(){
		openPromptCleared = true;
	}
	
	public boolean getPromptClearedStatus(){
		return openPromptCleared;
	}
	
	private void budgetExists(){
		budgetExists = true;
	}
	
	public boolean getBudgetExistsStatus(){
		return budgetExists;
	}
	
	private static String getInput(){
		InputListener listener = new InputListener();
		String userInput = listener.listenForInput();
		return userInput;
		}
	
	public Budget askToCreateBudget(){
		Prompts.createNewBudgetPrompt();
		InputValidator validator = new InputValidator();
		String validatedInput = validator.inputIsEitherYOrN(getInput());
		if(validatedInput.equals("y")){
			Prompts.getBudgetNamePrompt();
			String desiredName = getInput();
			Budget currentBudget = new Budget(desiredName);
			Prompts.showDesiredBudgetName(desiredName);
			budgetExists();
			return currentBudget;
		}
		else if(validatedInput.equals("n")){
			Prompts.fuckThisProgram();
			budgetExists();
			return null;
		}
		else
			Prompts.invalidEntryPromptYOrN();
		return null;
	}

}
