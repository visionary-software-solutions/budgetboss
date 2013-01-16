package com.visionarysoftwaresolutions.budgetboss.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Listener{
	
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String userInput = null;
   
    private Listener(){}
   
    public static Listener create(){
        return new Listener();
    }
    
    public void setReader(BufferedReader reader){
    	this.reader = reader;
    }
   
    public String getInput(){
        try {
            userInput = reader.readLine();
        } catch (IOException e) {
            System.out.println("I/O ERROR!?");
        }
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("I/O ERROR!");
        }
        return userInput;
    }
}    