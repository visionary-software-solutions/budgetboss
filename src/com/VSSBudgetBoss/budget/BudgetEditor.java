package com.VSSBudgetBoss.budget;

import com.VSSBudgetBoss.cli.*;
import com.VSSBudgetBoss.main.*;

public class BudgetEditor implements MenuOption{
	
	private Budget toEdit;
	private String userInput;
	private int currentMenuChoice;
	private boolean stillEditing = true;

	public BudgetEditor(Budget toEdit){
		this.toEdit = toEdit;
	}
	
	public boolean stillEditingBudget(){
		return stillEditing;
	}
	
	private MenuOption[] menuOptions = new MenuOption[] {
		new MenuOption() {public void chooseOption() {System.out.println(toEdit.toString());}},
		new MenuOption() {public void chooseOption() {getNewName();}},
		new MenuOption() {public void chooseOption() {getNewStartDate();}},
		new MenuOption() {public void chooseOption() {getNewEndDate();}},
		new MenuOption() {public void chooseOption() {stillEditing = false;}}
	};
	
	private void getInput(){
		InputListener listener = new InputListener();
		userInput = listener.listenForInput();
	}
	
	private void getNewName(){
		Prompter.printPrompt("getNewName");
		getInput();
		toEdit.setName(userInput);
	}
	
	private void getNewStartDate(){
		Prompter.printPrompt("getNewStartDate");
		getInput();
		toEdit.setStartDate(userInput);
	}
	
	private void getNewEndDate(){
		Prompter.printPrompt("getNewEndDate");
		getInput();
		toEdit.setEndDate(userInput);
	}
	
	public void displayEditorMainMenu(){
		Prompter.printPrompt("editorMainMenu");
		InputListener listener = new InputListener();
		InputValidator validator = new InputValidator();
		String userInput = listener.listenForInput();
		if(validator.validatesMainEditorChoice(userInput)){
			currentMenuChoice = Integer.valueOf(userInput);
			chooseOption();
		}

	}
	
	public void chooseOption(){
		int index = (currentMenuChoice -1);
		menuOptions[index].chooseOption();
	}
}
