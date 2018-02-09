package lab8;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Ex3 {
	/*
     * see lab assgt for specification of hasPeak method.
     */
    public static boolean hasPeak(LinkedList<Integer> list) {
    	
    	int size = list.size();
    	
    	int i = 0;
    	while(i < size-1 && list.get(i) < list.get(i+1)) {
    		i++;
    	}
    	
    	if((i == 0) || (i == size - 1)) {
			return false;
		}
    	
    	while(i < size -1 && list.get(i) > list.get(i+1)){
    		i++;
    	}
    	
    	return (i == size - 1);		

    }



    public static void main(String args[]) {

	testPeak("", false);
	testPeak("3", false);
	testPeak("3 4", false);
	testPeak("4 2", false);
	testPeak("3 4 5", false);
	testPeak("5 4 3", false);
	testPeak("3 4 5 3", true);
	testPeak("3 4 5 3 2", true);
	testPeak("3 7 9 11 8 4 3 1", true);
	testPeak("3 5 4", true);
	testPeak("4 3 5", false);
	testPeak("2 4 3 5", false);
	testPeak("5 2 4 3 5", false);
	testPeak("5 2 4 3", false);
	testPeak("2 4 3 5 2", false);  // 2 peaks
    }

    
    
    /*  Assumes the following format for list strings (first one
     *     is empty list):
     *   "", "3", "3 4", "3 4 5", etc.
     */
    public static LinkedList<Integer> makeList(String listString) {
		Scanner strscan = new Scanner(listString);
	
		LinkedList<Integer> list = new LinkedList<Integer>();
	
		// strscan.skip("\\[");  // consume the "["
		while (strscan.hasNextInt()) {
		    list.add(strscan.nextInt());
		}
	
		return list;
    }


    /* Test hasPeak method on a list form of input given in listString
     * Prints test data, result, and whether result matched expectedResult
     *
     * listString is a string form of a list given as a space separated
     * sequence of ints.  E.g.,
     *  "" (empty string), "3" (1 elmt string), "2 4" (2 elmt string), etc.
     *
     */
    public static void testPeak(String listString, boolean expectedResult) {

		LinkedList<Integer> list = makeList(listString);
	
		boolean result = hasPeak(list);
		System.out.print("List: " + list
				   + " hasPeak? " + result);
		if (result != expectedResult) {
		    System.out.print("...hasPeak FAILED");
		}
		System.out.println();
	    }
}
