package com.debarnab.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class wordChainPuzzule  {
    private String [] dict;
    private int depth;

    public wordChainPuzzule(String[] wordList, int depth) {
        this.dict = wordList;
        this.depth = depth;
    }

    public wordChainPuzzule(String[] wordList) {
        this(wordList, 10);
    }

    public String [] getChain( String from, String to ) {
        // check that from and to exists
        if ( ! ( wordPresentInDictionary(from) && wordPresentInDictionary(to) ) ) return new String[0];

        for ( int i=0; i < depth; i++ ) {
            Stack<String> stack = new Stack<>();
            recurse( from, to, stack, i );
            if ( stack.size() != 1 ) 
            	return stack.toArray( new String[stack.size()] );
        }
        return new String[0];
    }

    private boolean recurse( String from, String to, Stack<String> stack, int maxDepth ) {
        stack.push( from );
        if( stack.size() > maxDepth ) return false;  
        if ( from.equals( to) ) return true;

        for ( String w: dict) {
            if ( w.length() == from.length() && differeceofLettersBetweenWords( from, w ) == 1 && !stack.contains(w) ) {
                if ( recurse( w, to, stack, maxDepth ) )
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
            if ( s.equals( word ) ) return true;
        }
        return false;
    }
    
}
