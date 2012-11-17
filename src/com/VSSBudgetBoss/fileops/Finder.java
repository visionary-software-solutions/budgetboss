package com.VSSBudgetBoss.fileops;

import java.io.*;

public class Finder {
	
	public static File[] findBudgets(String directoryToSearch){
		File foundBudget = new File(directoryToSearch);
			return foundBudget.listFiles(new FilenameFilter(){
				public boolean accept(File foundBudget, String filename){
					return filename.endsWith(".bgt");
				}
			});
	}
}

