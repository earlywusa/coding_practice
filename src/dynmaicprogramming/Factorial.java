package dynmaicprogramming;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(4, 1));
	}
	
	public static int factorial(int n, int result){
		if(n == 1){
			return result;
		}
		else
		{
			return factorial(n-1, n* result);
		}
	}
}
