package com.VSSBudgetBoss.main;

import com.VSSBudgetBoss.budget.*;
import com.VSSBudgetBoss.cli.*;
import com.VSSBudgetBoss.fileops.Salvation;

public class MainMenu implements MenuOption, MasterMenu{
	
	private Budget currentBudget;
	private int currentMenuChoice;

	public MainMenu(Budget currentBudget){
		this.currentBudget = currentBudget;
	}
		
	@Override
	public int getNumberOfOptions(){
		return menuOptions.length;
	}
	
	private MenuOption[] menuOptions = new MenuOption[]{
		new MenuOption(){public void chooseOption() {System.out.println(currentBudget.toString());}},
		new MenuOption(){public void chooseOption() {startEditor();}},
		new MenuOption(){public void chooseOption() {choseToSaveBudget();}},
		new MenuOption(){public void chooseOption() {choseToOpenBudget();}},
		new MenuOption(){public void chooseOption() {choseToClose();}}
	};
	
	private void startEditor(){
		BudgetEditor editor = new BudgetEditor(currentBudget);
		while(editor.stillEditingBudget())
			editor.displayEditorMainMenu();
	}
	
	public void displayMainMenu(){
		Prompter.printPrompt("mainMenu");
		System.out.println("Currently opened budget: " + currentBudget.getName());
		Prompter.printPrompt("mainMenuChoices");
		InputValidator validator = new InputValidator();
		String userInput = Listener.getInput();
		if(validator.validatesMenuChoice(userInput, this)){
			currentMenuChoice = Integer.valueOf(userInput);
			chooseOption();
		}
	}
	
	private void choseToSaveBudget(){
		Salvation savior = new Salvation();
		savior.saveBudget(currentBudget.getName(), currentBudget);
	}
	
	private void choseToOpenBudget(){
		BudgetBoss.loadSavedBudget();
	}
	
	private void choseToClose(){
		BudgetBoss.doneUsingBudgetBoss();
		BudgetBoss.endLoadSavedBudget();
		BudgetBoss.endNeedNewBudget();
	}
	
	public void chooseOption(){
		int index = (currentMenuChoice -1);
		menuOptions[index].chooseOption();
	}
}
