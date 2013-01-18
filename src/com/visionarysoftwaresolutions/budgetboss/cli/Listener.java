package com.visionarysoftwaresolutions.budgetboss.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Listener{
	
    private String userInput = null;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   
    private Listener(){}
       
    public void setReader(BufferedReader reader){
    	this.reader = reader;
    }
   
    public static Listener create(){
    	return new Listener();
    }
    
    public String getInput(){
    	 try {
			userInput = reader.readLine();
		}catch (IOException e){
			System.out.println("I/O ERROR!");
		}
		return userInput;
    }
    
    public void closeListener(){
    	try {
			reader.close();
		} catch (IOException e) {
			System.out.println("I/O ERROR!");
		}
    }
}    