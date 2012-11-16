package com.VSSBudgetBoss.fileops;

import java.io.*;
import com.VSSBudgetBoss.budget.Budget;
import com.VSSBudgetBoss.cli.*;
import com.VSSBudgetBoss.main.BudgetBoss;

public class Salvation {
	
	InputValidator validator = new InputValidator();
	
	public void getSaveDirectory(String fileName, Budget budget){
		Prompter.printPrompt("getSaveDirectoryPath");
		System.out.println("The default is: " + BudgetBoss.getDefaultDirectory());
		String toCheck = Listener.getInput();
		while(validator.pathIsInvalid(toCheck))
			toCheck = Listener.getInput();
		if(!(toCheck.equals("exit"))){
			if(toCheck.equalsIgnoreCase("y")){
				writeBudgetToDisk(fileName, budget, BudgetBoss.getDefaultDirectory());
			}else
				writeBudgetToDisk(fileName, budget, toCheck);
		}
	}

	private void writeBudgetToDisk(String fileName, Budget budget, String pathToSalvation){
			try{
				FileOutputStream saveFile = new FileOutputStream(pathToSalvation + fileName + ".bgt");
				ObjectOutputStream saveOutput = new ObjectOutputStream(saveFile);
				saveOutput.writeObject(budget);
				saveOutput.close();
				Prompter.printPrompt("budgetSaved");
				BudgetBoss.setDefaultDirectory(pathToSalvation);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}

