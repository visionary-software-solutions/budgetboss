package com.visionarysoftwaresolutions.budgetboss.budget;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ExpenseCategory {
	
	private String categoryName;
	private ArrayList<Expense> expenses = new ArrayList<Expense>();
	private BigDecimal budgeted;
	private BigDecimal totalSpent;
	private BigDecimal totalRemaining;
	
	public ExpenseCategory(String name){
		categoryName = name;
	}
	
	public void addExpense(Expense expense){
		expenses.add(expense);
	}
	
	public BigDecimal getSpent(){
		totalSpent = new BigDecimal("00.00");
		for(int i = 0; i < expenses.size(); i++){
			totalSpent = totalSpent.add(expenses.get(i).getCost());
		}
		return totalSpent;
	}
}
