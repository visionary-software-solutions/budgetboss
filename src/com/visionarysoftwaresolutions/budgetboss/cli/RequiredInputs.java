package com.visionarysoftwaresolutions.budgetboss.cli;

import java.io.BufferedReader;
import java.io.Reader;

public interface RequiredInputs {
	
	Reader reader = null;

	public String getStringConsole();

	public void setReader(Reader reader);
}
