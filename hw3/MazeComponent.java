// Name: Yan Yiming	
// USC loginid: yimingy
// CS 455 PA3
// Spring 2017

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.JComponent;

/**
   MazeComponent class
   
   A component that displays the maze and path through it if one has been found.
*/
public class MazeComponent extends JComponent
{
	
   private static final int START_X = 10; // top left of corner of maze in frame
   private static final int START_Y = 10;
   private static final int BOX_WIDTH = 20;  // width and height of one maze "location"
   private static final int BOX_HEIGHT = 20;
   private static final int INSET = 2;  
                    // how much smaller on each side to make entry/exit inner box
   private Maze maze;

   
   /**
      Constructs the component.
      @param maze   the maze to display
   */
   public MazeComponent(Maze maze) {   
      this.maze = maze;
   }

   
   /**
     Draws the current state of maze including the path through it if one has
     been found.
     @param g the graphics context
   */
   public void paintComponent(Graphics g) {
	   
	   Graphics2D g2 = (Graphics2D) g;
	   int rows = maze.numRows();
	   int columns = maze.numCols();
	   
	   //Draw all cells with MazeCoord in every cell with colors.
	   for(int i=0; i<rows; i++) {
		   for(int j=0; j<columns; j++) {
			   Rectangle2D cell = new Rectangle2D.Double(START_X + j * BOX_WIDTH, START_Y + i * BOX_HEIGHT, BOX_WIDTH, BOX_HEIGHT);
			   MazeCoord everyCell = new MazeCoord(i, j);
			   g2.setPaint(maze.hasWallAt(everyCell) ? Color.BLACK : Color.WHITE);
			   g2.fill(cell);
		   }
	   }
	   
	   //Draw the ontline of the maze graph.
	   g2.setPaint(Color.BLACK);
	   Rectangle2D outerBox = new Rectangle2D.Double(START_X, START_Y, BOX_WIDTH * columns, BOX_HEIGHT * rows);
	   g2.draw(outerBox);
	   
	   //Draw the entry cell with color yellow.
	   MazeCoord startCell = maze.getEntryLoc();
	   Rectangle2D entryCell = new Rectangle2D.Double(START_X + startCell.getCol() * BOX_WIDTH + INSET, START_Y + startCell.getRow() * BOX_HEIGHT + INSET, BOX_WIDTH - 2 * INSET, BOX_HEIGHT - 2 * INSET);
	   g2.setPaint(Color.YELLOW);
	   g2.fill(entryCell);
	   
	   //Draw the end cell with color green.
	   MazeCoord endCell = maze.getExitLoc();
	   Rectangle2D exitCell = new Rectangle2D.Double(START_X + endCell.getCol() * BOX_WIDTH + INSET, START_Y + endCell.getRow() * BOX_HEIGHT + INSET, BOX_WIDTH - 2 * INSET, BOX_HEIGHT - 2 * INSET);
	   g2.setPaint(Color.GREEN);
	   g2.fill(exitCell);
	   
	   //Draw the route line with color blue.
	   LinkedList<MazeCoord> thePath = maze.getPath();
	   if(thePath != null) {
		   ListIterator<MazeCoord> iterator = thePath.listIterator();
		   
		   g2.setPaint(Color.BLUE);
		   MazeCoord currentCoord = maze.getEntryLoc();
		   MazeCoord nextCoord;
		   
		   while(iterator.hasNext()) {
			   nextCoord = iterator.next();
			   Line2D lineBetweenPath = new Line2D.Double(START_X + currentCoord.getCol() * BOX_WIDTH + 0.5 * BOX_WIDTH, START_Y + currentCoord.getRow() * BOX_HEIGHT + 0.5 * BOX_HEIGHT, START_X + nextCoord.getCol() * BOX_WIDTH + 0.5 * BOX_WIDTH, START_Y + nextCoord.getRow() * BOX_HEIGHT + 0.5 * BOX_HEIGHT);
			   g2.draw(lineBetweenPath);
			   currentCoord = nextCoord;
		   }
		   
	   }
	   
	   
	   
	   
	   
   }
   
}



