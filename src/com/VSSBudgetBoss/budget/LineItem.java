package com.VSSBudgetBoss.budget;

import java.math.BigDecimal;
import java.util.Date;

public interface LineItem {

	Date purchased();
	String item();
	BigDecimal cost();
}
