package math;

public class Swap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a = 5;
		Integer b = 3;
		System.out.println(" a " + a + " b " + b);
		swapXor(a, b);
		
	}
	
	public static void swapXor(Integer a, Integer b){
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(" a " + a + " b " + b);
	}

}
