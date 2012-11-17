package com.VSSBudgetBoss.cli;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Printer {
	
	public static ResourceBundle cliOutput = ResourceBundle.getBundle("cliOutput");

	public static void printPrompt(String toGet){
		System.out.println(cliOutput.getString(toGet));
	}
	
	public static void printFoundBudgets(File[] foundBudgets){
		List<String> budgetPaths= new ArrayList<String>();
		String delimiter = "[/]";
		for(int i = 0; i < foundBudgets.length; i++)
			budgetPaths.add(foundBudgets[i].toString());
		for(int i = 0; i < budgetPaths.size(); i++){
			String pathName = budgetPaths.get(i);
			String[] splitPathName = pathName.split(delimiter);
			String fileName = splitPathName[splitPathName.length - 1];
			System.out.println((i+1) + ") " + fileName);
		}
	}
}
