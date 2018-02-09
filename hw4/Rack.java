// Name: Yan Yiming
// USC NetID: yimingy
// CS 455 PA4
// Spring 2017

import java.util.ArrayList;

/**
 * A Rack of Scrabble tiles
 */

public class Rack {
	
	private ArrayList<String> subsets;
   
	public Rack(String s) {
		subsets = getSubset(s);
	}
	
	/**
    * get method to get the subsets.
    */
	
	public ArrayList<String> getRack() {
		return subsets;
	}
	
	/**
    * make the unique and mult[].
    * PRE: mult.length must be at least as big as unique.length()
    */

	public ArrayList<String> getSubset(String s) {

	   int length = s.length();
	   int[] mult = new int[length];
	   
	   char[] tempchar = new char[length];
	   for (int i = 0; i < length; i++) {
		   tempchar[i] = s.charAt(i);
	   }
	   
	   for (int i = 0; i < length; i++) {
		   for (int j = i; j > 0; j--) {
			   if (tempchar[j] < tempchar[j-1]) {
				   exchange(tempchar[j], tempchar[j-1]);
			   }else {
				   break;
			   }
		   }
	   }
	   
	   String unique = "";
	   int count = 1;
	   int count_l = 0;
	   int i = 0, j = 1;
	   unique += tempchar[0];
	   while (j < length) {
		   if (tempchar[i] == tempchar[j]) {
			   count++;
			   i++;
			   j++;
		   }else {
			   mult[count_l] = count;
			   count_l++;
			   count = 1;
			   unique += tempchar[j];
			   i++;
			   j++;
		   }
	   }
	   
	   return allSubsets(unique, mult, 0);
	}
	
	private void exchange(char char1, char char2) {
		char temp = char1;
		char1 = char2;
		char2 = temp;	
	}

   /**
    * Finds all subsets of the multiset starting at position k in unique and mult.
    * unique and mult describe a multiset such that mult[i] is the multiplicity of the char
    *      unique.charAt(i).
    * PRE: mult.length must be at least as big as unique.length()
    * @param unique a string of unique letters
    * @param mult the multiplicity of each letter from unique.  
    * @param k the smallest index of unique and mult to consider.
    * @return all subsets of the indicated multiset
    * @author Claire Bono
    */
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<>();
      
      if (k == unique.length()) {  // multiset is empty
         allCombos.add("");
         return allCombos;
      }
      
      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k+1);
      
      // prepend all possible numbers of the first char (i.e., the one at position k) 
      // to the front of each string in restCombos.  Suppose that char is 'a'...
      
      String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {   
         for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets 
                                                        // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));  
         }
         firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
      }
      
      return allCombos;
   }

   
}
