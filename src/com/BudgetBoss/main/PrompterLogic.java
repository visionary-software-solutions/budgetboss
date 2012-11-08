package com.BudgetBoss.main;

import java.io.File;

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
	
	public static String getInput(){
		InputListener listener = new InputListener();
		String userInput = listener.listenForInput();
		return userInput;
		}
	
	public void askToOpenBudget(String defaultDirectory){
		InputValidator validator = new InputValidator();
		BudgetFinder finder = new BudgetFinder();
		String validatedInput = validator.inputIsEitherYOrN(getInput());
		if(validatedInput.equals("y")){
			File[] foundBudgets = finder.findBudgets(defaultDirectory);
			try{
				finder.printFoundBudgets(foundBudgets);
			}catch (NullPointerException e){
				Prompter.noBudgetFound();
			}
			Prompter.openBudgetPrompt();
			openPromptCleared();
			budgetExists();
		}
		else if(validatedInput.equals("n")){
			Prompter.dontSearchBudgets();
			openPromptCleared();		
		}
		else
			Prompter.invalidEntryPromptYOrN();
	}
	
	public Budget askToCreateBudget(){
		Prompter.createNewBudgetPrompt();
		InputValidator validator = new InputValidator();
		String validatedInput = validator.inputIsEitherYOrN(getInput());
		if(validatedInput.equals("y")){
			Prompter.getBudgetNamePrompt();
			String desiredName = getInput();
			Budget currentBudget = new Budget(desiredName);
			Prompter.showDesiredBudgetName(desiredName);
			budgetExists();
			return currentBudget;
		}
		else if(validatedInput.equals("n")){
			Prompter.fuckThisProgram();
			budgetExists();
			return null;
		}
		else
			Prompter.invalidEntryPromptYOrN();
		return null;
	}

}
