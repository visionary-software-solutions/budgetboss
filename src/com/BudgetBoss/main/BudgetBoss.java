package com.BudgetBoss.main;

public class BudgetBoss {
	
	static Prompter prompter = new Prompter();
	static PrompterLogic logicChecker = new PrompterLogic();
	static Budget currentBudget = null;
		
	public static void main(String args[]){
		String defaultDirectory = "/home/visionary/Programming/BudgetBoss/SavedBudgets/";
		
		System.out.println("Welcome to BudgetBoss!");
		System.out.println("Manage your money...like a boss.");
		System.out.println("Is there an existing Budget you want to open? (y/n)");
		
		while(!logicChecker.getPromptClearedStatus())
				logicChecker.askToOpenBudget(defaultDirectory);
		
		while(!logicChecker.getBudgetExistsStatus()){
			currentBudget = logicChecker.askToCreateBudget();
		
		Salvation savior = new Salvation();
		try{	
			savior.saveOnExit(currentBudget.getName(), currentBudget);
		}catch (NullPointerException e){
			System.out.println("No Budget to save!");
			}
		}
	}
}

