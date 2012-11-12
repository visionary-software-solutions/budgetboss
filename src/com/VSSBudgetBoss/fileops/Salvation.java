package com.VSSBudgetBoss.fileops;

import java.io.*;
import com.VSSBudgetBoss.budget.Budget;
import com.VSSBudgetBoss.cli.*;
import com.VSSBudgetBoss.main.BudgetBoss;

public class Salvation {
	
	public void saveBudget(String fileName, Budget budget, String pathToSalvation){
		InputValidator validator = new InputValidator();
		InputListener listener = new InputListener();
		System.out.println("Save in " + pathToSalvation + "? (y/n)");
		String toCheck = listener.listenForInput();
		while(validator.inputIsNotYOrN(toCheck))
			toCheck = listener.listenForInput();
		if(toCheck.equalsIgnoreCase("y"))
			writeBudgetToDisk(fileName, budget, pathToSalvation);
		else{
			BudgetBoss.printPrompt("getSaveDirectoryPath");
			pathToSalvation = getUserSaveDirectory();
			writeBudgetToDisk(fileName, budget, pathToSalvation);		
			}
		}
	
	private String getUserSaveDirectory(){
		InputListener listener = new InputListener();
		InputValidator validator = new InputValidator();
		String toCheck = listener.listenForInput();
		while(validator.pathIsInvalid(toCheck))
			toCheck = listener.listenForInput();
		return toCheck;				
	}

	private void writeBudgetToDisk(String fileName, Budget budget, String pathToSalvation){
			try{
				FileOutputStream saveFile = new FileOutputStream(pathToSalvation + fileName + ".bgt");
				ObjectOutputStream saveOutput = new ObjectOutputStream(saveFile);
				saveOutput.writeObject(budget);
				saveOutput.close();
				BudgetBoss.printPrompt("budgetSaved");
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}

