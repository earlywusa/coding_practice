package recursion;

public class RecursiveMultiplyDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int result = multiply(2, 3); System.out.println("Result:" + result);
		//int result = callRecursiveMultiply(2, 3); System.out.println("Result:" + result);
		int result = solution(2, 3); System.out.println("Result:" + result);
	}
	
	
	public static int multiply(int val, int n ){
		if (n == 1) return val;
		else
			return val + multiply(val, n-1);
	}
	
	public static int callRecursiveMultiply(int val, int n){
		return multiplyTailRecur(val, n-1, val);
	}
	
	public static int multiplyTailRecur(int val, int n, int result){
		if(n == 0){
			return result;
		}
		result += val;
		return multiplyTailRecur(val, n -1, result);
	}
	
	public static int solution(int a, int b){
		return getMinProduct(a, b);
	}
	
	public static int getMinProduct(int num1, int num2){
		if(num1 == 0) return 0;
		else if(num1 == 1) return num2;
		
		int s = num1 >> 1;
		int halfOfNum1 = getMinProduct(s, num2);
		
		if(num1 % 2 ==0){
			return halfOfNum1 + halfOfNum1 ;
		}
		else
		{
			return halfOfNum1 + halfOfNum1 + num2;
		}
	}
}
