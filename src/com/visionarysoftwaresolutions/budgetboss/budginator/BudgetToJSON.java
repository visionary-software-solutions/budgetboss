package com.visionarysoftwaresolutions.budgetboss.budginator;

import org.json.simple.*;

import com.visionarysoftwaresolutions.budgetboss.budget.Budget;

public class BudgetToJSON {
	
	public static JSONObject convertToBudginator(Budget budget){
		JSONObject convertedBudget = new JSONObject();
		convertedBudget.put("name", budget.getName());
		convertedBudget.put("startDate", budget.getStartDate());
		convertedBudget.put("endDate", budget.getEndDate());
		return convertedBudget;
	}
}
