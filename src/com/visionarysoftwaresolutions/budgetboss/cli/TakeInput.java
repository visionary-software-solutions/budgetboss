package com.visionarysoftwaresolutions.budgetboss.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class TakeInput implements RequiredInputs{
	
	public Reader reader;
	private String stringInput;
   
    private TakeInput(){}
   
    public static TakeInput create(){
        return new TakeInput();
    }
    
    public void setReader(Reader reader){
    	this.reader = reader;
    }
    
    public String getStringConsole(){
    	try {
            stringInput = ((BufferedReader) reader).readLine();
        } catch (IOException e) {
            System.out.println("I/O Error!");
        }
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("I/O Error!");
        }
        return stringInput;
    }

}