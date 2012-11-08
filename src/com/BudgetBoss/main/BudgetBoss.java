package com.BudgetBoss.main;

public class BudgetBoss {
	
	static PrompterLogic logicChecker = new PrompterLogic();
	static Budget currentBudget = null;
		
	public static void main(String args[]){
		String currentUser = System.getProperty("user.name");
		String defaultDirectory = "/home/" + currentUser + "/Documents/";
		
		Prompts.welcomeToBudgetBoss();
		
		while(!logicChecker.getPromptClearedStatus())
				logicChecker.askToOpenBudget(defaultDirectory);
		
		while(!logicChecker.getBudgetExistsStatus()){
			currentBudget = logicChecker.askToCreateBudget();
		
		Salvation savior = new Salvation();
		Prompts.pathToSalvationCheck(defaultDirectory);
		try{	
			savior.saveOnExit(currentBudget.getName(), currentBudget, defaultDirectory);
		}catch (NullPointerException e){
			Prompts.noBudgetToSave();
			}
		}
	}
}

