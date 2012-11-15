package com.VSSBudgetBoss.main;

import com.VSSBudgetBoss.budget.*;
import com.VSSBudgetBoss.fileops.*;
import com.VSSBudgetBoss.cli.*;

public class BudgetBoss {
	
	static Opener opener = new Opener();
	static TheCreator god = new TheCreator();
	static Budget currentBudget = new Budget("No Budget Loaded");
	static String defaultDirectory;
	static boolean loadASavedBudget = true;
	static boolean needANewBudget = true;
	static MainMenu mainMenu;
	
	public static void loadSavedBudget(){
		loadASavedBudget = true;
	}
	
	public static void endLoadSavedBudget(){
		loadASavedBudget = false;
	}
	
	public static void needNewBudget(){
		needANewBudget = true;
	}
	
	public static void endNeedNewBudget(){
		needANewBudget = false;
	}
	
	public static void setDefaultDirectory(String newDefaultDirectory){
		defaultDirectory = newDefaultDirectory;
	}
	
	public static String getDefaultDirectory(){
		return defaultDirectory;
	}

	public static void setCurrentBudget(Budget newBudget){
		currentBudget = newBudget;
		mainMenu = new MainMenu(newBudget);
	}
		
	public static void main(String args[]){
		
		String currentUser = System.getProperty("user.name");
		defaultDirectory = "/home/" + currentUser + "/Documents/";
		mainMenu = new MainMenu(currentBudget);
		Prompter.printPrompt("welcome");
		
		while (mainMenu.stillUsingBudgetBoss()){
			mainMenu.displayMainMenu();
			while(loadASavedBudget)
				opener.openExistingFile();
			while(needANewBudget)
				god.bestMakeABudgetNow();
		}
	}
}


