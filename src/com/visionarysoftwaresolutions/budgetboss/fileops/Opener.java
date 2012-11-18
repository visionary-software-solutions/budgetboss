package com.visionarysoftwaresolutions.budgetboss.fileops;

import java.io.*;
import com.visionarysoftwaresolutions.budgetboss.app.BudgetBoss;
import com.visionarysoftwaresolutions.budgetboss.budget.Budget;
import com.visionarysoftwaresolutions.budgetboss.cli.*;

public class Opener {
	
	InputValidator validator = new InputValidator();
	
	public void loadFromDirectory(){
		Printer.printPrompt("savedInDefault");
		System.out.println(BudgetBoss.getDefaultDirectory());
		Printer.printPrompt("whereSaved");
		String toCheck = Listener.getInput();
		while(validator.pathIsInvalid(toCheck))
			toCheck = Listener.getInput();
		if(!(toCheck.equals("exit"))){
			if(toCheck.equalsIgnoreCase("y")){
				searchDirectory(BudgetBoss.getDefaultDirectory());
			}else
				searchDirectory(toCheck);
		}
	}
		
	private void searchDirectory(String directoryToSearch){
		Printer.printPrompt("searchingDirectory");
		File [] foundBudgets = Finder.findBudgets(directoryToSearch);
		if(foundBudgets.length > 0){
			selectBudget(foundBudgets);
			BudgetBoss.setDefaultDirectory(directoryToSearch);
		}else
			Printer.printPrompt("noBudgetFound");
	}
	
	private void selectBudget(File[] foundBudgets){
		Printer.printFoundBudgets(foundBudgets);
		Printer.printPrompt("openBudget");
		int index = getNumberToOpen(foundBudgets);
		if(!(index == -5)){
			System.out.println("Opening " + foundBudgets[index].getName() + "...\n");
			BudgetBoss.setCurrentBudget(loadBudget(index, foundBudgets));
			BudgetBoss.endNeedNewBudget();
		}
	}
	
	private int getNumberToOpen(File[] foundBudgets){
		String toCheck = Listener.getInput();
		int highestChoice = foundBudgets.length;
		while(validator.inputNotABudget(toCheck, highestChoice))
			toCheck = Listener.getInput();
		if(!(toCheck.equals("exit")))
			return (Integer.valueOf(toCheck) - 1);
		else
			return -5;
	}
	
	private Budget loadBudget(int index, File[] foundBudgets){
		FileInputStream newBudget = null;
		ObjectInputStream toLoad = null;
		Object loadedBudget = null;
		try {
			newBudget = new FileInputStream(foundBudgets[index].toString());
		} catch (FileNotFoundException e) {
			Printer.printPrompt("wTF");
			System.out.println("Error making the FileInputStream");
		}
		try {
			toLoad = new ObjectInputStream(newBudget);
		} catch (IOException e) {
			Printer.printPrompt("wTF");
			System.out.println("Error making the ObjectInputStream");
		}
		try {
			loadedBudget = toLoad.readObject();
		} catch (ClassNotFoundException | IOException e) {
			Printer.printPrompt("wTF");
			System.out.println("IO exception, maybe the file is bad?");
		}
		try {
			toLoad.close();
		} catch (IOException e) {
			Printer.printPrompt("wTF");
			System.out.println("Couldn't close the Object/File input streams.");
		}
		BudgetBoss.endLoadSavedBudget();
		return (Budget) loadedBudget;
	}
}
