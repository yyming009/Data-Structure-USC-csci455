// Name: Yiming Yan
// USC NetID: 5552625298
// CS 455 PA1
// Spring 2017

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.lang.Math;


/**
	define the characteristics of each bar

	@param TwoHead_units  the times that both of two coins show in heads
	@param TwoTail_units  the times that both of two coins show in tails
	@param HeadTail_units  the times that one coin shows in head while the other shows in tail
	@param BarWidth  width of the bar
	@param TwoHead_x  horizontal location of bar with two heads
	@param TwoTail_x  horizontal location of bar with two tails
	@param HeadTail_x  horizontal location of bar with one head and one tail
	@param TwoHead_y  vertical location of bar with two heads
	@param TwoTail_y  vertical location of bar with two tails
	@param HeadTail_y  vertical location of bar with one head and one tail
	@param numb  total times of simulation
	@param scale  how many pixels per application unit
*/

public class CoinSimComponent extends JComponent {
	
	private int TwoHead_units;
	private int TwoTail_units;
	private int HeadTail_units;
	private int BarWidth;
	private int TwoHead_x;
	private int TwoHead_y;
	private int TwoTail_x;
	private int TwoTail_y;
	private int HeadTail_x;
	private int HeadTail_y;	
	private int numb;
	private double scale;
	
	/**
    	construct the CoinSimComponent that get each times of simulations
	 */
	
	public CoinSimComponent(int TwoHead_units, int TwoTail_units, int HeadTail_units, int numTrials) {
		numb = numTrials;
		this.TwoHead_units= TwoHead_units;
		this.TwoTail_units= TwoTail_units;
		this.HeadTail_units= HeadTail_units;
	}
	
	/**
    	define the location of each bar
    	define the information of each bar label
    	draw each bar according to the statistic passed
	 */
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		
		int TwoHead_percent = (int)Math.round(((double)TwoHead_units / (double)numb) * 100);
		int TwoTail_percent = (int)Math.round(((double)TwoTail_units / (double)numb) * 100);
		int HeadTail_percent = (int)Math.round(((double)HeadTail_units / (double)numb) * 100);
		String TwoHead_label = "Two Heads: " + TwoHead_units + "(" + TwoHead_percent + "%)";
		String TwoTail_label = "Two Heads: " + TwoTail_units + "(" + TwoTail_percent + "%)";
		String HeadTail_label = "A Head and a Tail: " + HeadTail_units + "(" + HeadTail_percent + "%)";
		
		BarWidth = (int) (getWidth() * 0.1);
		scale = ((double)getHeight())/((double)numb);
		
		TwoHead_x = (int) (getWidth() * 0.20);
		TwoTail_x = (int) (getWidth() * 0.45);
		HeadTail_x = (int) (getWidth() * 0.70);
		TwoHead_y = (int) (getHeight() - TwoHead_units * scale + 20);
		TwoTail_y = (int) (getHeight() - TwoTail_units * scale + 20);
		HeadTail_y = (int) (getHeight() - HeadTail_units * scale + 20);

		Bar twohead = new Bar(TwoHead_x,TwoHead_y,BarWidth,TwoHead_units,scale,Color.RED,TwoHead_label);
		Bar twotail = new Bar(TwoTail_x,TwoTail_y,BarWidth,TwoTail_units,scale,Color.BLUE,TwoTail_label);
		Bar headtail = new Bar(HeadTail_x,HeadTail_y,BarWidth,HeadTail_units,scale,Color.GREEN,HeadTail_label);
		
		twohead.draw(g2);
		twotail.draw(g2);
		headtail.draw(g2);
	}
}
