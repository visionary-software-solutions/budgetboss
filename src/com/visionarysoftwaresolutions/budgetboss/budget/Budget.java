package com.visionarysoftwaresolutions.budgetboss.budget;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;
import org.joda.time.*;

import com.visionarysoftwaresolutions.budgetboss.budginator.*;
import com.visionarysoftwaresolutions.budgetboss.cli.DateConverter;
import com.visionarysoftwaresolutions.budgetboss.cli.Printer;

public class Budget implements MasterBudget, Serializable{
	
	private static final long serialVersionUID = -8611741910364436624L;
	
	private Collection<LineItem> items;
	private BigDecimal totalCost;
	private ArrayList<ExpenseCategory> expenseCategories;
	private ArrayList<IncomeCategory> incomeCategories;
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	
	public Budget(String name){
		setName(name);
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getStartDate() {
		if(!(startDate == null)){
			String startDateOutput = DateConverter.formateDate(startDate);
			return startDateOutput;
		}else
			return Printer.getPrintout("dateNotSet");
	}
	
	public void setStartDate(String newDate) {
		String convertedDate = DateConverter.convertDate(newDate);
		this.startDate = new LocalDate(convertedDate);		
	}

	public String getEndDate() {
		if(!(endDate == null)){
			String endDateOutput = DateConverter.formateDate(endDate);
			return endDateOutput;
		}else
			return Printer.getPrintout("dateNotSet");
	}

	public void setEndDate(String newDate) {
		String convertedDate = DateConverter.convertDate(newDate);
		this.endDate = new LocalDate(convertedDate);
	}
	
	
	public String toString(){
		return ("\nBudget Name: " + getName() + "\nBudget Start: " + getStartDate() + 
				"\nBudget End: " + getEndDate() + "\n");
	}

	@Override
	public Collection<LineItem> items() {
		return items;
	}

	@Override
	public BigDecimal total() {
		return totalCost;
	}

	@Override
	public LocalDate start() {
		return startDate;
	}

	@Override
	public LocalDate end() {
		return endDate;
	}

}
