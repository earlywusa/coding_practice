package recursion;

public class Squrt {
	static int count = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double i = 100;
		double n = i/2;
		double error = 0.001;
		double r = binarySearch(i, n, error, i);
		System.out.println("result: " + r);
	}
	/*
	 * how to choose next test value
	 * 1) if n * n > target
	 * ie, target = 10, 5* 5 = 25 > 10;
	 * next check value could be 2.5, 
	 * 2.5 * 2.5 < 10;
	 * next check value should be 2.5 + (5-2.5)/2 = 3.75
	 * 3.75 * 3.75 > 10;
	 * next check value should be 3.75 - (3.75-2.5)/2 = 3.
	 */
	static double binarySearch(double input, double n, double error, double previousResult){
		if(count > 50) return -1;
		count ++;
		int r = doCompare(input, n, error);
		if(r == 0){
			return n;
		}
		else if(r == 1){
			double nextVal = n - Math.abs(previousResult - n)/2 ;
			System.out.println("search smaller: " + nextVal );
			return binarySearch(input, nextVal, error, n);
		}
		else{
			double nextVal = n + Math.abs(previousResult -n )/2;
			System.out.println("search bigger: " + nextVal );
			return binarySearch(input, nextVal, error, n);
		}
	}
	
	static int doCompare(double input, double n, double error){
		double nn = n*n;
		
		if(nn>input){
			if(nn-input < error) return 0;
			else return 1;
		}
		else if(nn < input){
			if(input - nn < error) return 0;
			else return -1;
		}
		else
		{
			return 0;
		}
	}
}
