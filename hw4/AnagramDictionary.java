// Name: Yan Yiming	
// USC NetID: yimingy
// CS 455 PA4
// Spring 2017

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap; 


/**
 * A dictionary of all anagram sets. 
 * Note: the processing is case-sensitive; so if the dictionary has all lower
 * case words, you will likely want any string you test to have all lower case
 * letters too, and likewise if the dictionary words are all upper case.
 */

public class AnagramDictionary {
   
	private TreeMap<String, ArrayList<String>> resultMap;
	Scanner fileScanner;
   /**
    * Create an anagram dictionary from the list of words given in the file
    * indicated by fileName.  
    * PRE: The strings in the file are unique.
    * @param fileName  the name of the file to read from
    * @throws FileNotFoundException  if the file is not found
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException {
	   
	   fileScanner= new Scanner(new File(fileName));

   }
   
   public AnagramDictionary(String fileName, ArrayList<String> list) throws FileNotFoundException {
	   
	   fileScanner= new Scanner(new File(fileName));
	   
	   resultMap = anagramsOfAllSet(list);
   }
   
   public TreeMap<String, ArrayList<String>> getMap() {
	   return resultMap;
   }
   

   /**
    * Get all anagrams of the given string. This method is case-sensitive.
    * E.g. "CARE" and "race" would not be recognized as anagrams.
    * @param s string to process
    * @return a list of the anagrams of s
    * 
    */
   public ArrayList<String> getAnagramsOf(String s) {
	   ArrayList<String> anaArrList = new ArrayList<String>();
	   String dircStr;
	   while (fileScanner.hasNextLine()) {
		   dircStr = sortedRack(fileScanner.nextLine());
//		   System.out.println(dircStr);
		   if (dircStr.equals(s)) {
			   anaArrList.add(dircStr);
			   System.out.println(anaArrList);
		   }
	   }   
       return anaArrList; 
   }
   
   
   /**
    * Get the collection of all anagrams of each set.
    * @param arraylist an array list store all subsets from Rack.java
    * @return a hashmap of all anagrams of each set in arraylist.
    */
   
   public TreeMap<String, ArrayList<String>> anagramsOfAllSet(ArrayList<String> arraylist) {
	   TreeMap<String, ArrayList<String>> resultTemp = new TreeMap<String, ArrayList<String>>();
	   String string;
	   String sortedOrder;
	   for (int i = 0; i < arraylist.size(); i++) {
		   string = arraylist.get(i);
//		   System.out.println(string);
		   sortedOrder = sortedRack(string);
//		   System.out.println(sortedOrder);
		   resultTemp.put(sortedOrder, getAnagramsOf(sortedOrder));

	   }
	   return resultTemp;
   }
   
   
   /**
    * Get the sorted order string.
    * @param the string 
    * @return a string of sortedOrder in a...z.
    */
   
   public String sortedRack(String s) {
	   
	   ArrayList<String> temp = new ArrayList<String>();
	   for (int i = 0; i < s.length(); i++) {
		   temp.add(String.valueOf(s.charAt(i)));
	   }
	   Collections.sort(temp);
	   StringBuilder sb = new StringBuilder();
	   for (String str : temp) {
		   sb.append(str);
	   }
	   return sb.toString();
   }

   
   /**
    * exchange the value(position) of two char.
    * @param two chars.
    */
   
	private void exchange(char char1, char char2) {
		char temp = char1;
		char1 = char2;
		char2 = temp;	
	}
   
   
}
