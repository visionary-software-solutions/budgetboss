package com.VSSBudgetBoss.main;

import com.VSSBudgetBoss.budget.*;
import com.VSSBudgetBoss.fileops.Salvation;

public class MainMenu implements MainMenuOption{
	
	private Budget currentBudget;
	private boolean usingBudgetBoss = true;
	private int currentMenuChoice;

	public MainMenu(Budget currentBudget){
		this.currentBudget = currentBudget;
	}
		
	public boolean stillUsingBudgetBoss(){
		return usingBudgetBoss;
	}
	
	private MainMenuOption[] menuOptions = new MainMenuOption[]{
			new MainMenuOption(){public void chooseOption() {System.out.println(currentBudget.toString());}},
			new MainMenuOption(){public void chooseOption() {startEditor();}},
			new MainMenuOption(){public void chooseOption() {choseToSaveBudget();}},
			new MainMenuOption(){public void chooseOption() {usingBudgetBoss = false;}}
	};

	public void displayMenu() {
		BudgetBoss.printPrompt("mainMenu");
	}
	
	private void startEditor(){
		BudgetEditor editor = new BudgetEditor(currentBudget);
		while(editor.stillEditingBudget())
			editor.displayEditorMainMenu();
	}
	
	public void menuSelection(String toSelect){
		currentMenuChoice = Integer.valueOf(toSelect);
		chooseOption();
	}
	
	private void choseToSaveBudget(){
		Salvation savior = new Salvation();
		savior.saveBudget(currentBudget.getName(), currentBudget, BudgetBoss.getDefaultDirectory());
	}
	
	public void chooseOption(){
		int index = (currentMenuChoice -1);
		menuOptions[index].chooseOption();
	}
}
