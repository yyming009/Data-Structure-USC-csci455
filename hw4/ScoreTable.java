// Name: Yan Yiming
// USC NetID: yimingy
// CS 455 PA4
// Spring 2017

public class ScoreTable {
	
	private final static int CHAR = 26;
	private int[] point;
	private int score;
	
	public ScoreTable() {
		
		score = 0;
		
		point = new int[CHAR];
		for (int i = 0; i < CHAR; i++) {
			point[i] = 1;
		}
		point[3] = 2;
		point[6] = 2;
		
		int[] three = {1, 2,12,15};
		for (int i : three) {
			point[i] = 3;
		}
		
		int[] four = {5,7,21,22,24};
		for (int i : four) {
			point[i] = 4;
		}
		
		point[10] = 5;
		
		point[9] = 8;
		point[23] = 8;
		
		point[16] = 10;
		point[25] = 10;
		
	}
	
	/**
    * calculate the score and then get the score.
    */
	
	public int getScore(String s) {
		
		char base = 'a';
		int l = s.length();
		for (int i = 0; i < l; i++) {
			score += point[s.charAt(i) - base];
		}
		
		return score;
	}
}
