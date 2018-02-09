package lab8;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Ex1 {
	
	// prints alternate values in a list:
    // first, third, fifth, etc.
    public static void printAlt(LinkedList<Integer> list) {
    	int s = list.size();
    	
    	for (int i=1; i<=s/2; i++) {
    		list.remove(i);
    	}
    	
    	System.out.println(list);
    	
    }
	
	

	public static void main(String[] args) {
		
		testPrintAlt("");
		testPrintAlt("3");
		testPrintAlt("3 6");
		testPrintAlt("3 2 4");
		testPrintAlt("3 2 4 5");
		testPrintAlt("3 2 4 5 2 2 9 4");
		testPrintAlt("3 2 4 5 2 2 9");

	}

	    
	    
	    /*  Assumes the following format for list strings (first one
	     *     is empty list):
	     *   "", "3", "3 4", "3 4 5", etc.
	     */
    public static LinkedList<Integer> makeList(String listString) {
		Scanner strscan = new Scanner(listString);
	
		LinkedList<Integer> list = new LinkedList<Integer>();
	
		while (strscan.hasNextInt()) {
		    list.add(strscan.nextInt());
		}
	
		return list;
    }



	    /* Test printAlt method on a list form of the input given in listString
	     * Prints test data, and output of printAlt
	     *
	     * listString is a string form of a list given as a space separated
	     * sequence of ints.  E.g.,
	     *  "" (empty string), "3" (1 elmt string), "2 4" (2 elmt string), etc.
	     *
	     */
    public static void testPrintAlt(String listString) {

		LinkedList<Integer> list = makeList(listString);

		System.out.println("list: " + list);

		System.out.print("printAlt(list): ");
		printAlt(list);

		System.out.println();
		System.out.println();
	}

}
