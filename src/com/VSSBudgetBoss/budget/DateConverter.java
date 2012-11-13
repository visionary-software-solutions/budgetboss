package com.VSSBudgetBoss.budget;

import org.joda.time.LocalDate;
import org.joda.time.format.*;

public class DateConverter {
	
	private static DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");
	
	public static String formateDate(LocalDate toFormat){
		String formatted = toFormat.toString(formatter);
		return formatted;
		}
	

	public static String convertDate(String toConvert){
		String delimiter = "[/]";
		String[] dateInput = toConvert.split(delimiter);
		String convertedDate = dateInput[2] + "-" + dateInput[0] + "-" + dateInput[1];	
		return convertedDate;
	}


}
