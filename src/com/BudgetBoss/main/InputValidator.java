package com.BudgetBoss.main;

public class InputValidator {
		
	public String inputIsEitherYOrN(String toCheck){
		if(toCheck.equals("y") || toCheck.equals("Y"))
			return toCheck.toLowerCase();
		else if(toCheck.equals("n") || toCheck.equals("N"))
			return toCheck.toLowerCase();
		else
			return "invalidEntry";
	}
}
