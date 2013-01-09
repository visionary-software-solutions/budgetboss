package com.visionarysoftwaresolutions.budgetboss.menu;

public interface MasterMenu {

	public int getNumberOfOptions();
	
	public void getOption(MasterMenu menu);
	
	public void chooseOption(int optionChose);
	
	public void setErrorMessage(String newMessage);
	
	public void displayMenu();

}
