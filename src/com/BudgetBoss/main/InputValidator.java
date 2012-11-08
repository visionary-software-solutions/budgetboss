package com.BudgetBoss.main;

import java.io.File;

public class InputValidator {
		
	public String inputIsEitherYOrN(String toCheck){
		if(toCheck.equals("y") || toCheck.equals("Y"))
			return toCheck.toLowerCase();
		else if(toCheck.equals("n") || toCheck.equals("N"))
			return toCheck.toLowerCase();
		else
			return "invalidEntry";
	}
	
	public boolean validateUserPath(String toCheck){
		File directory = new File(toCheck);
		if(directory.isDirectory())
			return true;
		else
			return false;
	}
	
	public String defaultDirectoryCheck(String toCheck, String defaultDirectory){
		if(toCheck.equals("y") || toCheck.equals("Y"))
			return defaultDirectory;
		else if(validateUserPath(toCheck))
			return toCheck;
		else
			Prompts.badPathInput(defaultDirectory);
			return "ERROR";
	}
}
