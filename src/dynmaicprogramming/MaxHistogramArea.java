package dynmaicprogramming;

public class MaxHistogramArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heightArray = {5, 4, 2, 4, 2};
		//editorSolution(heightArray);
		mySolution(heightArray);
	}
	
	public static void editorSolution(int[] height){
	    int n = height.length;
	    int[][] dp = new int[n][n];        
	    int max = Integer.MIN_VALUE;

	    for(int width = 1; width <= n; width++){

	        for(int l = 0; l+width-1 < n; l++){

	            int r = l + width - 1;

	            if(width == 1){
	                dp[l][l] = height[l];
	                max = Math.max(max, dp[l][l]);
	            } else {                    
	                dp[l][r] = Math.min(dp[l][r-1], height[r]);
	                max = Math.max(max, dp[l][r] * width);
	            }                
	        }
	    }
	    System.out.println("MaxArea: " + max);
	}
	
	public static void mySolution(int[] heightArray){
		int[][] minHeightCache = new int[heightArray.length][heightArray.length];
		init(minHeightCache, 99);
		dump(minHeightCache);
		int maxArea=0;
		for(int width = 1; width<=heightArray.length; width ++){
			System.out.println("Width = " + width);
			for(int start=0; start+width-1<heightArray.length; start ++){
				int end = start + width -1;
				System.out.println("starting: " + start + " ending: " + end);
				
				if(width == 1){
					minHeightCache[start][start] = heightArray[start];
					maxArea = Math.max(heightArray[start],maxArea);
				}
				else{
					minHeightCache[start][end] = Math.min(minHeightCache[start][end-1], heightArray[end]);
					System.out.println("minimum height: " + minHeightCache[start][end]);
					maxArea = Math.max(minHeightCache[start][end] * width, maxArea);
				}

			}
		}
		dump(minHeightCache);
		System.out.println("Max Area: " + maxArea);
	}
	
	public static void init(int[][] matrix, int value){
		for(int i = 0; i< matrix.length; i++){
			for(int j = 0; j<matrix[0].length; j++){
				matrix[i][j] = value;
			}
		}
	}
	
	public static void dump(int[][] matrix){
		for(int y= matrix.length -1; y >=0; y--){
			for(int x = 0; x<matrix[0].length; x++){
				System.out.printf("%2d", matrix[y][x]); System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
