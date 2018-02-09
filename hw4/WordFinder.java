import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JFrame;

// Name: Yan Yiming
// USC NetID: yimingy
// CS 455 PA4
// Spring 2017

public class WordFinder {
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.print("Rack? ");
		 
		Scanner keybd = new Scanner(System.in);
		String input = keybd.next().toLowerCase();
		
		Rack rack = new Rack(input);
		AnagramDictionary anagram = new AnagramDictionary(args[0], rack.getRack());
		TreeMap<String, ArrayList<String>> resultAnagram = anagram.getMap();
		
		Set<String> keyset = resultAnagram.keySet();
		ScoreTable scores = new ScoreTable();
		
		int scoreOfKey;
		TreeMap<String, Integer> scoreOfResult = new TreeMap<String, Integer>();
		Iterator<String> iter = keyset.iterator();
		
		int numb = 0;
		while (iter.hasNext()) {
			String key = iter.next();
			scoreOfKey = scores.getScore(key);
			numb += resultAnagram.get(key).size();
			scoreOfResult.put(key, scoreOfKey);
		}
		
		System.out.println("We can make " + numb + " words from '" + input + "'");
		System.out.println("All of the words with their scores (sorted by score):");
		
		ValueComparator bvc =  new ValueComparator(scoreOfResult);  
        TreeMap<String,Integer> sorted_ScoreMap = new TreeMap<String,Integer>(bvc);
        sorted_ScoreMap.putAll(scoreOfResult);
        
        Set<Map.Entry<String, Integer>> entrySet = sorted_ScoreMap.entrySet(); 
        Set<Map.Entry<String, ArrayList<String>>> entrySet_list = resultAnagram.entrySet();
        
        Iterator<Map.Entry<String, Integer>> it = entrySet.iterator();
        
        //I don't know why I can not use get() method in map, so I use entrySet to solve this problem,
        //which makes it very complex. 
        
        while (it.hasNext()) {  
          Map.Entry<String, Integer> me = it.next();
          String s = me.getKey();  
          int score = me.getValue(); 
          
          Iterator<Map.Entry<String, ArrayList<String>>> it_list = entrySet_list.iterator();
          while (it_list.hasNext()) {
        	  Map.Entry<String, ArrayList<String>> list = it_list.next();
        	  String ss = list.getKey();
        	  ArrayList<String> listAnagram;
        	  String[] orderAnagram;
        	  
        	  if(s.equals(ss)) {
        		  listAnagram = list.getValue(); 
        		  
        		  //print the final score
        		  for(String a : listAnagram) {
        			  System.out.println(score + ": " + a);
        		  }
        	  }
          }
        }           
        
	}
}

/**
 * inplements the comparator interface and override the compare method to sort scores.
 * PRE: mult.length must be at least as big as unique.length()
 */

class ValueComparator implements Comparator<String> {  
	  
    Map<String, Integer> base;  
    public ValueComparator(Map<String, Integer> base) {  
        this.base = base;  
    }  
  
    // Note: this comparator imposes orderings that are inconsistent with equals.      
    public int compare(String a, String b) {  
        if (base.get(a) >= base.get(b)) {  
            return -1; 
        } else {  
            return 1;  
        } // returning 0 would merge keys  
    }  
} 


