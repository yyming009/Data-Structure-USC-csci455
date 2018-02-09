// Name: Yan Yiming
// USC loginid: yimingy
// CS 455 PA3
// Spring 2017

import java.util.LinkedList;


/**
   Maze class

   Stores information about a maze and can find a path through the maze
   (if there is one).
   
   Assumptions about structure of the maze, as given in mazeData, startLoc, and endLoc
   (parameters to constructor), and the path:
     -- no outer walls given in mazeData -- search assumes there is a virtual 
        border around the maze (i.e., the maze path can't go outside of the maze
        boundaries)
     -- start location for a path is maze coordinate startLoc
     -- exit location is maze coordinate exitLoc
     -- mazeData input is a 2D array of booleans, where true means there is a wall
        at that location, and false means there isn't (see public FREE / WALL 
        constants below) 
     -- in mazeData the first index indicates the row. e.g., mazeData[row][col]
     -- only travel in 4 compass directions (no diagonal paths)
     -- can't travel through walls

 */

public class Maze {
   
   public static final boolean FREE = false;
   public static final boolean WALL = true;
   
   public static final int DIRECTION_NUMB  = 4;
   public static final int DIRECTION_LEFT = 0;
   public static final int DIRECTION_UP = 1;
   public static final int DIRECTION_RIGHT = 2;
   public static final int DIRECTION_DOWN = 3;
   //Using the numbers to represent the four different directions.
   
   private int startRow;
   private int startCol;
   //record the start point in phantom condition.
   
   private int endRow;
   private int endCol;
   //record the end point in phantom condition.
   
   private boolean[][] maze_p;
   //make a new array with phantom to replace the mazeData.
   
   private int rows;
   //including the number of the rows of maze data and the two phantom rows in top and bottom respectively.
   
   private int columns; 
   //including the number of the columns of maze data and the two phantom columns in left and right respectively;
   
   private boolean[][] isVisited;
   //to record the whether the cell has been visited to avoid cycle.
   
   private boolean searchResult;
   //return true if there is a way from start to end.
   
   private LinkedList<MazeCoord> path;
   //store the path from the start to the end of maze.
   
   private boolean runTimes;
   //to keep the same result when press more than one time.

   /**
      Constructs a maze.
      @param mazeData the maze to search.  See general Maze comments above for what
      goes in this array.
      @param startLoc the location in maze to start the search (not necessarily on an edge)
      @param exitLoc the "exit" location of the maze (not necessarily on an edge)
      PRE: 0 <= startLoc.getRow() < mazeData.length and 0 <= startLoc.getCol() < mazeData[0].length
         and 0 <= endLoc.getRow() < mazeData.length and 0 <= endLoc.getCol() < mazeData[0].length

    */
   
   /**
   	  the phantom rows and columns should always be walled, to avoid searching beyond the border.
   	  PRE: for(int i=0; i<colums; i++) {maze_p[0][i] = WALL; maze_[rows-1][i] = WALL;}
   	  	   for(int j=0; j<rows; j++) {maze_p[j][0] = WALL; maze_[j][columns-1] = WALL;}
   */
   public Maze(boolean[][] mazeData, MazeCoord startLoc, MazeCoord exitLoc) {
	   
	   rows = mazeData.length + 2;
	   columns = mazeData[0].length + 2;
	   maze_p = new boolean[rows][columns];
	   isVisited = new boolean[rows][columns];
	   
	   for(int i=0; i<rows; i++) {
		   for(int j=0; j<columns; j++) {
			   maze_p[i][j] = WALL;
			   isVisited[i][j] = false;
		   }
	   }
	   
	   for(int i=0; i<rows-2; i++) {
		   for(int j=0; j<columns-2; j++) {
			   maze_p[i+1][j+1] = mazeData[i][j];
		   }
	   }
	   
	   searchResult = false;
	   path = new LinkedList<MazeCoord>();
	   
	   startRow = startLoc.getRow() + 1; 
	   startCol = startLoc.getCol() + 1;
	   
	   endRow = exitLoc.getRow() + 1;
	   endCol = exitLoc.getCol() + 1;
	   
	   runTimes = true;
   }


