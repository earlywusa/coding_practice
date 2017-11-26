package math;

import java.util.Arrays;

/*
 * return all prime number smaller then a given limit
 */
public class Prime {

	public static void main(String[] args) {
		int[] primes = getPrimes(100);
		System.out.println(Arrays.toString(primes));
		
	}

	public static int[] getPrimes(int n){
		int[] cache = new int[n];
		cache[0] = 1; //initialize the 0 to be marked
		int totalCount = n-1; //count the invalid 0
		int p = 2;
		boolean hasNextP = true;
		int watchdog = 0;
		while(hasNextP && watchdog < 20){
			watchdog ++;
			int candidate = p*p;
			while(candidate < n){
				if(cache[candidate] != 1){
					cache[candidate] = 1;
					totalCount --;
				}
				candidate +=p;
			}
			//System.out.println("has done with candidate: " + candidate);
			hasNextP = false;
			for(int i = p+1; i< n; i++){
				if(cache[i] == 0){
					p = i;
					hasNextP = true;
					//System.out.println("next p:"  + p);
					break;
				}
			}
		}
//		System.out.println(Arrays.toString(cache));
//		System.out.println("Count: " + totalCount);
		int[] ret = new int[totalCount];
		int index = 0;
		for(int i = 0; i<n; i++){
			if(cache[i] == 0){
				ret[index++] = i;
			}
		}
		return ret;
	}
	
	public static boolean isPrime(int n){
		if(n<=0) return false;
		if(n == 1) return true;
		for(int i = 2; i*i<=n; i++){
			if(n%i == 0) return false;
		}
		return true;
	}
}
