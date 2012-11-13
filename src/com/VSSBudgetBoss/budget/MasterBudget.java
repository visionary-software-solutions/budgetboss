package com.VSSBudgetBoss.budget;

import java.math.BigDecimal;
import java.util.*;

public interface MasterBudget {

	Collection<LineItem> items();
	BigDecimal total();
	Date start();
	Date end();
}
