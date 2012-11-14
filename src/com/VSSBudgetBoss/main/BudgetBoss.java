package com.VSSBudgetBoss.main;

import com.VSSBudgetBoss.budget.*;
import com.VSSBudgetBoss.fileops.*;
import com.VSSBudgetBoss.cli.*;

public class BudgetBoss {
	
	static Opener opener = new Opener();
	static TheCreator god = new TheCreator();
	static Budget currentBudget = new Budget("defaultBudget");
	static String defaultDirectory;
	static boolean loadASavedBudget = true;
	
	public static void endLoadSavedBudget(){
		loadASavedBudget = false;
	}
	
	public static void setDefaultDirectory(String newDefaultDirectory){
		defaultDirectory = newDefaultDirectory;
	}
	
	public static String getDefaultDirectory(){
		return defaultDirectory;
	}

	public static void setCurrentBudget(Budget newBudget){
		currentBudget = newBudget;
	}
		
	public static void main(String args[]){
		String currentUser = System.getProperty("user.name");
		defaultDirectory = "/home/" + currentUser + "/Documents/";
		
		Prompter.printPrompt("welcome");
		
		while(loadASavedBudget)
			opener.openExistingFile();
		
		while(TheCreator.isSlackingOnFinances())
			god.bestMakeABudgetNow();
		
		if(!(currentBudget.getName().equals("defaultBudget"))){
			MainMenu mainMenu = new MainMenu(currentBudget);
			while(mainMenu.stillUsingBudgetBoss()){
				mainMenu.displayMainMenu();
			}
		}
	}
}


