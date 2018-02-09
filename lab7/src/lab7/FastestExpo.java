package lab7;

public class FastestExpo {
	
	public int fastExpon(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            return fastExpon(x * x, n / 2);
        }
        if (n % 2 == 1) {
            return x * fastExpon(x * x, (n - 1) / 2);
        }
        return -1;
}

}
