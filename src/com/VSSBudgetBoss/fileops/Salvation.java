package com.VSSBudgetBoss.fileops;

import java.io.*;
import com.VSSBudgetBoss.budget.Budget;
import com.VSSBudgetBoss.cli.*;

public class Salvation {
	
	public void saveBudget(String fileName, Budget budget, String pathToSalvation){
		InputValidator validator = new InputValidator();
		System.out.println("Save in " + pathToSalvation + "? (y/n)");
		String toCheck = Listener.getInput();
		while(validator.inputIsNotYOrN(toCheck))
			toCheck = Listener.getInput();
		if(toCheck.equalsIgnoreCase("y"))
			writeBudgetToDisk(fileName, budget, pathToSalvation);
		else{
			Prompter.printPrompt("getSaveDirectoryPath");
			pathToSalvation = getUserSaveDirectory();
			writeBudgetToDisk(fileName, budget, pathToSalvation);		
			}
		}
	
	private String getUserSaveDirectory(){
		InputValidator validator = new InputValidator();
		String toCheck = Listener.getInput();
		while(validator.pathIsInvalid(toCheck))
			toCheck = Listener.getInput();
		return toCheck;				
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

