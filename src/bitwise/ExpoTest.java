package bitwise;

public class ExpoTest {
	public static int  count = 0;
	public static void main(String[] args) {
		double x = 2.0;
		int y = 5;
		
		System.out.println("sum: " + diyPower(x, y) + " answer: " + Math.pow(x, (double)y) + " count: " + count);
	}

	public static double diyPower(double x, int y) {
		System.out.println("do power for " + x + " to the power: " + y);
		count ++;
		if(y==0) {
			
			return 1;
		}
		if(y%2 == 0) {
			return diyPower(x, y/2) * diyPower(x,y/2);
		}
		else {
			return x*diyPower(x, y/2) * diyPower(x, y/2);
		}
	}
	
	public static double solutionPower(double x, int y) {
		System.out.println("sol power: " + x + " to the power of: " + y);
		double res = 1;
		while(y != 0) {
			if((y & 1) == 1) {
				res *= x;
				
			}
			x*=x;
			y >>>=1;
		}
		return res;
	}
	
	
}
