package com.VSSBudgetBoss.fileops;

import java.io.*;

import com.VSSBudgetBoss.budget.Budget;
import com.VSSBudgetBoss.cli.*;
import com.VSSBudgetBoss.main.BudgetBoss;

public class Opener {
	
	InputValidator validator = new InputValidator();
	
	public void openExistingFile(){
		Prompter.printPrompt("existingBudget");
		String toCheck = Listener.getInput();
		while(validator.inputIsNotYOrN(toCheck)){
			Prompter.printPrompt("invalidEntryYN");
			toCheck = Listener.getInput();
		}
		if(toCheck.equalsIgnoreCase("y")){
			getLoadDirectory();
		}else{
			Prompter.printPrompt("dontSearchBudgets");
			BudgetBoss.endLoadSavedBudget();
		}
	}
		
	public void getLoadDirectory(){
		Prompter.printPrompt("savedInDefault");
		System.out.println(BudgetBoss.getDefaultDirectory());
		Prompter.printPrompt("whereSaved");
		String toCheck = Listener.getInput();
		while(validator.pathIsInvalid(toCheck))
			toCheck = Listener.getInput();
		if(toCheck.equalsIgnoreCase("y")){
			searchDirectory(BudgetBoss.getDefaultDirectory());
		}else{
			searchDirectory(toCheck);
			BudgetBoss.setDefaultDirectory(toCheck);
		}
	}
		
	private void searchDirectory(String directoryToSearch){
		Prompter.printPrompt("searchingDirectory");
		File [] foundBudgets = Finder.findBudgets(directoryToSearch);
		if(foundBudgets.length > 0){
			selectBudget(foundBudgets);
		}else
			Prompter.printPrompt("noBudgetFound");
	}
	
	private void selectBudget(File[] foundBudgets){
		Finder.printFoundBudgets(foundBudgets);
		Prompter.printPrompt("openBudget");
		int index = getNumberToOpen(foundBudgets);
		System.out.println("Opening " + foundBudgets[index].getName() + "...\n");
		BudgetBoss.setCurrentBudget(loadBudget(index, foundBudgets));
		TheCreator.budgetLoaded();
	}
	
	private int getNumberToOpen(File[] foundBudgets){
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
		BudgetBoss.endLoadSavedBudget();
		return (Budget) loadedBudget;
	}
}
