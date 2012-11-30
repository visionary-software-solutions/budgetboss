package com.visionarysoftwaresolutions.budgetboss.fileops;

import java.io.*;

public class Finder {
	
	private Finder() {}
	
	private static String currentOS;
	private static String currentUser;
	
	public static File[] findBudgets(String directoryToSearch){
		File foundBudget = new File(directoryToSearch);
			return foundBudget.listFiles(new FilenameFilter(){
				public boolean accept(File foundBudget, String filename){
					return filename.endsWith(".bgt");
				}
			});
	}
	
	public static String pathFinder(){
		currentOS = System.getProperty("os.name").toLowerCase();
		currentUser = System.getProperty("user.name");
		if(isWindows()){
			return ("C:/Users/" + currentUser + "/Documents/");
		}else if(isLinux()){
			return ("/home/" + currentUser + "/Documents/");
		}else
			return "Can't determine default path!";
	}
	
	private static boolean isWindows(){
		return (currentOS.indexOf("win") >= 0);
	}
	
	private static boolean isLinux(){
		return (currentOS.indexOf("nux") >=0);
	}
}