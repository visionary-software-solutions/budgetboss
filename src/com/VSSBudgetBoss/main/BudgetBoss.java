package com.VSSBudgetBoss.main;

import com.VSSBudgetBoss.budget.Budget;
import com.VSSBudgetBoss.cli.*;
import com.VSSBudgetBoss.fileops.*;

public class BudgetBoss {
	
	static PrompterLogic logicChecker = new PrompterLogic();
	static Opener opener = new Opener();
	static Budget currentBudget = null;
	static String defaultDirectory;	
	
	public static void setDefaultDirectory(String newDefaultDirectory){
		defaultDirectory = newDefaultDirectory;
	}
		
	public static void main(String args[]){
		Salvation savior = new Salvation();
		String currentUser = System.getProperty("user.name");
		defaultDirectory = "/home/" + currentUser + "/Documents/";
		
		Prompts.welcomeToBudgetBoss();
		
		while(opener.promptNeedsToClear())
				opener.askToOpenBudget(defaultDirectory);
		
		while(!logicChecker.getBudgetExistsStatus()){
			currentBudget = logicChecker.askToCreateBudget();
		
		try{	
			savior.askToSaveBudget(currentBudget.getName(), currentBudget, defaultDirectory);
		}catch (NullPointerException e){
			Prompts.noBudgetToSave();
			}
		}
	}
}

