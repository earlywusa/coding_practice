package math;

import java.util.Stack;

public class NumberComprass {

	public static void main(String[] args) {
		Long compressed = convert(1111114445555L);
		System.out.println("compressed: " + compressed);

	}

	public static Long convert(Long number){
		Stack<Long> result = new Stack<>();
		Long count = 0L ; Long oldDigit = -1L;
		while(number >= 0){
			System.out.println("\ncurrent number: " + number);
			Long rem = number %10;
			System.out.println("current rem: " + rem);
			if(rem == oldDigit){
				count ++;
				System.out.println("same as old: count: " + count);
			}else{
				if(oldDigit != -1L || number == 0){
					System.out.println("push count: " + count + " digit: " + oldDigit);
					
					result.push(oldDigit);
					result.push(count);
					if(number == 0){
						break;
					}
				}
				count = 1L;
				oldDigit = rem;
			}
			number = number /10;
		}
		Long ret = 0L;
		while(! result.isEmpty()){
			ret*=10;
			ret+=result.pop();
		}
		return ret;
	}
}
