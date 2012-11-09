package com.VSSBudgetBoss.fileops;

import java.io.File;

import com.VSSBudgetBoss.cli.InputListener;
import com.VSSBudgetBoss.cli.InputValidator;
import com.VSSBudgetBoss.cli.Prompts;
import com.VSSBudgetBoss.main.BudgetBoss;

public class Opener {
	
	private boolean promptNeedsToClear = true;
	private boolean budgetsExist = false;

	public void askToOpenBudget(String defaultDirectory){
		InputValidator validator = new InputValidator();
		InputListener listener = new InputListener();
		Prompts.existingBudgetPrompt();
		String validatedInput = validator.inputIsEitherYOrN(listener.listenForInput());
		if(validatedInput.equals("y"))
			getUserDirectoryPath(defaultDirectory);
		else if(validatedInput.equals("n")){
			Prompts.dontSearchBudgets();
			promptNeedsToClear = false;		
		}
		else
			Prompts.invalidEntryPromptYOrN();
	}
		
	private void getUserDirectoryPath(String defaultDirectory){
		String validatedPath = "ERROR";
		BudgetFinder finder = new BudgetFinder();
		Prompts.getLoadDirectoryPath(defaultDirectory);
		while(validatedPath.equals("ERROR")){
			InputValidator validator = new InputValidator();
			InputListener listener = new InputListener();
			String userPath = listener.listenForInput();
			validatedPath = validator.defaultDirectoryCheck(userPath, defaultDirectory);
		}
		BudgetBoss.setDefaultDirectory(validatedPath);
		Prompts.searchingDirectory();
		File[] foundBudgets = finder.findBudgets(defaultDirectory);
		if(foundBudgets.length > 0)
			printBudgets(finder, foundBudgets);
		else
			Prompts.noBudgetFound();
	}
	
	private void printBudgets(BudgetFinder finder, File[] foundBudgets){
		finder.printFoundBudgets(foundBudgets);
		Prompts.openBudgetPrompt();
		promptNeedsToClear = false;
		budgetsExist = true;
	}
	
	public boolean promptNeedsToClear(){
		return promptNeedsToClear;
	}
}