   /**
      Returns the number of rows in the maze
      @return number of rows
   */
   public int numRows() {
      return rows - 2;
   }

   
   /**
      Returns the number of columns in the maze
      @return number of columns
   */   
   public int numCols() {
      return columns - 2; 
   } 
 
   
   /**
      Returns true iff there is a wall at this location
      @param loc the location in maze coordinates
      @return whether there is a wall here
      PRE: 0 <= loc.getRow() < numRows() and 0 <= loc.getCol() < numCols()
   */
   public boolean hasWallAt(MazeCoord loc) {
      return maze_p[loc.getRow() + 1][loc.getCol() + 1];
   }
   
   /**
	   Returns true iff this location is visited;
	   @param loc the location in maze coordinates
	   @return whether the location was visited
	   PRE: 0 <= loc.getRow() < numRows() and 0 <= loc.getCol() < numCols()
    */
   public boolean hasVisited(MazeCoord loc) {
	   return isVisited[loc.getRow() + 1][loc.getCol() + 1];
   }

   /**
      Returns the entry location of this maze.
    */
   public MazeCoord getEntryLoc() {
	   return new MazeCoord(startRow - 1, startCol - 1);
   }
   
   
   /**
     Returns the exit location of this maze.
   */
   public MazeCoord getExitLoc() {
      return new MazeCoord(endRow - 1, endCol - 1);
   }

   
   /**
      Returns the path through the maze. First element is start location, and
      last element is exit location.  If there was not path, or if this is called
      before a call to search, returns empty list.

      @return the maze path
    */
   public LinkedList<MazeCoord> getPath() {
	  if(path.size() == 0) {
		  return null;
	  }
      return path; 

   }


   /**
      Find a path from start location to the exit location (see Maze
      constructor parameters, startLoc and exitLoc) if there is one.
      Client can access the path found via getPath method.

      @return whether a path was found.
    */
   public boolean search()  {
	  if(runTimes != false) {
		  searchResult = helperRoute(getEntryLoc());
		  runTimes = false;
	  }
	  
	  return searchResult;
   }
   
   private boolean helperRoute(MazeCoord loc) {
	   
	  if(hasWallAt(loc)) {
		  System.out.println("DEBUG: find the wall at " + loc.getRow() + ", " + loc.getCol());
		  return false;
	  }
	  
	  if(hasVisited(loc)) {
		  System.out.println("DEBUG: Already visited at " + loc.getRow() + ", " + loc.getCol());
		  return false;
	  }
	  
	  if(loc.equals(getExitLoc())) {
		  return true;
	  }
	  
	  //below is the recursive part
	  isVisited[loc.getRow() + 1][loc.getCol() + 1] = true;
	  for(int curDir = DIRECTION_LEFT; curDir < DIRECTION_NUMB; curDir++) {
		  MazeCoord nextCoord;
		  
		  if(curDir == DIRECTION_LEFT){
			  nextCoord = new MazeCoord(loc.getRow(), loc.getCol() - 1);
		  }else if(curDir == DIRECTION_UP) {
			  nextCoord = new MazeCoord(loc.getRow() - 1, loc.getCol());
		  }else if(curDir == DIRECTION_RIGHT) {
			  nextCoord = new MazeCoord(loc.getRow(), loc.getCol() + 1);
		  }else if(curDir == DIRECTION_DOWN) {
			  nextCoord = new MazeCoord(loc.getRow() + 1, loc.getCol());
		  }else {
			  return false;
		  }
		  
		  //at every coordinate search every direction until return true
		  if(helperRoute(nextCoord)) {
			  path.addFirst(new MazeCoord(nextCoord.getRow(), nextCoord.getCol()));
			  return true;
		  } 
	  }
	  
	  System.out.println("DEBUG: No path found!");
	  return false;	  
   }

}
