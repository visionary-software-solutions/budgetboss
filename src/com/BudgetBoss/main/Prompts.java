package com.BudgetBoss.main;

public class Prompts {
	
	public static void welcomeToBudgetBoss(){
		System.out.println("Welcome to BudgetBoss!");
		System.out.println("Manage your money...like a boss.");
	}
	
	public static void existingBudgetPrompt(){
		System.out.println("Is there an existing Budget you want to open? (y/n)");
	}
	
	public static void openBudgetPrompt(){
		System.out.println ("Which budget do you want to open? (#)");
	}
	
	public static void invalidEntryPromptYOrN(){
		System.out.println("Invalid entry! Try again.(y/n)");
	}
	
	public static void searchingDirectory(){
		System.out.println("Searching for budgets...");
	}
	
	public static void noBudgetFound(){
		System.out.println("You don't have any saved Budgets there!");
	}
	
	public static void noBudgetToSave(){
		System.out.println("No Budget to save!");
	}
	
	public static void dontSearchBudgets(){
		System.out.println("No saved budget? Ok!");
	}
	
	public static void createNewBudgetPrompt(){
		System.out.println("Would you like to create a new Budget? (y/n)");
	}
	
	public static void getBudgetNamePrompt(){
		System.out.println("Let's make a budget!");
		System.out.println("What do you want to name the Budget?");
	}
	
	public static void showDesiredBudgetName(String name){
		System.out.println("Creating Budget " + name + "...");
	}
	
	public static void fuckThisProgram(){
		System.out.println("You've got no saved budgets...and you don't want to make one...");
		System.out.println("So I can only assume you're flipping me off right now. Adios, amigo!");
	}
	
	public static void getLoadDirectoryPath(String defaultDirectory){
		System.out.println("Where is the budget saved? The default directory is:");
		System.out.println(defaultDirectory);
		System.out.println("Enter y for the default, or enter path below:");
	}
	
	public static void badPathInput(String defaultDirectory){
		System.out.println("That's not a valid path, yo. Enter y for the default or enter a path:");
		System.out.println("(" + defaultDirectory + " is the default)");
	}
	
	public static void pathToSalvationCheck(String defaultDirectory){
		System.out.println("Save in " + defaultDirectory + "?");
	}
	
}

