package com.VSSBudgetBoss.budget;

import com.VSSBudgetBoss.cli.*;
import com.VSSBudgetBoss.fileops.Salvation;
import com.VSSBudgetBoss.main.*;

public class BudgetEditor implements MenuOption, MasterMenu{
	
	private Budget toEdit;
	private int currentMenuChoice;
	private boolean stillEditing = true;
	private InputValidator validator = new InputValidator();

	public BudgetEditor(Budget toEdit){
		this.toEdit = toEdit;
	}
	
	public boolean stillEditingBudget(){
		return stillEditing;
	}
	
	@Override
	public int getNumberOfOptions() {
		return menuOptions.length;
	}
	
	private MenuOption[] menuOptions = new MenuOption[] {
		new MenuOption() {public void chooseOption() {System.out.println(toEdit.toString());}},
		new MenuOption() {public void chooseOption() {choseToSaveText();}},
		new MenuOption() {public void chooseOption() {getNewName();}},
		new MenuOption() {public void chooseOption() {getNewStartDate();}},
		new MenuOption() {public void chooseOption() {getNewEndDate();}},
		new MenuOption() {public void chooseOption() {stillEditing = false;}}
	};
	
	private void choseToSaveText(){
		Salvation savior = new Salvation();
		savior.writeBudgetToText(toEdit.getName(), toEdit);
	}
	
	private void getNewName(){
		Prompter.printPrompt("getNewName");
		String userInput = Listener.getInput();
		if(!(userInput.equals("exit")))
			toEdit.setName(userInput);
		else{
			stillEditing = false;
			BudgetBoss.endLoadSavedBudget();
			BudgetBoss.endNeedNewBudget();
			BudgetBoss.doneUsingBudgetBoss();
		}
	}
	
	private void getNewStartDate(){
		Prompter.printPrompt("getNewStartDate");
		String userInput = Listener.getInput();
		while(validator.dateIsInvalid(userInput))
			userInput = Listener.getInput();
		if(!(userInput.equals("exit")))
			toEdit.setStartDate(userInput);
	}
	
	private void getNewEndDate(){
		Prompter.printPrompt("getNewEndDate");
		String userInput = Listener.getInput();
		while(validator.dateIsInvalid(userInput))
			userInput = Listener.getInput();
		if(!(userInput.equals("exit")))
			toEdit.setEndDate(userInput);
	}
	
	public void displayEditorMainMenu(){
		Prompter.printPrompt("editorMainMenu");
		System.out.println("Working with budget: " + toEdit.getName());
		Prompter.printPrompt("editorMainMenuChoices");
		InputValidator validator = new InputValidator();
		String userInput = Listener.getInput();
		while(validator.menuChoiceIsInvalid(userInput, this))
			userInput = Listener.getInput();
		if(!(userInput.equals("exit"))){
			currentMenuChoice = Integer.valueOf(userInput);
			chooseOption();
		}
	}
	
	public void chooseOption(){
		int index = (currentMenuChoice -1);
		menuOptions[index].chooseOption();
	}
}
