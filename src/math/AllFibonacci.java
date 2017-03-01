package math;

public class AllFibonacci {

	static int  count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int[] memo = new int[n+1];
		//allFib(n, memo);
		allFib(n);
		System.out.println("count: " + count);
	}
	
	public static int fib(int n, int[] memo){
		if(n <= 0) return 0;
		if(n == 1) return 1;
		if(memo[n] != 0) return memo[n]; 
		count ++;
		memo[n] = fib(n-1, memo) + fib(n-2, memo);
		return memo[n]; 
	}
	
	public static void allFib(int num, int[] memo){
		for(int i = 0; i<num; i++){
			System.out.println(fib(i, memo));
		}
	}
	
	public static int fib(int n){
		if(n <= 0) return 0;
		if(n == 1) return 1;
		count ++;
		return fib(n-1) + fib(n-2);
	}
	
	public static void allFib(int num){
		for(int i = 0; i<num; i++){
			System.out.println(fib(i));
		}
	}

}
