package com.VSSBudgetBoss.budget;

import java.math.BigDecimal;
import org.joda.time.*;
public interface LineItem {

	LocalDate purchased();
	String item();
	BigDecimal cost();
}
