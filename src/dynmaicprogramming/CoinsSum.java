package dynmaicprogramming;

public class CoinsSum {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 10;
		int[] coins = {1, 3, 5};
		int[] result = new int[sum+1];
		for(int i = 0; i<result.length; i++){
			result[i] = Integer.MAX_VALUE;
		}
		result[0] = 0;
		
		for(int i = 1; i<=sum; i++){
			for(int j = 0; j < coins.length; j ++){
				if(coins[j]<=i){
					int reminder = i - coins[j];
					result[i] = Math.min(result[reminder] + 1, result[i]);
				}
			}
		}
		
		System.out.println("sum = " + sum + " number of coin(1, 3, 5) needed: " + result[sum]);
		
		

	}

}
