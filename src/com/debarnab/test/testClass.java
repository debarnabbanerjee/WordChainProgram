package com.debarnab.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.debarnab.main.wordChainPuzzule;

public class testClass {
		
	String[] dic;
	
	@BeforeTest
	public void loadDictionary(){
		// load the dictionary in the beginning of the class		
		dic = com.debarnab.main.loadDictionary.loadDict();
		
	}
	
		
    @Test(dataProvider="getData")	
    public void testGetChain(String from,String to) {  	
    	
    	wordChainPuzzule myTest = new wordChainPuzzule(dic);		
        String[] words =  myTest.getChain( from, to );      
        if(words.length<=0){
        	Assert.fail("Word Change not possible");        	
        }else if(words.length>2){
        	System.out.println("Word change from  "+ from + " to " + to + " is:");
        	 for(String s : words){
             	System.out.println(s);
             }
        }
    }
    
    @DataProvider
    public Object[][] getData(){
    	
    	Object[][] data = new Object[3][2]; 
    	
    	data[0][0] = "cat";
    	data[0][1] = "dog";
    	 	
    	data[1][0] = "salary";
    	data[1][1] = "salmon";
    	
    	data[2][0] = "lead";
    	data[2][1] = "gold";
    	
    	return data;
    	
    }

    

}
