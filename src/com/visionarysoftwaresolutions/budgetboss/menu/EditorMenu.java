package com.visionarysoftwaresolutions.budgetboss.menu;

import static org.fusesource.jansi.Ansi.ansi;

import org.fusesource.jansi.AnsiConsole;
import com.visionarysoftwaresolutions.budgetboss.app.BudgetBoss;
import com.visionarysoftwaresolutions.budgetboss.budget.Budget;
import com.visionarysoftwaresolutions.budgetboss.cli.*;
import com.visionarysoftwaresolutions.budgetboss.fileops.Salvation;

public class EditorMenu implements MasterMenu{
	
	private Budget toEdit;
	private boolean stillEditing = true;
	private String errorMessage = "";

	public EditorMenu(Budget toEdit){
		this.toEdit = toEdit;
	}
	
	public void setErrorMessage(String newMessage){
		errorMessage = newMessage;
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
		Printer.print("editorMenuHeader");
		System.out.println("Working with budget: " + toEdit.getName() + "\n");
		Printer.printMenuOptions(menuOptions);
	}
	
	public void getOption(MasterMenu menu){
		displayMenu();
		System.out.println(errorMessage);
		InputValidator validator = new InputValidator();
		String userInput = Listener.getInput();
		while(validator.menuChoiceIsInvalid(userInput, this)){
			displayMenu();
			System.out.println(errorMessage);
			userInput = Listener.getInput();
		}
		if(!(userInput.equals("exit"))){
			int optionChose = Integer.valueOf(userInput);
			chooseOption(optionChose);
		}else
			stillEditing = false;
	}
	
	private void choseToSaveText(){
		Salvation savior = new Salvation();
		savior.writeBudgetToText(toEdit.getName(), toEdit);
	}
	
	private void getNewName(){
		Printer.print("getNewName");
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
		Printer.print("getNewStartDate");
		String userInput = Listener.getInput();
		InputValidator validator = new InputValidator();
		while(validator.dateIsInvalid(userInput))
			userInput = Listener.getInput();
		if(!(userInput.equals("exit")))
			toEdit.setStartDate(userInput);
	}
	
	private void getNewEndDate(){
		Printer.print("getNewEndDate");
		String userInput = Listener.getInput();
		InputValidator validator = new InputValidator();
		while(validator.dateIsInvalid(userInput))
			userInput = Listener.getInput();
		if(!(userInput.equals("exit")))
			toEdit.setEndDate(userInput);
	}
		
	public void chooseOption(int optionChose){
		int index = (optionChose - 1);
		menuOptions[index].optionMethod();
	}
}