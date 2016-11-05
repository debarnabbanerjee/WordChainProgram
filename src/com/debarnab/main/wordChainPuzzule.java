package com.debarnab.main;

import java.util.Stack;

public class wordChainPuzzule  {
	private String [] dict;
	private int depth = 10;   // maximum range of word chain is 10

	public wordChainPuzzule(String[] dict) {
		this.dict = dict;
	}

	public String [] getChain( String from, String to ) {
		// check that from and to exists
		if ( ! ( wordPresentInDictionary(from) && wordPresentInDictionary(to) ) ) 
			return new String[0];
		for ( int i=0; i < depth; i++ ) {
			Stack<String> stack = new Stack<>();
			
			findElements( from, to, stack, i );
			
			if ( stack.size() != 1 ) 
				return stack.toArray( new String[stack.size()] );
		}
		return new String[0];
	}

	private boolean findElements( String from, String to, Stack<String> stack, int maxDepth ) {
		stack.push( from );
		if( stack.size() > maxDepth ) return false;  
		if ( from.equals( to) ) return true;

		for ( String w: dict) {
			if ( w.length() == from.length() && differeceofLettersBetweenWords( from, w ) == 1 && !stack.contains(w) ) {
				if ( findElements( w, to, stack, maxDepth ) )
					return true;
				stack.pop();
			}
		}
		return false;
	}
	
	// calculating the difference of characters between the words
	private int differeceofLettersBetweenWords( String a, String b ) {
		int dif = 0;
		for ( int i=0; i< a.length(); i++ ) {
			if ( a.charAt(i) != b.charAt(i) ) dif++;
		}
		return dif;
	}

	// checking  the dictionary has the word or not.
	private boolean wordPresentInDictionary(String word) {
		for ( String s: dict) {
			if ( s.equals( word ) ) 
				return true;
		}
		return false;
	}
}
