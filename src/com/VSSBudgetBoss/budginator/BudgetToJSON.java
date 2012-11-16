package com.VSSBudgetBoss.budginator;

import org.json.simple.*;
import com.VSSBudgetBoss.budget.Budget;

public class BudgetToJSON {
	
	public static JSONObject convertToBudginator(Budget budget){
		JSONObject convertedBudget = new JSONObject();
		convertedBudget.put("name", budget.getName());
		convertedBudget.put("startDate", budget.getStartDate());
		convertedBudget.put("endDate", budget.getEndDate());
		return convertedBudget;
	}
}
