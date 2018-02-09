import java.util.Scanner;

// Name: Yan Yiming	
// USC loginid: 5552625298
// CS 455 PA2
// Spring 2017

public class PolynomialCalculator {
	
	public static void main(String[] args) {
		
		//Initialize array of polynomials as zero polynomials
		for (int i=0; i<10; i++){
		    polyList[i] = new Polynomial();
		}		
		
		//Loop until quit
		while(true) {
			System.out.print("cmd> ");
			
			Scanner keybd = new Scanner(System.in);
			Scanner input = new Scanner(keybd.nextLine());
			String in;
			
			if (input.hasNext()){
				in = input.next().toLowerCase();
			}else{
				continue;
			}
			
			//record input in an array max to first three
			//validify the input number			
			boolean flag = true;
			int[] nextInt = new int[SIZE_OF_NEXTINT];
			for(int i=0; input.hasNext(); i++) {
				nextInt[i] = input.nextInt();
				flag = isIdxValid(nextInt[i]);
				if (flag == false) {
					break;
				}
			}
			if(!flag) {
				continue;
			}
			
			//do command
			if(in.equals("create")) {
				doCreate(nextInt[0]);
			}else if(in.equals("print")) {
				doPrint(nextInt[0]);
			}else if(in.equals("eval")) {
				doEval(nextInt[0]);
			}else if(in.equals("add")) {
				doAdd(nextInt[0], nextInt[1], nextInt[2]);
			}else if(in.equals("quit")) {
				break;
			}else if(in.equals("help")) {
				help();
			}else {
				System.out.println("ERROR: Illegal command.  Type 'help' for command options.");
			}
		    
		}
		
	}
	
	/**
    create a Polynomial with specific Terms
	*/
	private static void doCreate(int order) { 
		
		System.out.println("Enter a space-separated sequence of coeff-power pairs terminated by <nl>");
		
		keybd = new Scanner(System.in);
		Scanner in = new Scanner(keybd.nextLine());
		
		Polynomial theCreate = new Polynomial();
		double coeff;
		int expon;
		
		while(in.hasNextDouble()) {
			coeff = in.nextDouble();
			
			if(in.hasNextInt()) {
				expon = in.nextInt();
				if (expon < 0){
					expon = Math.abs(expon);
					System.out.println("WARNING: Negative exponential value, using absolute instead");
				}
				theCreate = theCreate.add(new Polynomial(new Term(coeff, expon)));
			}else {
				System.out.println("WARNING: Ignore the last value entered. You have to input even number of values");
				break;
			}	
		}
		
		polyList[order] = theCreate;
	}
	
	private static void doPrint(int order) {
		System.out.println(polyList[order].toFormattedString());
	}
	
	private static void doAdd(int order_fi, int order_1, int order_2) {
		polyList[order_fi] = polyList[order_1].add(polyList[order_2]);
	}
	
	private static void doEval(int order) {
		keybd = new Scanner(System.in);
		System.out.print("Enter a floating point value for x: "); 
		double evalResult = polyList[order].eval(keybd.nextInt());
		System.out.println(evalResult);
	}
	
	/**
    print the help prompt about function of different command.
    */
	private static void help() {
		System.out.println("----------------------------------------\n** All commands are case insensitive! **\n----------------------------------------\n");
		System.out.println("** CREATE x: x represents the index of polynomial, from 0 to 9\n");
		System.out.println("** PRINT x: x represents the index of polynomial, from 0 to 9\n");
		System.out.println("** ADD x x2 x3: Add two polynomials, x is the index of result polynomial,\n                while x2 and x3 is the operands' index, all from 0 to 9\n");
		System.out.println("** EVAL x: Evaluate the value of polynomial, x is the index of terget polynomial\n");
	    System.out.println("** QUIT: Exit the program");
	}
	
	/**
    Return true when the input is in the range of 0-9, inclusive
    */
	private static boolean isIdxValid(int nextInt) {
		if (nextInt<0 || nextInt>9){
			System.out.println("ERROR: illegal index.  must be between 0 and 9, inclusive");
			return false;
		}
		return true;
	}
	
	private static Scanner keybd;
	private static final int SIZE_OF_INPUT = 10;
	private static final int SIZE_OF_NEXTINT = 3;
	private static Polynomial[] polyList = new Polynomial[SIZE_OF_INPUT];
	 
}
