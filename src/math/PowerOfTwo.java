package math;

public class PowerOfTwo {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		powerOfTwo(100);
		System.out.println();
		powerOfTwoo(100);
	}
	
	public static int powerOfTwo(int n){
		if(n<1) return 0;
		
		if (n == 1){
			System.out.println("1");
			return 1;
		}
		else{
			int prev = powerOfTwo(n/2);
			int curr = prev*2;
			System.out.println(curr);
			return curr;
		}
	}
	
	public static void powerOfTwoo(int n){
		int i = 1;
		
		while(i < n){
			System.out.println(i);
			i*=2;
		}
	}

}
