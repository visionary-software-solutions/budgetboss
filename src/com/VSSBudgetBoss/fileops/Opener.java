package com.VSSBudgetBoss.fileops;

import java.io.*;
import com.VSSBudgetBoss.budget.Budget;
import com.VSSBudgetBoss.cli.*;
import com.VSSBudgetBoss.main.BudgetBoss;

public class Opener {
	
	private boolean promptCleared = true;
	
	public boolean isPromptCleared(){
		return promptCleared;
	}

	public void askToOpenBudget(){
		InputValidator validator = new InputValidator();
		InputListener listener = new InputListener();
		BudgetBoss.printPrompt("existingBudget");
		String toCheck = listener.listenForInput();
		while(validator.inputIsNotYOrN(toCheck)){
			BudgetBoss.printPrompt("invalidEntryYN");
			toCheck = listener.listenForInput();
		}
		if(toCheck.equalsIgnoreCase("y"))
			getUserDirectoryPath();
		else{
			BudgetBoss.printPrompt("dontSearchBudgets");
			promptCleared = false;
		}
	}
		
	private void getUserDirectoryPath(){
		InputListener listener = new InputListener();
		InputValidator validator = new InputValidator();
		BudgetFinder finder = new BudgetFinder();
		BudgetBoss.printPrompt("savedInDefault");
		System.out.println(BudgetBoss.getDefaultDirectory());
		BudgetBoss.printPrompt("whereSaved");
		String toCheck = listener.listenForInput();
		while(validator.notDefaultNorAPath(toCheck))
			toCheck = listener.listenForInput();
		if(toCheck.equalsIgnoreCase("y"))
			File[] foundBudgets = finder.findBudgets(BudgetBoss.getDefaultDirectory());
		BudgetBoss.printPrompt("searchingDirectory");
		File[] foundBudgets = finder.findBudgets(toCheck);
		if(foundBudgets.length > 0){
			finder.printFoundBudgets(foundBudgets);
			BudgetBoss.printPrompt("openBudget");
			int index = -1;
			while(index < 0)
				index = getBudgetNumberToOpen(foundBudgets);
			System.out.println("Opening " + foundBudgets[index].getName());
			BudgetBoss.setCurrentBudget(loadBudget(index, foundBudgets));
			BudgetBoss.setDefaultDirectory(toCheck);
			TheCreator.notStillBudgetless();
			promptCleared = false;
		}
		else
			BudgetBoss.printPrompt("noBudgetFound");
	}
	
	private int getBudgetNumberToOpen(File[] foundBudgets){
		InputListener listener = new InputListener();
		InputValidator validator = new InputValidator();
		String toCheck = listener.listenForInput();
		if(validator.validatesBudgetSelection(toCheck, foundBudgets))
			return (Integer.valueOf(toCheck) - 1);
		else return -1;
	}
	
	private Budget loadBudget(int index, File[] foundBudgets){
		FileInputStream newBudget = null;
		ObjectInputStream toLoad = null;
		Object loadedBudget = null;
		try {
			newBudget = new FileInputStream(foundBudgets[index].toString());
		} catch (FileNotFoundException e) {
			BudgetBoss.printPrompt("wTF");
			System.out.println("Error making the FileInputStream");
		}
		try {
			toLoad = new ObjectInputStream(newBudget);
		} catch (IOException e) {
			BudgetBoss.printPrompt("wTF");
			System.out.println("Error making the ObjectInputStream");
		}
		try {
			loadedBudget = toLoad.readObject();
		} catch (ClassNotFoundException | IOException e) {
			BudgetBoss.printPrompt("wTF");
			System.out.println("IO exception, maybe the file is bad?");
		}
		try {
			toLoad.close();
		} catch (IOException e) {
			BudgetBoss.printPrompt("wTF");
			System.out.println("Couldn't close the Object/File input streams.");
		}
		return (Budget) loadedBudget;
	}
}
