// Name: Yan Yiming	
// USC loginid: 5552625298
// CS 455 PA2
// Spring 2017


import java.util.ArrayList;
import java.math.*;
/**
   A polynomial. Polynomials can be added together, evaluated, and
   converted to a string form for printing.
*/
public class Polynomial {

	private ArrayList<Term> PolyList;
	private final double ZERO_COEFF = 0;
	private final String EMPTY_TERM = "0.0";
	

    /**
       Creates the 0 polynomial
    */
    public Polynomial() {
    	PolyList = new ArrayList<Term>();
    	assert isValidPolynomial();  	
    }


    /**
       Creates polynomial with single term given
     */
    public Polynomial(Term term) {
    	PolyList = new ArrayList<Term>();
    	PolyList.add(term);
    	assert isValidPolynomial();
    }


    /**
       Returns the Polynomial that is the sum of this polynomial and b
       (neither poly is modified)
     */
    public Polynomial add(Polynomial b) {
    	
    	assert this.isValidPolynomial();  
    	assert b.isValidPolynomial();  
    	
    	Polynomial result = new Polynomial();
    	
    	int i = 0, j = 0;
    	while(i<this.PolyList.size() && j<b.PolyList.size()) {
    		if(this.PolyList.get(i).getExpon()>b.PolyList.get(j).getExpon()) {
    			result.PolyList.add(this.PolyList.get(i));
    			i++;
    		}else if (this.PolyList.get(i).getExpon()<b.PolyList.get(j).getExpon()) {
    			result.PolyList.add(b.PolyList.get(j));
    			j++;
    		}else {
    			result.PolyList.add(new Term(this.PolyList.get(i).getCoeff() + b.PolyList.get(j).getCoeff(), b.PolyList.get(j).getExpon()));
    			i++;
    			j++;
    		}
    	}
    	
    	if(i == this.PolyList.size()) {
    		while(j<b.PolyList.size()) {
    			result.PolyList.add(b.PolyList.get(j++));
    		}
    	}
    	if(j == b.PolyList.size()) {
    		while(i<this.PolyList.size()) {
    			result.PolyList.add(this.PolyList.get(i++));
    		}
    	}
    	
    	result.removeZero();
    	assert result.isValidPolynomial();  
    	
 	   	return result;
    
    }

    /**
    Remove (0,0) in the polynomial.
   */
    private void removeZero() {
    	for (int i=this.PolyList.size()-1; i>=0; i--){
    	    if (this.PolyList.get(i).getCoeff() == ZERO_COEFF){	
    	    	this.PolyList.remove(i);
    	    }
    	}
    } 


	/**
       Returns the value of the poly at a given value of x.
     */
    public double eval(double x) {
    	double sum = 0;
    	for(int i=0; i<this.PolyList.size(); i++){
    		sum += PolyList.get(i).getCoeff() * Math.pow(x, PolyList.get(i).getExpon());
    	}
    	return sum;
    }


    /**
       Return a String version of the polynomial with the 
       following format, shown by example:
       zero poly:   "0.0"
       1-term poly: "3.2x^2"
       4-term poly: "3.0x^5 + -x^2 + x + -7.9"

       Polynomial is in a simplified form (only one term for any exponent),
       with no zero-coefficient terms, and terms are shown in
       decreasing order by exponent.
    */
    public String toFormattedString() {
    	
    	String formatString = "";
    	
    	for (int i=0; i<this.PolyList.size(); i++) {
    		
    		double coeff = PolyList.get(i).getCoeff();
    		int expon = PolyList.get(i).getExpon();
    		String Scoeff = coeff + "x";
    		String Sexpon = "^" + expon + " + ";
    		
    		if(coeff == 1) {
    			Scoeff = "x";
    		}
    		if(coeff == -1) {
    			Scoeff = "-x";
    		}
    		if(expon == 1) {
    			Sexpon = " + ";
    		}
    		if(expon == 0) {
    			Scoeff = coeff + "";
    			Sexpon = " + ";
    		}
    		
    		if(i == this.PolyList.size()-1) {
    			Sexpon = "^" + expon;
    			if(expon == 1) {
    				Sexpon = "";  
    			}
    			if(expon == 0) {
        			Scoeff = coeff + "";
        			Sexpon = "";
        		}
    		}
    		
    		if(coeff == 0) {
    			Scoeff = "";
    			Sexpon = "";
    		}
    		
    		formatString += (Scoeff + Sexpon);    		
    	}
    	
    	if (this.PolyList.size() == 0 || (this.PolyList.size() == 1 && PolyList.get(0).getCoeff() == 0)) {
    		formatString = EMPTY_TERM;
    	}
    	
    	return formatString;
    }


    // **************************************************************
    //  PRIVATE METHOD(S)

    /**
       Returns true iff the poly data is in a valid state.
    */
    private boolean isValidPolynomial() {
    	for(int i=0; i<this.PolyList.size(); i++) {
    		for(int j=i+1; j<this.PolyList.size(); j++) {
    			if (i != 0 && this.PolyList.get(i).getCoeff() == ZERO_COEFF){
    			    return false;
    			}
    			if(this.PolyList.get(i).getExpon() <= this.PolyList.get(j).getExpon()) {
    				return false;
    			}
    			
    		}
    		
    	}
    	return true;
    }

}
