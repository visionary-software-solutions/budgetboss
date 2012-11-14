package com.VSSBudgetBoss.fileops;

import java.io.*;
import java.util.*;

import com.VSSBudgetBoss.cli.Prompter;
import com.VSSBudgetBoss.main.BudgetBoss;

public class Finder {
	
	public static File[] findBudgets(String directoryToSearch){
		File foundBudget = new File(directoryToSearch);
			return foundBudget.listFiles(new FilenameFilter(){
				public boolean accept(File foundBudget, String filename){
					return filename.endsWith(".bgt");
				}
			});
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

