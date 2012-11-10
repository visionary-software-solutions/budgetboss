package com.VSSBudgetBoss.fileops;

import java.io.*;

import com.VSSBudgetBoss.budget.Budget;
import com.VSSBudgetBoss.cli.InputListener;
import com.VSSBudgetBoss.cli.InputValidator;
import com.VSSBudgetBoss.cli.ConsoleOutput;

public class Salvation {
	
	private static String getInput(){
		InputListener listener = new InputListener();
		String userInput = listener.listenForInput();
		return userInput;
	}
	
	private String askForSaveDirectory(String defaultDirectory){
		String userPath = "ERROR";
		while(userPath.equals("ERROR")){
			InputValidator validator = new InputValidator();
			userPath = getInput();
			userPath = validator.defaultDirectoryCheck(userPath, defaultDirectory);
		}
		return userPath;				
	}
	
	public void askToSaveBudget(String fileName, Budget budget, String pathToSalvation){
		InputValidator validator = new InputValidator();
		ConsoleOutput.pathToSalvationCheck(pathToSalvation);
		String validatedInput = validator.inputIsEitherYOrN(getInput());
		if(validatedInput.equals("y"))
			saveOnExit(fileName, budget, pathToSalvation);
		else if(validatedInput.equals("n")){
			ConsoleOutput.getSaveDirectoryPath(pathToSalvation);
			pathToSalvation = askForSaveDirectory(pathToSalvation);
			saveOnExit(fileName, budget, pathToSalvation);		
		}
	}
	
	private void saveOnExit(String fileName, Budget budget, String pathToSalvation){
			try{
				FileOutputStream autoSave = new FileOutputStream(pathToSalvation + fileName + ".bgt");
				ObjectOutputStream saveOutput = new ObjectOutputStream(autoSave);
				saveOutput.writeObject(budget);
				saveOutput.close();
				System.out.println("Budget saved! Adios, amigo.");
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}

