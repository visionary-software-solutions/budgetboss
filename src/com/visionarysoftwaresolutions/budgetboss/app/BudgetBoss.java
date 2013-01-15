package com.visionarysoftwaresolutions.budgetboss.app;

import static org.fusesource.jansi.Ansi.ansi;
import org.fusesource.jansi.AnsiConsole;

import com.visionarysoftwaresolutions.budgetboss.budget.*;
import com.visionarysoftwaresolutions.budgetboss.cli.*;
import com.visionarysoftwaresolutions.budgetboss.fileops.*;
import com.visionarysoftwaresolutions.budgetboss.menu.*;

public class BudgetBoss {
	
	static Budget currentBudget = new Budget("No budget loaded");
	static String defaultDirectory;
	static MasterMenu mainMenu;
	static boolean stillUsingBudgetBoss = true;
	static boolean loadASavedBudget = true;
	static boolean needANewBudget = true;
	
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
	
	public static void doneUsingBudgetBoss(){
		stillUsingBudgetBoss = false;
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
	
	public static String getCurrentBudget(){
		return currentBudget.getName();
	}
		
	public static void main(String args[]){
		AnsiConsole.out.println(ansi().eraseScreen());
		defaultDirectory = Finder.pathFinder();
		mainMenu = new MainMenu(currentBudget);
		Printer.print("welcome");
		TakeInput.getInput();
		
		while (stillUsingBudgetBoss){
			mainMenu.getOption(mainMenu);
			while(loadASavedBudget)
				Opener.getLoadDirectory();
			while(needANewBudget)
				TheCreator.createBudget();
		}
	}
}