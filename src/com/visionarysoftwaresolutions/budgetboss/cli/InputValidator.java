package com.visionarysoftwaresolutions.budgetboss.cli;

import static org.fusesource.jansi.Ansi.ansi;

import java.io.File;

import org.fusesource.jansi.AnsiConsole;
import org.joda.time.DateTime;

import com.visionarysoftwaresolutions.budgetboss.app.BudgetBoss;
import com.visionarysoftwaresolutions.budgetboss.menu.*;

public class InputValidator {
	
	public boolean inputNotAnInteger(String toCheck){
		if(itsTimeToExit(toCheck))
			return false;
		try{
			Integer.parseInt(toCheck);
		}catch(NumberFormatException e){
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
			AnsiConsole.out.println(ansi().eraseScreen());
			Printer.print("whitespaceGenius");
			System.out.println("The default is: " + BudgetBoss.getDefaultDirectory());
			return true;
		}
		if(!toCheck.endsWith("/")){
			AnsiConsole.out.println(ansi().eraseScreen());
			Printer.print("endsInSlash");
			System.out.println("The default is: " + BudgetBoss.getDefaultDirectory());
			return true;
		}else{
			AnsiConsole.out.println(ansi().eraseScreen());
			Printer.print("badPathInput");
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
			Printer.print("youreAZero");
			return true;
		}
		int userChoice = Integer.valueOf(toCheck);
		if(userChoice > highestChoice){
			Printer.print("thatsNotAChoice");
			return true;
		}
		else
			return false;
	}
	
	public boolean menuChoiceIsInvalid(String toCheck, MasterMenu menu){
		if(itsTimeToExit(toCheck))
			return false;
		if(inputNotAnInteger(toCheck)){
			menu.setErrorMessage(Printer.getPrintout("notEvenANumberGenius"));
			return true;
		}
		int userChoice = Integer.valueOf(toCheck);
		if(Integer.valueOf(toCheck).equals(0)){
			menu.setErrorMessage(Printer.getPrintout("youreAZero"));
			return true;
		}
		if(userChoice > menu.getNumberOfOptions()){
			menu.setErrorMessage(Printer.getPrintout("thatsNotAChoice"));
			return true;
		}
		else
			return false;
	}
	
	public boolean dateIsInvalid(String toCheck){
		if(itsTimeToExit(toCheck))
			return false;
		if(!toCheck.contains("/")){
			Printer.print("wrongDateFormat");
			return true;
		}
		if(toCheck.contains(" ")){
			Printer.print("wrongDateFormat");
			return true;
		}
		String delimiter = "/";
		String[] date = toCheck.split(delimiter);
		if(!(date.length == 3)){
			Printer.print("wrongDateFormat");
			return true;
		}
		for(int i = 0; i < 3; i++){
			try{
				Integer.parseInt(date[i]);
			}catch(NumberFormatException e){
				Printer.print("lessLettersPorFavor");
				return true;
			}
		}
		int month = Integer.valueOf(date[0].toString());
		int day = Integer.valueOf(date[1].toString());
		int year = Integer.valueOf(date[2].toString());
		if((month < 1) || (month > 12)){
			Printer.print("notAMonth");
			return true;
		}
		if((month == 4) || (month == 6) || (month == 9) || (month == 11)){
			if((day < 1) || (day > 30)){
				Printer.print("notADay");
				return true;
			}
		}else if(month == 2){
			if((day == 29)){
				Printer.print("dontBeASmartass");
				return true;
			}
			if((day < 1) || (day > 28)){
				Printer.print("notADay");
				return true;
			}
		}else{
			if((day < 1) || (day > 31)){
				Printer.print("notADay");
				return true;
			}
		}
		DateTime timeNow = new DateTime();
		int currentYear = timeNow.getYear();
		if(year < currentYear){
			Printer.print("backToTheFuture");
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