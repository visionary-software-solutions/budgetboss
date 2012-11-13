package com.VSSBudgetBoss.budget;

import java.io.Serializable;
import org.joda.time.*;

public class Budget implements Serializable{
	
	private static final long serialVersionUID = -8611741910364436624L;
	
	String name;
	LocalDate startDate;
	LocalDate endDate;
	
	public Budget(String name){
		setName(name);
		startDate = new LocalDate(2012, 1, 1);
		endDate = new LocalDate(2012, 12, 31);
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getStartDate() {
		String startDateOutput = DateConverter.formateDate(startDate);
		return startDateOutput;
	}
	
	public void setStartDate(String newDate) {
		String convertedDate = DateConverter.convertDate(newDate);
		this.startDate = new LocalDate(convertedDate);		
	}

	public String getEndDate() {
		String endDateOutput = DateConverter.formateDate(endDate);
		return endDateOutput;
	}

	public void setEndDate(String newDate) {
		String convertedDate = DateConverter.convertDate(newDate);
		this.endDate = new LocalDate(convertedDate);
	}
	
	
	public String toString(){
		return ("\nBudget name: " + getName() + "\nBudget start: " + getStartDate() + 
				"\nBudget End: " + getEndDate() + "\n");
	}

}
