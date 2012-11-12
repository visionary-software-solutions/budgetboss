package com.VSSBudgetBoss.budget;

import org.json.simple.*;

public class BudgetToJSON {
	
	public static JSONObject convertToBudginator(Budget budget){
		JSONObject convertedBudget = new JSONObject();
		convertedBudget.put("name", budget.getName());
		convertedBudget.put("startDate", budget.getStartDate());
		convertedBudget.put("endDate", budget.getEndDate());
		//I just want to see it on the console for now, printing not required
		System.out.print(convertedBudget);
		return convertedBudget;
	}
	
	//Demonstration purposes
	public static void main(String args[]){
		Budget budget = new Budget("JSONbudget");
		convertToBudginator(budget);
	}
}
