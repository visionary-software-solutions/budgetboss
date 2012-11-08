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
	
	private String askForLoadDirectory(String defaultDirectory){
		InputValidator validator = new InputValidator();
		Prompts.getLoadDirectoryPath();
		String userPath = getInput();
		if(validator.validateUserPath(userPath))
			return userPath;
		else {
			Prompts.badPathInput(defaultDirectory);
			return defaultDirectory;
		}
		
	}
	
	public void askToOpenBudget(String defaultDirectory){
		InputValidator validator = new InputValidator();
		BudgetFinder finder = new BudgetFinder();
		String validatedInput = validator.inputIsEitherYOrN(getInput());
		if(validatedInput.equals("y")){
			defaultDirectory = askForLoadDirectory(defaultDirectory);
			Prompts.searchingUserDirectory(defaultDirectory);
			File[] foundBudgets = finder.findBudgets(defaultDirectory);
			try{
				finder.printFoundBudgets(foundBudgets);
			}catch (NullPointerException e){
				Prompts.noBudgetFound();
			}
			Prompts.openBudgetPrompt();
			openPromptCleared();
			budgetExists();
		}
		else if(validatedInput.equals("n")){
			Prompts.dontSearchBudgets();
			openPromptCleared();		
		}
		else
			Prompts.invalidEntryPromptYOrN();
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
