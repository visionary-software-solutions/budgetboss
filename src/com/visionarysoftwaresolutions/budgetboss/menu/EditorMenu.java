package com.visionarysoftwaresolutions.budgetboss.menu;

import static org.fusesource.jansi.Ansi.ansi;
import org.fusesource.jansi.AnsiConsole;
import com.visionarysoftwaresolutions.budgetboss.app.BudgetBoss;
import com.visionarysoftwaresolutions.budgetboss.budget.Budget;
import com.visionarysoftwaresolutions.budgetboss.cli.*;
import com.visionarysoftwaresolutions.budgetboss.fileops.Savior;

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
		new MasterOption() {String optionPrintout = Printer.getPrintout("reportToConsoleOption");
			public void optionMethod() {System.out.println(toEdit.toString());}
			public String printOption(){return optionPrintout;}},
		new MasterOption() {String optionPrintout = Printer.getPrintout("reportToDiskOption");
			public void optionMethod() {reportToDisk();}
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
		System.out.println("Budget in use: " + toEdit.getName() + "\n");
		Printer.printMenuOptions(menuOptions);
	}
	
	public void getOption(MasterMenu menu){
		displayMenu();
		System.out.println(errorMessage);
		String userInput = TakeInput.getInput();
		while(InputValidator.menuChoiceIsInvalid(userInput, this)){
			displayMenu();
			System.out.println(errorMessage);
			userInput = TakeInput.getInput();
		}
		if(!(userInput.equalsIgnoreCase("exit"))){
			int optionChose = Integer.valueOf(userInput);
			chooseOption(optionChose);
		}else
			stillEditing = false;
	}
	
	private void reportToDisk(){
		Savior.generateBudgetReport(toEdit.getName(), toEdit);
	}
	
	private void getNewName(){
		Printer.print("getNewName");
		String userInput = TakeInput.getInput();
		if(!(userInput.equalsIgnoreCase("exit")))
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
		String userInput = TakeInput.getInput();
		while(InputValidator.dateIsInvalid(userInput))
			userInput = TakeInput.getInput();
		if(!(userInput.equalsIgnoreCase("exit")))
			toEdit.setStartDate(userInput);
	}
	
	private void getNewEndDate(){
		Printer.print("getNewEndDate");
		String userInput = TakeInput.getInput();
		while(InputValidator.dateIsInvalid(userInput))
			userInput = TakeInput.getInput();
		if(!(userInput.equalsIgnoreCase("exit")))
			toEdit.setEndDate(userInput);
	}
		
	public void chooseOption(int optionChose){
		int index = (optionChose - 1);
		menuOptions[index].optionMethod();
	}
}