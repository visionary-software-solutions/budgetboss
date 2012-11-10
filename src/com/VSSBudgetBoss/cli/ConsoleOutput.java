package com.VSSBudgetBoss.cli;

import com.VSSBudgetBoss.main.BudgetBoss;

public class ConsoleOutput {

	public static void creatingBudget(String name){
		System.out.println("Creating budget " + name + "...");
	}
	
	public static void getLoadDirectoryPath(){
		System.out.println("Where is the budget saved? The default directory is:");
		System.out.println(BudgetBoss.getDefaultDirectory());
		System.out.println("Enter y for the default, or enter path below:");
	}
	
	public static void giveDefaultDir(){
		System.out.println("(" + defaultDirectory + " is the default)");
	}
	
	public static void pathToSalvationCheck(String defaultDirectory){
		System.out.println("Save in " + defaultDirectory + "? (y/n)");
	}
	
	public static void openingSelectedBudget(String name) {
		System.out.println("Opening " + name);
	}
	
}

