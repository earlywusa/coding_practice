package math;

public class IntegerPalindrome {
	public static void main(String[] args){
		int input = 11;
		
		System.out.println(validateIntegerPalin(input));
		
	}
	
	public static boolean validateIntegerPalin(int input){
		if(input <0) return false;
		int digiCount = 0;
		int result = input;
		while((result/=10) > 0){
			digiCount ++;
		}
		
		int hi = digiCount, low = 0;
		while(hi - low >= 0){
			System.out.println("high: " + hi + " low: " + low);
			int d1 = (input/(int)Math.pow(10, hi))%10;
			int d2 = (input/(int)Math.pow(10, low))%10;
			System.out.println("d1: " + d1 + " d2: " + d2);
			if( d1 != d2  ){
				return false;
			}
			hi--;
			low++;
		}
		return true;
	}
}
