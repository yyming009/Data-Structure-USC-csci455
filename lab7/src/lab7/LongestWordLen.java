 package lab7;

import java.util.Scanner;

public class LongestWordLen {
	
	public int longestWordLen(String words) {
        if (words.equals("")) {
            return 0;
        }
        int maxLength = 0, currentLength = 0;
        Scanner line = new Scanner(words);
        currentLength = line.next().length();
        if (!line.hasNext()) {
            return currentLength;
        }
        else {
            maxLength = longestWordLen(line.nextLine());
            return currentLength > maxLength ? currentLength : maxLength;
        }
	}
}