package com.VSSBudgetBoss.budget;

import static org.fusesource.jansi.Ansi.ansi;

import org.fusesource.jansi.AnsiConsole;

import com.VSSBudgetBoss.cli.*;
import com.VSSBudgetBoss.fileops.Salvation;
import com.VSSBudgetBoss.main.*;

public class EditorMenu implements MasterMenu{
	
	private Budget toEdit;
	private int currentMenuChoice;
	private boolean stillEditing = true;
	private InputValidator validator = new InputValidator();

	public EditorMenu(Budget toEdit){
		this.toEdit = toEdit;
	}
	
	public boolean stillEditingBudget(){
		return stillEditing;
	}
	
	public int getNumberOfOptions() {
		return menuOptions.length;
	}
	
	private MasterOption[] menuOptions = new MasterOption[] {
		new MasterOption() {String optionPrintout = Printer.getPrintout("toConsoleOption");
			public void optionMethod() {System.out.println(toEdit.toString());}
			public String printOption(){return optionPrintout;}},
		new MasterOption() {String optionPrintout = Printer.getPrintout("toTextOption");
			public void optionMethod() {choseToSaveText();}
			public String printOption(){return optionPrintout;}},
		new MasterOption() {String optionPrintout = Printer.getPrintout("newNameOption");
			public void optionMethod() {getNewName();}
			public String printOption(){return optionPrintout;}},
		new MasterOption() {String optionPrintout = Printer.getPrintout("newStartOption");
			public void optionMethod() {getNewStartDate();}
			public String printOption(){return optionPrintout;}},
		new MasterOption() {String optionPrintout = Printer.getPrintout("newEndOption");
			public void optionMethod() {getNewEndDate();}
			public String printOption(){return optionPrintout;}},
		new MasterOption() {String optionPrintout = Printer.getPrintout("toMainOption");
			public void optionMethod() {stillEditing = false;}
			public String printOption(){return optionPrintout;}}
	};

	public void displayMenu(){
		AnsiConsole.out.println(ansi().eraseScreen());
		Printer.printPrompt("editorMenuHeader");
		System.out.println("Working with budget: " + toEdit.getName() + "\n");
		Printer.printMenuOptions(menuOptions);
		InputValidator validator = new InputValidator();
		String userInput = Listener.getInput();
		while(validator.menuChoiceIsInvalid(userInput, this))
			userInput = Listener.getInput();
		if(!(userInput.equals("exit"))){
			currentMenuChoice = Integer.valueOf(userInput);
			chooseOption();
		}else
			stillEditing = false;
	}
	
	private void choseToSaveText(){
		Salvation savior = new Salvation();
		savior.writeBudgetToText(toEdit.getName(), toEdit);
	}
	
	private void getNewName(){
		Printer.printPrompt("getNewName");
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
		Printer.printPrompt("getNewStartDate");
		String userInput = Listener.getInput();
		while(validator.dateIsInvalid(userInput))
			userInput = Listener.getInput();
		if(!(userInput.equals("exit")))
			toEdit.setStartDate(userInput);
	}
	
	private void getNewEndDate(){
		Printer.printPrompt("getNewEndDate");
		String userInput = Listener.getInput();
		while(validator.dateIsInvalid(userInput))
			userInput = Listener.getInput();
		if(!(userInput.equals("exit")))
			toEdit.setEndDate(userInput);
	}
		
	public void chooseOption(){
		int index = (currentMenuChoice -1);
		menuOptions[index].optionMethod();
	}
}
