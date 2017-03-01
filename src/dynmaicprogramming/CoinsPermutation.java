package dynamicProgramming;

import java.util.Arrays;

public class CoinsPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] choices = new int[]{1,2,3};
		int n = 4;
		int result = testNumOfCombinations(n, choices );
		System.out.println(result);
		result = solution(n);
		System.out.println(result);
	}
	
	public static int testNumOfCombinations(int n, int[] choices){
		int result = 0;
		int[] cache = new int[n+1];
		cache[0] = 1;
		for(int sum =1; sum <= n; sum ++){
			int total = 0;
			for(int index=0; index<choices.length; index++){
				if(sum >= choices[index]){
					int remain = sum - choices[index];
					total += cache[remain]; 
				}
			}
			cache[sum] = total;
		}
		result = cache[n];

		return result;
	}
	
	public static int solution(int n){
		int[] cache = new int[n+1];
		Arrays.fill(cache,  -1);
		return countWay(n, cache );
	}
	
	public static int countWay(int n, int[] cache){
		if(n<0){
			return 0;
		}
		else if(n==0)
		{
			return 1;
		}
		else if( cache[n] > -1){
			return cache[n];
		}
		else
		{
			cache[n] = countWay(n-1, cache) + countWay(n-2, cache) + countWay(n-3, cache);
			return cache[n];
		}
	}
	
	
}
