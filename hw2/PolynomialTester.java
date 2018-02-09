// Name: Yan Yiming	
// USC loginid: 5552625298
// CS 455 PA2
// Spring 2017

public class PolynomialTester {

	public static void main(String[] args) {
		Polynomial test = new Polynomial(new Term(5,3));
		Polynomial test1 = new Polynomial(new Term(2,2));
		test.add(test1);
		
		Term empty=new Term();
		Polynomial emptyPoly=new Polynomial(empty);
        System.out.println("Empty poly: "+emptyPoly.toFormattedString());
        Term term=new Term(3,7);
        Polynomial operandA=new Polynomial(term);
        //System.out.println(term.toString());
        Polynomial operandB=new Polynomial(new Term(-4,6));
        Polynomial result=operandA.add(operandB);
        System.out.println("Single term Poly: "+operandA.toFormattedString());
        System.out.println("Addition of two Single term : "+result.toFormattedString());   //result 2  entry
         Polynomial operandC=new Polynomial(new Term(4,6));  
         Polynomial result2=result.add(operandC);  // result2 3 entry
        System.out.println(result2.toFormattedString());
        Polynomial result3=result2.add(result);   
        System.out.println(result3.toFormattedString());
        



			Polynomial emp=new Polynomial();
			System.out.println("zero poly: "+emp.toFormattedString());

	}

}
