package com.VSSBudgetBoss.budget;

import java.math.BigDecimal;
import java.util.*;
import org.joda.time.*;

public interface MasterBudget {

	Collection<LineItem> items();
	BigDecimal total();
	LocalDate start();
	LocalDate end();
}
