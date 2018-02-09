	/**
	   A cash register totals up sales and computes change due.

	   Version for CS 455 lab 3.  Modified from version from Big Java, 4th
	   ed.  Note: in the 5th edition of the textbook the code is virtually
	   the same except that the method called enterPayment here, is called
	   receivePayment in the 5th edition.

	   Changes [made by CMB]:

	     Added getTotal() accessor function.
	     Made constants private.

	   Ex:
	   CashReg register = new CashReg();
	   register.recordPurchase(0.59);  // ring something up
	   register.recordPurchase(1.99);  // ring up another item
	   register.recordPurchase(5.0);   // ring up a third item
	   double tot = register.getTotal();    // total of purchases so far: 7.58
	   register.enterPayment(10,0,0,0,0);  // customer pays with a 10
	   int change = register.giveChange();  // compute change owed: 2.42
	                                        // and zeroes out register

	   register.recordPurchase(1.0);  // now we start ringing up someone else . . .

	*/
public class CashReg {

	   public static final int DOLLAR_VALUE = 100;
	   public static final int QUARTER_VALUE = 25;
	   public static final int DIME_VALUE = 10;
	   public static final int NICKEL_VALUE = 5;
	   public static final int PENNY_VALUE = 1;

	   private int purchase;
	   private int payment;

	   /**
	      Constructs a cash register with no money in it.
	   */
	   public CashReg()
	   {
	      purchase = 0;
	      payment = 0;
	   }

	   /**
	      Records the purchase price of an item.
	      @param amount the price of the purchased item
	   */
	   public void recordPurchase(double amount)
	   {
	      purchase = purchase + (int)(Math.round(amount*100));
	   }
	   
	   /**
	      Gets total of all purchases made.
	   */
	    public double getTotal(){
	    	double b = ((double)purchase)/100;
	       return b;
	    }; 

	   /**
	      Enters the payment received from the customer.
	      @param dollars the number of dollars in the payment
	      @param quarters the number of quarters in the payment
	      @param dimes the number of dimes in the payment
	      @param nickels the number of nickels in the payment
	      @param pennies the number of pennies in the payment
	   */
	   public void enterPayment(Change change){
	      payment = change.totalValue();
	   }
	   
	   /**
	      Computes the change due and resets the machine for the next customer.
	      @return the change due to the customer
	   */
	   public Change transfer(double a) {
		   return new Change((int)(a/100), (int)((a%100)/25), (int)((a%100%25)/10), (int)((a%100%25%10)/5), (int)((a%100%25%10%5)/1) );
	   }
	   
	   public Change giveChange()
	   {
	      int final_change = (payment - purchase);
	      purchase = 0;
	      payment = 0;
	      return transfer(final_change);
	   }
	}
