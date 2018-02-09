// Name: Yiming Yan
// USC NetID: 5552625298
// CS 455 PA1
// Spring 2017
import java.util.Random;
import java.util.Scanner;


/**
 * class CoinTossSimulator
 * 
 * Simulates trials of tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
public class CoinTossSimulator {
	
	private int TwoHeads;
	private int TwoTails;
	private int HeadTails;
	private int numTrials;
	private int result;
	private Random generator;

   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
	   numTrials = 0;
	   generator = new Random();
   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this
      without a reset() between them add these trials to the simulation
      already completed.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numofTrials) {
	   
	   for(int i=0; i<numofTrials; i++) {
		   result = generator.nextInt(2) + generator.nextInt(2);
		   if(result == 0){
			   TwoHeads++;
		   }else if(result == 2){
			   TwoTails++;
		   }else {
			   HeadTails++;
		   }
	   }
	   
	   numTrials = numTrials + numofTrials;  
   }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
       return numTrials; 
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return TwoHeads; 
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return TwoTails;
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return HeadTails;
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
	   numTrials = 0;
	   TwoHeads = 0;
	   TwoTails = 0;
	   HeadTails = 0;
   }

}
