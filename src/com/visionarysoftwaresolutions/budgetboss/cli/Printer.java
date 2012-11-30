package com.visionarysoftwaresolutions.budgetboss.cli;

import java.io.File;
import java.util.*;
import com.visionarysoftwaresolutions.budgetboss.menu.MasterOption;

public class Printer {
	
	private Printer(){}

	private static ResourceBundle cliOutput = ResourceBundle.getBundle("cliOutput");
	
	public static String getPrintout(String toGet){
		return cliOutput.getString(toGet);
	}

	public static void print(String toGet){
		System.out.println(cliOutput.getString(toGet));
	}
	
	public static void printMenuOptions(MasterOption[] menuOptions){
		for(int i = 0; i < menuOptions.length; i++){
			int optionNumber = (i + 1);
			System.out.println(optionNumber + ") " + menuOptions[i].printOption());
		}
	}
	
	public static void printFoundBudgets(File[] foundBudgets){
		List<String> budgetNames = new ArrayList<String>();
		for(int i = 0; i < foundBudgets.length; i++)
			budgetNames.add(foundBudgets[i].getName());
		for(int i = 0; i < budgetNames.size(); i++){
			String budgetName = budgetNames.get(i);
			System.out.println((i+1) + ") " + budgetName);
		}
	}
}