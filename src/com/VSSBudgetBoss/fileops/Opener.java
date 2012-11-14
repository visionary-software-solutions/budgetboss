package com.VSSBudgetBoss.fileops;

import java.io.*;

import com.VSSBudgetBoss.budget.Budget;
import com.VSSBudgetBoss.cli.*;
import com.VSSBudgetBoss.main.BudgetBoss;

public class Opener {
	
	public void openExistingFile(){
		Prompter.printPrompt("existingBudget");
		String toCheck = Listener.getInput();
		InputValidator validator = new InputValidator();
		while(validator.inputIsNotYOrN(toCheck)){
			Prompter.printPrompt("invalidEntryYN");
			toCheck = Listener.getInput();
		}
		if(toCheck.equalsIgnoreCase("y")){
			getFileLoadPath();
			BudgetBoss.endLoadSavedBudget();
		}
		else{
			Prompter.printPrompt("dontSearchBudgets");
			BudgetBoss.endLoadSavedBudget();
		}
	}
		
	private void getFileLoadPath(){
		InputValidator validator = new InputValidator();
		BudgetFinder finder = new BudgetFinder();
		File[] foundBudgets;
		
		Prompter.printPrompt("savedInDefault");
		System.out.println(BudgetBoss.getDefaultDirectory());
		Prompter.printPrompt("whereSaved");
		String toCheck = Listener.getInput();
		while(validator.notDefaultNorAPath(toCheck))
			toCheck = Listener.getInput();
		if(toCheck.equalsIgnoreCase("y")){
			Prompter.printPrompt("searchingDirectory");
			foundBudgets = finder.findBudgets(BudgetBoss.getDefaultDirectory());
			selectBudget(foundBudgets, finder);
		}
		else{
			Prompter.printPrompt("searchingDirectory");
			foundBudgets = finder.findBudgets(toCheck);
			if(foundBudgets.length > 0){
				selectBudget(foundBudgets, finder);
				BudgetBoss.setDefaultDirectory(toCheck);
			}
			else
				Prompter.printPrompt("noBudgetFound");
		}
	}
	
	private void selectBudget(File[] foundBudgets, BudgetFinder finder){
		finder.printFoundBudgets(foundBudgets);
		Prompter.printPrompt("openBudget");
		int index = getBudgetNumberToOpen(foundBudgets);
		System.out.println("Opening " + foundBudgets[index].getName());
		BudgetBoss.setCurrentBudget(loadBudget(index, foundBudgets));
		TheCreator.notStillBudgetless();
	}
	
	private int getBudgetNumberToOpen(File[] foundBudgets){
		InputValidator validator = new InputValidator();
		String toCheck = Listener.getInput();
		int highestChoice = foundBudgets.length;
		while(validator.inputNotABudget(toCheck, highestChoice))
			toCheck = Listener.getInput();
		return (Integer.valueOf(toCheck) - 1);
		
	}
	
	private Budget loadBudget(int index, File[] foundBudgets){
		FileInputStream newBudget = null;
		ObjectInputStream toLoad = null;
		Object loadedBudget = null;
		try {
			newBudget = new FileInputStream(foundBudgets[index].toString());
		} catch (FileNotFoundException e) {
			Prompter.printPrompt("wTF");
			System.out.println("Error making the FileInputStream");
		}
		try {
			toLoad = new ObjectInputStream(newBudget);
		} catch (IOException e) {
			Prompter.printPrompt("wTF");
			System.out.println("Error making the ObjectInputStream");
		}
		try {
			loadedBudget = toLoad.readObject();
		} catch (ClassNotFoundException | IOException e) {
			Prompter.printPrompt("wTF");
			System.out.println("IO exception, maybe the file is bad?");
		}
		try {
			toLoad.close();
		} catch (IOException e) {
			Prompter.printPrompt("wTF");
			System.out.println("Couldn't close the Object/File input streams.");
		}
		return (Budget) loadedBudget;
	}
}
