package com.debarnab.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class loadDictionary {
	
	 public static String [] loadDict() {    	
			try{

				BufferedReader reader = new BufferedReader(new FileReader(new File(System.getProperty("user.dir")+"//src//com//debarnab//resource//websters-dictionary.txt")));
				List<String> l = new ArrayList<>();
				String s;
				while ( (s = reader.readLine() ) !=null ) {
					l.add(s);
				}
				return l.toArray(new String[l.size()]);
			}catch(Exception e){
				throw new RuntimeException(e);
			}
		}

}
