package com.VSSBudgetBoss.fileops;

import java.io.*;
import com.VSSBudgetBoss.budget.Budget;
import com.VSSBudgetBoss.cli.*;
import com.VSSBudgetBoss.main.BudgetBoss;

public class Salvation {
	
	InputValidator validator = new InputValidator();
	
	public void saveBudget(String fileName, Budget budget){
		System.out.println("Save in " + BudgetBoss.getDefaultDirectory() + "? (y/n)");
		String toCheck = Listener.getInput();
		while(validator.inputIsNotYOrN(toCheck))
			toCheck = Listener.getInput();
		if(toCheck.equalsIgnoreCase("y"))
			writeBudgetToDisk(fileName, budget, BudgetBoss.getDefaultDirectory());
		else{
			Prompter.printPrompt("getSaveDirectoryPath");
			System.out.println("The default is: " + BudgetBoss.getDefaultDirectory());
			getUserSaveDirectory(fileName, budget);
			}
		}
	
	private void getUserSaveDirectory(String fileName, Budget budget){
		String toCheck = Listener.getInput();
		while(validator.pathIsInvalid(toCheck))
			toCheck = Listener.getInput();
		if(toCheck.equalsIgnoreCase("y")){
			writeBudgetToDisk(fileName, budget, BudgetBoss.getDefaultDirectory());
		}else
			writeBudgetToDisk(fileName, budget, toCheck);
	}

	private void writeBudgetToDisk(String fileName, Budget budget, String pathToSalvation){
			try{
				FileOutputStream saveFile = new FileOutputStream(pathToSalvation + fileName + ".bgt");
				ObjectOutputStream saveOutput = new ObjectOutputStream(saveFile);
				saveOutput.writeObject(budget);
				saveOutput.close();
				Prompter.printPrompt("budgetSaved");
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}

