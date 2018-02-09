import java.util.ArrayList;
import java.lang.Integer;
/**
   Stores a sequence of integer data values and supports some computations
   with it.

   CS 455 Lab 4.
*/
public class Nums {

	ArrayList<Integer>arrNumb;
	Nums NewNumb;
    /**
       Create an empty sequence of nums.
     */
    public Nums () {
    	arrNumb = new ArrayList<Integer>(); 
    }

    /**
       Add a value to the end of the sequence.
     */
    public void add(int value) {
    	arrNumb.add(value);
    }


    /**
       Return the minimum value in the sequence.
       If the sequence is empty, returns Integer.MAX_VALUE
     */
    public int minVal() {
    	if(arrNumb.size()!=0) {
    		int min = arrNumb.get(0);
        	for(int i=0; i<arrNumb.size(); i++) {
        		if(min > arrNumb.get(i)) min=arrNumb.get(i);
        	}
        	return min;    // stub code to get it to compile
    	}else {
    		return 0;
    	}
    	
    }

    /**
       Prints out the sequence of values as a space-separated list 
       on one line surrounded by parentheses.
       Does not print a newline.
       E.g., "(3 7 4 10 2 7)", for empty sequence: "()"
    */
    public void printVals() {
    	if(arrNumb.size()==0) {
   
    	}else {
    		System.out.print("( ");
    		for(int i=0;i<arrNumb.size();i++) {
    			System.out.print(arrNumb.get(i) + " ");  	    
    		}
    		System.out.print(" )");
    	}
    }

    /**
       Returns a new Nums object with all the values from this Nums
       object that are above the given threshold.  The values in the
       new object are in the same order as in this one.
       E.g.: call to myNums.valuesGT(10) where myNums = (3 7 19 4 21 19 10)
             returns      (19 21 19)
             myNums after call:  (3 7 19 4 21 19 10)
       The method does not modify the object the method is called on.
     */
    public Nums valuesGT(int threshold) {
    	if(arrNumb.size()!=0){
    		NewNumb = new Nums();
    		for(int i=0; i<arrNumb.size(); i++) {
        		int temp = arrNumb.get(i);
        		if(temp > threshold)  NewNumb.add(temp);
        	}
    		return NewNumb;
    	}else{
    		return new Nums();
    	}
    }

    
}
