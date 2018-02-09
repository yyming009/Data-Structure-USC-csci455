package lab7;

public class String1UpToN {
	
	public String string1UpToN(int n) {
        return RAppendUpTo("", 1, n);    // note: first argument is an empty string
	}

	private String RAppendUpTo(String strSoFar, int i, int n) {
	        if (n > i) {
	            strSoFar += (RAppendUpTo(strSoFar, i, n - 1) + " " + n);
	        }
	        if (n == i) {
	            strSoFar += (RAppendUpTo(strSoFar, i, n - 1) + n);
	        }
	        return strSoFar;
	}

}	
