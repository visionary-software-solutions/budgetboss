package com.VSSBudgetBoss.fileops;

import java.io.*;

import com.VSSBudgetBoss.budget.Budget;
import com.VSSBudgetBoss.cli.*;
import com.VSSBudgetBoss.main.BudgetBoss;

public class Opener {
	
	private boolean promptCleared = true;

	public void askToOpenBudget(String defaultDirectory){
		InputValidator validator = new InputValidator();
		InputListener listener = new InputListener();
		BudgetBoss.printPrompt("existingBudget");
		String validatedInput = validator.inputIsEitherYOrN(listener.listenForInput());
		if(validatedInput.equals("y"))
			getUserDirectoryPath(defaultDirectory);
		else if(validatedInput.equals("n")){
			BudgetBoss.printPrompt("dontSearchBudgets");
			promptCleared = false;
		}
		else
			BudgetBoss.printPrompt("invalidEntryYN");
	}
		
	private void getUserDirectoryPath(String defaultDirectory){
		String validatedPath = "ERROR";
		BudgetFinder finder = new BudgetFinder();
		BudgetBoss.printPrompt("savedInDefault");
		System.out.println(BudgetBoss.getDefaultDirectory());
		BudgetBoss.printPrompt("whereSaved");
		while(validatedPath.equals("ERROR")){
			InputValidator validator = new InputValidator();
			InputListener listener = new InputListener();
			String userPath = listener.listenForInput();
			validatedPath = validator.defaultDirectoryCheck(userPath, defaultDirectory);
		}
		BudgetBoss.printPrompt("searchingDirectory");
		File[] foundBudgets = finder.findBudgets(validatedPath);
		if(foundBudgets.length > 0){
			finder.printFoundBudgets(foundBudgets);
			BudgetBoss.printPrompt("openBudget");
			int index = -1;
			while(index < 0)
				index = getBudgetNumberToOpen(foundBudgets);
			System.out.println("Opening " + foundBudgets[index].getName());
			BudgetBoss.setCurrentBudget(loadBudget(index, foundBudgets));
			BudgetBoss.setDefaultDirectory(validatedPath);
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
		if(validator.validateBudgetSelection(toCheck, foundBudgets))
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
	
	public boolean promptNeedsToClear(){
		return promptCleared;
	}
}
