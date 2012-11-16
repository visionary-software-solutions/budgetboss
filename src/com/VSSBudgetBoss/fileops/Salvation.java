package com.VSSBudgetBoss.fileops;

import java.io.*;

import com.VSSBudgetBoss.budget.Budget;
import com.VSSBudgetBoss.cli.*;
import com.VSSBudgetBoss.main.BudgetBoss;

public class Salvation {
	
	InputValidator validator = new InputValidator();
	
	private String getSaveDirectory(){
		Prompter.printPrompt("getSaveDirectoryPath");
		System.out.println("The default is: " + BudgetBoss.getDefaultDirectory());
		String toCheck = Listener.getInput();
		while(validator.pathIsInvalid(toCheck))
			toCheck = Listener.getInput();
		if(!(toCheck.equalsIgnoreCase("exit"))){
			if(toCheck.equalsIgnoreCase("y"))
				return BudgetBoss.getDefaultDirectory();
			else
				return toCheck;
		}else
			return toCheck;
	}

	public void writeBudgetToDisk(String fileName, Budget budget){
		String pathToSalvation = getSaveDirectory();
		if(!(pathToSalvation.equalsIgnoreCase("exit"))){
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
	
	public void writeBudgetToText(String fileName, Budget budget){
		String pathToSalvation = getSaveDirectory();
		if(!(pathToSalvation.equalsIgnoreCase("exit"))){
			try {
				PrintStream budgetToText =  new PrintStream(new FileOutputStream(pathToSalvation + fileName + ".txt"));
				budgetToText.println(budget.toString());
				budgetToText.close();
				Prompter.printPrompt("budgetSaved");
				BudgetBoss.setDefaultDirectory(pathToSalvation);
			} catch (FileNotFoundException e) {
				System.out.println("Rethink this son");
				e.printStackTrace();
			}
		}
	}
}

