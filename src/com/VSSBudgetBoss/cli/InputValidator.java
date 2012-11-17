package com.VSSBudgetBoss.cli;

import java.io.File;
import org.joda.time.DateTime;
import com.VSSBudgetBoss.main.*;

public class InputValidator {
	
	public boolean inputNotAnInteger(String toCheck){
		if(itsTimeToExit(toCheck))
			return false;
		try{
			Integer.parseInt(toCheck);
		}catch(NumberFormatException e){
			Printer.printPrompt("notEvenANumberGenius");
			return true;
		}
		return false;
	}
	
	public boolean pathIsInvalid(String toCheck){
		File directory = new File(toCheck);
		if(itsTimeToExit(toCheck))
			return false;
		if(toCheck.equalsIgnoreCase("y"))
			return false;
		if(toCheck.endsWith("/")){
			if(directory.isDirectory())
				return false;
		}
		if(toCheck.contains(" ")){
			Printer.printPrompt("whitespaceGenius");
			System.out.println("The default is: " + BudgetBoss.getDefaultDirectory());
			return true;
		}
		if(!toCheck.endsWith("/")){
			Printer.printPrompt("endsInSlash");
			System.out.println("The default is: " + BudgetBoss.getDefaultDirectory());
			return true;
		}else{
			Printer.printPrompt("badPathInput");
			System.out.println("The default is: " + BudgetBoss.getDefaultDirectory());
			return true;
		}
	}

	public boolean inputNotABudget(String toCheck, int highestChoice){
		if(itsTimeToExit(toCheck))
			return false;
		if(inputNotAnInteger(toCheck))
			return true;
		if(Integer.valueOf(toCheck).equals(0)){
			Printer.printPrompt("youreAZero");
			return true;
		}
		int userChoice = Integer.valueOf(toCheck);
		if(userChoice > highestChoice){
			Printer.printPrompt("thatsNotAChoice");
			return true;
		}
		else
			return false;
	}
	
	public boolean menuChoiceIsInvalid(String toCheck, MasterMenu menu){
		if(itsTimeToExit(toCheck))
			return false;
		if(inputNotAnInteger(toCheck))
			return true;
		int userChoice = Integer.valueOf(toCheck);
		if(BudgetBoss.getCurrentBudget().equals("No budget loaded") && ((userChoice < 5))){
			Printer.printPrompt("noBudgetLoaded");
			return true;
		}		
		if(Integer.valueOf(toCheck).equals(0)){
			Printer.printPrompt("youreAZero");
			return true;
		}
		if(userChoice > menu.getNumberOfOptions()){
			Printer.printPrompt("thatsNotAChoice");
			return true;
		}
		else
			return false;
	}
	
	public boolean dateIsInvalid(String toCheck){
		if(itsTimeToExit(toCheck))
			return false;
		if(!toCheck.contains("/")){
			Printer.printPrompt("wrongDateFormat");
			return true;
		}
		if(toCheck.contains(" ")){
			Printer.printPrompt("wrongDateFormat");
			return true;
		}
		String delimiter = "/";
		String[] date = toCheck.split(delimiter);
		if(!(date.length == 3)){
			Printer.printPrompt("wrongDateFormat");
			return true;
		}
		for(int i = 0; i < 3; i++){
			try{
				Integer.parseInt(date[i]);
			}catch(NumberFormatException e){
				Printer.printPrompt("lessLettersPorFavor");
				return true;
			}
		}
		int month = Integer.valueOf(date[0].toString());
		int day = Integer.valueOf(date[1].toString());
		int year = Integer.valueOf(date[2].toString());
		if((month < 1) || (month > 12)){
			Printer.printPrompt("notAMonth");
			return true;
		}
		if((month == 4) || (month == 6) || (month == 9) || (month == 11)){
			if((day < 1) || (day > 30)){
				Printer.printPrompt("notADay");
				return true;
			}
		}else if(month == 2){
			if((day == 29)){
				Printer.printPrompt("dontBeASmartass");
				return true;
			}
			if((day < 1) || (day > 28)){
				Printer.printPrompt("notADay");
				return true;
			}
		}else{
			if((day < 1) || (day > 31)){
				Printer.printPrompt("notADay");
				return true;
			}
		}
		DateTime timeNow = new DateTime();
		int currentYear = timeNow.getYear();
		if(year < currentYear){
			Printer.printPrompt("backToTheFuture");
			return true;
		}else
			return false;
	}
	
	private boolean itsTimeToExit(String toCheck){
		if(toCheck.equalsIgnoreCase("exit")){
			BudgetBoss.endLoadSavedBudget();
			BudgetBoss.endNeedNewBudget();
			BudgetBoss.doneUsingBudgetBoss();
			return true;
		}else
			return false;
	}
}