package com.VSSBudgetBoss.main;

import com.VSSBudgetBoss.budget.*;
import com.VSSBudgetBoss.cli.*;
import com.VSSBudgetBoss.fileops.Salvation;

public class MainMenu implements MenuOption{
	
	private Budget currentBudget;
	private boolean usingBudgetBoss = true;
	private int currentMenuChoice;

	public MainMenu(Budget currentBudget){
		this.currentBudget = currentBudget;
	}
		
	public boolean stillUsingBudgetBoss(){
		return usingBudgetBoss;
	}
	
	private MenuOption[] menuOptions = new MenuOption[]{
		new MenuOption(){public void chooseOption() {System.out.println(currentBudget.toString());}},
		new MenuOption(){public void chooseOption() {startEditor();}},
		new MenuOption(){public void chooseOption() {choseToSaveBudget();}},
		new MenuOption(){public void chooseOption() {usingBudgetBoss = false;}}
	};
	
	private void startEditor(){
		BudgetEditor editor = new BudgetEditor(currentBudget);
		while(editor.stillEditingBudget())
			editor.displayEditorMainMenu();
	}
	
	public void displayMainMenu(){
		Prompter.printPrompt("mainMenu");
		InputValidator validator = new InputValidator();
		String userInput = Listener.getInput();
		if(validator.validatesMainMenuChoice(userInput)){
			currentMenuChoice = Integer.valueOf(userInput);
			chooseOption();
		}
	}
	
	private void choseToSaveBudget(){
		Salvation savior = new Salvation();
		savior.saveBudget(currentBudget.getName(), currentBudget);
	}
	
	public void chooseOption(){
		int index = (currentMenuChoice -1);
		menuOptions[index].chooseOption();
	}
}
