package com.BudgetBoss.main;

import java.io.File;

public class BudgetBoss {
	
	static InputListener listener;
	static Prompter prompter = new Prompter();
	static Budget currentBudget = null;
	static InputValidator validator;
	static BudgetFinder finder = new BudgetFinder();
	
	public static String getInput(){
		listener = new InputListener();
		validator = new InputValidator();
		String userInput = listener.listenForInput();
		return userInput;
		}
	
	public static void askToOpenBudget(String defaultDirectory, boolean promptCleared, boolean budgetExists){
		File[] foundBudgets;
		String validatedInput = validator.inputIsEitherYOrN(getInput());
		if(validatedInput.equals("y")){
			foundBudgets = finder.findBudgets(defaultDirectory);
			finder.printFoundBudgets(foundBudgets);
			Prompter.openBudgetPrompt();
			promptCleared = true;
			budgetExists = true;
		}
		else if(validatedInput.equals("n")){
			Prompter.dontSearchBudgets();
			promptCleared = true;
		}
		else
			Prompter.invalidEntryPromptYOrN();
	}
	
	public static void askToCreateBudget(boolean budgetExists){
		Prompter.createNewBudgetPrompt();
		String validatedInput = validator.inputIsEitherYOrN(getInput());
		if(validatedInput.equals("y")){
			Prompter.getBudgetNamePrompt();
			String desiredName = getInput();
			currentBudget = new Budget(desiredName);
			Prompter.showDesiredBudgetName(desiredName);
			budgetExists = true;
		}
		else if(validatedInput.equals("n")){
			Prompter.fuckThisProgram();
			budgetExists = true;
		}
		else
			Prompter.invalidEntryPromptYOrN();
	}
	
	public static void main(String args[]){
		String validatedInput;
		File[] foundBudgets;
		String defaultDirectory = "/home/visionary/Programming/training/BudgetBoss/SavedBudgets/";
		boolean openPromptCleared = false;
		boolean newPromptCleared = false;
		boolean budgetExists = false;
		
		System.out.println("Welcome to BudgetBoss!");
		System.out.println("Manage your money...like a boss.");
		System.out.println("Is there an existing Budget you want to open? (y/n)");
		
		while(!openPromptCleared)
			askToOpenBudget(defaultDirectory, openPromptCleared, budgetExists);
		
		
		while(!budgetExists){
			askToCreateBudget(budgetExists);
		}
		
		Salvation savior = new Salvation();
		try{	
			savior.saveOnExit(currentBudget.getName(), currentBudget);
		}catch (NullPointerException e){
		System.out.println("No Budget to save!");
		}
	}
}
