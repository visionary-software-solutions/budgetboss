package com.VSSBudgetBoss.cli;

import java.io.File;

import org.joda.time.DateTime;

import com.VSSBudgetBoss.main.*;

public class InputValidator {
		
	public boolean inputIsNotYOrN(String toCheck){
		if(toCheck.equalsIgnoreCase("y"))
			return false;
		else if(toCheck.equalsIgnoreCase("n"))
			return false;
		else{
			Prompter.printPrompt("invalidEntryYN");
			return true;
		}
	}
	
	public boolean inputNotAnInteger(String toCheck){
		try{
			Integer.parseInt(toCheck);
		}catch(NumberFormatException e){
			Prompter.printPrompt("notEvenANumberGenius");
			return true;
		}
		return false;
	}
	
	public boolean pathIsInvalid(String toCheck){
		File directory = new File(toCheck);
		if(toCheck.equalsIgnoreCase("y"))
			return false;
		if(toCheck.endsWith("/")){
			if(directory.isDirectory())
				return false;
		}
		if(toCheck.contains(" ")){
			Prompter.printPrompt("whitespaceGenius");
			System.out.println("The default is: " + BudgetBoss.getDefaultDirectory());
			return true;
		}
		if(!toCheck.endsWith("/")){
			Prompter.printPrompt("endsInSlash");
			System.out.println("The default is: " + BudgetBoss.getDefaultDirectory());
			return true;
		}else{
			Prompter.printPrompt("badPathInput");
			System.out.println("The default is: " + BudgetBoss.getDefaultDirectory());
			return true;
		}
	}

	public boolean inputNotABudget(String toCheck, int highestChoice){
		if(inputNotAnInteger(toCheck))
			return true;
		if(Integer.valueOf(toCheck).equals(0)){
			Prompter.printPrompt("youreAZero");
			return true;
		}
		int userChoice = Integer.valueOf(toCheck);
		if(userChoice > highestChoice){
			Prompter.printPrompt("thatsNotAChoice");
			return true;
		}
		else
			return false;
	}
	
	public boolean menuChoiceIsInvalid(String toCheck, MasterMenu menu){
		if(inputNotAnInteger(toCheck))
			return true;
		int userChoice = Integer.valueOf(toCheck);
		if(BudgetBoss.getCurrentBudget().equals("No budget loaded") && ((userChoice < 4))){
			Prompter.printPrompt("noBudgetLoaded");
			return true;
		}		
		if(Integer.valueOf(toCheck).equals(0)){
			Prompter.printPrompt("youreAZero");
			return true;
		}
		if(userChoice > menu.getNumberOfOptions()){
			Prompter.printPrompt("thatsNotAChoice");
			return true;
		}
		else
			return false;
	}
	
	public boolean dateIsInvalid(String toCheck){
		if(!toCheck.contains("/")){
			Prompter.printPrompt("wrongDateFormat");
			return true;
		}
		if(toCheck.contains(" ")){
			Prompter.printPrompt("wrongDateFormat");
			return true;
		}
		String delimiter = "/";
		String[] date = toCheck.split(delimiter);
		if(!(date.length == 3)){
			Prompter.printPrompt("wrongDateFormat");
			return true;
		}
		for(int i = 0; i < 3; i++){
			try{
				Integer.parseInt(date[i]);
			}catch(NumberFormatException e){
				Prompter.printPrompt("lessLettersPorFavor");
				return true;
			}
		}
		int month = Integer.valueOf(date[0].toString());
		int day = Integer.valueOf(date[1].toString());
		int year = Integer.valueOf(date[2].toString());
		if((month < 1) || (month > 12)){
			Prompter.printPrompt("notAMonth");
			return true;
		}
		if((month == 4) || (month == 6) || (month == 9) || (month == 11)){
			if((day < 1) || (day > 30)){
				Prompter.printPrompt("notADay");
				return true;
			}
		}else if(month == 2){
			if((day == 29)){
				Prompter.printPrompt("dontBeASmartass");
				return true;
			}
			if((day < 1) || (day > 28)){
				Prompter.printPrompt("notADay");
				return true;
			}
		}else{
			if((day < 1) || (day > 31)){
				Prompter.printPrompt("notADay");
				return true;
			}
		}
		DateTime timeNow = new DateTime();
		int currentYear = timeNow.getYear();
		if(year < currentYear){
			Prompter.printPrompt("backToTheFuture");
			return true;
		}else
			return false;
	}
}