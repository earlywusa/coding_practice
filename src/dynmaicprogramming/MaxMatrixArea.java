package dynmaicprogramming;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxMatrixArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] inputMap = new int[][]
		{
			{1, 1, 0, 1},
			{0, 1, 0, 1},
			{1, 1, 0, 1},
			{0, 0, 1, 1}
		};
		
		/**
		 * Algorithm:
		 * for input:
		 * 0 0 1 1
		 * 0 1 0 1
		 * 1 1 0 1
		 * 1 1 0 1
		 * 
		 * cache:
		 * 0 0 1 4
		 * 0 3 0 3
		 * 2 2 0 2
		 * 1 1 0 1
		 * 
		 * for each row, starting from {0, 0}, initialize the cache with max area
		 * when row = 0;
		 * Starting from row = 1, add sum of from previous row. 
		 * Then a map with the max heights of the matrix are constructed. 
		 * iterating through the map, 
		 * 
		 * 
		 * dp histogram 
		 * H[3] 0 0 1 4 = 1*2 = 2
		 * H[2] 0 3 0 3 = 3*1 = 3
		 * H[1] 2 2 0 2 = 2*2 = 4
		 * H[0] 1 1 0 1 = 1*2 = 1
		 * for each width, 1-> row.length -1
		 * starting from x=0, -> x=row.length -1
		 * for H[1]
		 * 3|0 0 0 3
		 * 2|0 0 0
		 * 1|1 1
		 * 0|2 _ _ _
		 *   0 1 2 3
		 *   
		 *   
		 * if two arrays are used
		 * one is for previous lowest bar values
		 * one is for current lowest bar values
		 * in first step, store [2, 1, 0, 3] "max height" into current array
		 * in second step, make current array to previous array, store [1, 0, 0] to current array after comparison.
		 *  
		 */
		char[][] inputChar = new char[][]{
			{'1', '1', '0'},
			{'1', '1', '0'},
			{'1', '1', '0'},
			{'0', '0', '1'}
		};
		
//		inputChar = new char[][]{
//			{'1','1'},
//			{'1','1'}
//		};
		//solution(inputMap);
		int max = maximalRectangle(inputChar);
		System.out.println("max: " + max);
	}
	
	public static void solution(int[][] matrix){
		
		int[][] cache = new int[matrix.length][matrix[0].length];
		for(int y=0; y<matrix.length; y++){
			for(int x=0; x<matrix[0].length; x++){
				cache[y][x] = Integer.MIN_VALUE;
			}
		}
		
		for(int i = 0; i< matrix[0].length; i++){
			cache[0][i] = matrix[0][i];
		}
		
		for(int y = 1; y < matrix.length; y++){
			for(int x=0; x < matrix[0].length; x ++){
				if(matrix[y][x] == 1){
					cache[y][x]= matrix[y][x] + cache[y -1][x];
				}
				else
				{
					cache[y][x]= 0;
				}
				
			}
		}
		
		dump(cache);
		
		int max = 0;
		for(int y=0; y<cache.length; y++){
			int[] heightList = cache[y];
			max = Math.max(max, getMaxArea(heightList));
			System.out.println("max: " + max);
			
		}
		
	}
	
    public static int maximalRectangle(char[][] matrix) {
    	
    	
		int max = 0;
    	int[][] matrix_int = new int[matrix.length][matrix[0].length];
    	
    	for(int y = 0; y<matrix_int.length; y++){
    		for(int x =0; x<matrix_int[0].length; x++){
    			matrix_int[y][x] = Character.getNumericValue(matrix[y][x]);
    		}
    	}
    	
    	if(matrix_int.length == 1){
    		max=getMaxArea_x_array(matrix_int[0]);
    	}
    	else{
        	//dump(matrix_int);
        	
            int[][] cache = new int[matrix_int.length][matrix_int[0].length];
    		for(int y=0; y<matrix_int.length; y++){
    			for(int x=0; x<matrix_int[0].length; x++){
    				cache[y][x] = Integer.MIN_VALUE;
    			}
    		}
    		
    		for(int i = 0; i< matrix_int[0].length; i++){
    			cache[0][i] = matrix_int[0][i];
    		}
    		
    		for(int y = 1; y < matrix_int.length; y++){
    			for(int x=0; x < matrix_int[0].length; x ++){
    				if(matrix_int[y][x] == 1){
    					cache[y][x]= matrix_int[y][x] + cache[y -1][x];
    				}
    				else
    				{
    					cache[y][x]= 0;
    				}
    				
    			}
    		}
    		dump(cache);
    		

    		for(int y=0; y<cache.length; y++){
    			int[] heightList = cache[y];
    			max = Math.max(max, getMaxArea(heightList));
    			System.out.println("max: " + max);
    			
    		}
    	}

		return max;
    }
	public static int getMaxArea_x_array(int[] input){
		int maxArea = 0;
		int[] cache = new int[input.length];
		cache[0] = input[0];
		maxArea = input[0];
		for(int i = 1; i< input.length; i++){
			
			if(input[i] == 1){
				cache[i] = cache[i-1]+=1;
				maxArea = Math.max(cache[i], maxArea);
			}
			else
			{
				cache[i] = 0;
			}
		}
		
		
		return maxArea;
		
	}
	public static int getMaxArea(int[] input){
		System.out.println("input: " + Arrays.toString(input));
		int[] curArray = Arrays.copyOf(input, input.length);
		int[] preArray = new int[input.length];
		int maxArea = 0;
		for(int width=1; width<=input.length; width ++){
			for(int start=0; start + width < input.length+1; start++){
				int end=start+width - 1;
				
				if(width == 1){
					preArray[start] = input[start];
					maxArea=Math.max(maxArea, input[start]);
				}
				else
				{
					System.out.println("start: " + start + " end: " + end );
					System.out.println("compare: " + preArray[start] + " vs " + input[end] );
					curArray[end]=Math.min(preArray[end-1], input[end]);
					System.out.println("tmp max area: " + curArray[end] + " x " + width + " = " + curArray[end] * width);
					maxArea=Math.max(maxArea, curArray[end]*width);
					System.out.println("current maxArea: " + maxArea);
				}
			}
			//swap curArray and preArray
			int[] tmp = preArray;
			preArray = curArray;
			curArray = tmp;
		}

		return maxArea;
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
