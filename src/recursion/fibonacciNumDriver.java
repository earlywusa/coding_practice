package recursion;

import java.util.List;
import java.util.Vector;

public class fibonacciNumDriver {

	static int limit = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = getFabSumRecursive(5);
		System.out.println("result: " + result);
		
		result = getFabSumRecursiveDp(4, 1);
		System.out.println("result: " + result);
	}

	public static String test(String in, int n)
	{
		String ret = "";
		System.out.println("length of in: " + in.length());
		if(in.length() < n)
		{
			int diff = n - in.length();
			for(int i = 0; i< diff; i++)
			{
				System.out.println("append space");
				in = " " + in;
			}
		}
		
		return in;
	}
	
	public static int getFabSumRecursive(int n){
		if(n == 0) return 0;
		if(n == 1) return 1;
		return n+ getFabSumRecursive(n-1);
	}
	
	public static int getFabSumRecursiveDp(int n, int result){
		if(n == 1) return result;
		result += n;
		return getFabSumRecursiveDp(n-1, result);
	}
	
	public static int getFabSum(int n)
	{
		if(limit > 100) return 0;
		limit ++;
		if(n < 0) return 0;
		if(n == 1) return 1;
		int result = getFabSum(n-1) + getFabSum(n-2);
		return result;
	}
}
