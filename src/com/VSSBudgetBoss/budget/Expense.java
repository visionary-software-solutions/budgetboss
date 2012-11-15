package com.VSSBudgetBoss.budget;

import java.math.BigDecimal;
import org.joda.time.LocalDate;

public class Expense {
	
	private BigDecimal cost;
	private LocalDate incurredOn;
	private String payee;
	
	public Expense(BigDecimal cost, LocalDate incurredOn, String payee){
		this.cost = cost;
		this.incurredOn = incurredOn;
		this.payee = payee;
	}
	
	public void setCost(BigDecimal cost){
		this.cost = cost;
	}
	
	public BigDecimal getCost(){
		return cost;
	}
	
	public void setIncurred(LocalDate incurredOn){
		this.incurredOn = incurredOn;
	}
	
	public LocalDate getIncurred(){
		return incurredOn;
	}
	
	public void setPayee(String payee){
		this.payee = payee;
	}
	
	public String getPayee(){
		return payee;
	}

}
