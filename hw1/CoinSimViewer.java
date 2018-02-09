// Name: Yiming Yan
// USC NetID: 5552625298
// CS 455 PA1
// Spring 2017
import java.util.Scanner;
import javax.swing.JFrame;

public class CoinSimViewer {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setSize(800, 500);
		frame.setTitle("CoinSim");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Scanner keybd = new Scanner(System.in);
		System.out.print("Please enter number of trials: ");
		int numb = keybd.nextInt();
		
		while(numb < 0){
	          System.out.println("Number entered must be greater than 0.");
	          System.out.print("Please enter number of trials: ");
	          numb = keybd.nextInt();
	    }
		
		CoinTossSimulator simulator = new CoinTossSimulator();
		simulator.run(numb);
		CoinSimComponent component = new CoinSimComponent(simulator.getTwoHeads(), simulator.getTwoTails(), simulator.getHeadTails(), simulator.getNumTrials());
		
		frame.add(component);
		frame.setVisible(true);
	}
}
