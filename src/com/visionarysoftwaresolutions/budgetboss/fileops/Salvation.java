package com.visionarysoftwaresolutions.budgetboss.fileops;

import java.io.*;

import com.visionarysoftwaresolutions.budgetboss.app.BudgetBoss;
import com.visionarysoftwaresolutions.budgetboss.budget.Budget;
import com.visionarysoftwaresolutions.budgetboss.cli.*;

public class Salvation {
	
	InputValidator validator = new InputValidator();
	
	private String getSaveDirectory(){
		Printer.print("getSaveDirectoryPath");
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
				Printer.print("budgetSaved");
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
				Printer.print("budgetSaved");
				BudgetBoss.setDefaultDirectory(pathToSalvation);
			} catch (FileNotFoundException e) {
				System.out.println("Rethink this son");
				e.printStackTrace();
			}
		}
	}
}

