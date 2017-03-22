package matrix;

import tools.StringToMatrix;

public class KthLargestItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "[[1,2,3],[5,8,16]]"; int k = 2;
	
		int[][] matrix = StringToMatrix.convert(input);
		findKthLargest(matrix,k);
		findKthSmallest(matrix, k);

	}
	
	public static void findKthLargest(int[][] matrix, int k){
		int m = matrix.length-1;
		int n = matrix[0].length-1;
		
		int lo = matrix[0][0];
		int hi = matrix[m][n];
		
		while(lo < hi){
			int mid = lo + (hi-lo)/2;
			int count = isGreaterThan(matrix, mid);
			System.out.println("mid: " + mid + " count: " + count);
			//count is the number of items in the range is greater than mid value.
			//if count > k, means mid is too small, too many items are greater than or equal to mid
			//if count == k, we know we are close, we should always try to adjust the lower bound because mid may be equal to lower bound. 
			//if high is only one unit greater than lo, mid = x + 1/2 = x. lo == mid and never changed, hi is always one unit greater
			//infinite loop happened. 
			if(count < k){
				
				hi = mid;
			}
			else if(count == k){
				lo = mid + 1;
			}
			else{
				
				lo = mid +1 ;
			}
			System.out.println();
			System.out.println("new range: " + lo + " -> " + hi);
			
		}
		System.out.println("K: " + k + " value: " + lo);
	}
	
	public static void findKthSmallest(int[][] matrix, int k){
		int m = matrix.length-1;
		int n = matrix[0].length-1;
		
		int lo = matrix[0][0];
		int hi = matrix[m][n];
		
		while(lo < hi){
			int mid = lo + (hi-lo)/2;
			int count = isLessThan(matrix, mid);
			if(count < k){
				lo = mid +1;
			}
			else if(count == k ){
				hi = mid -1;
			}
			else{
				hi = mid -1 ;
			}
		}
		System.out.println("K: " + k + " value: " + lo);
	}
	
	private static int isLessThan(int[][] matrix, int mid){
		int count = 0;
		for(int col = 0; col<matrix.length; col++){
			for(int row = 0; row< matrix[0].length; row++){
				if(matrix[col][row] < mid){
					count ++;
				}
				else{
					break;
				}
			}
		}
		return count;
	}
	
	private static int isGreaterThan(int[][] matrix, int mid){
		int count = 0;
		
		for(int col = 0; col < matrix.length; col++){
			for(int row = matrix[0].length -1; row >=0 ; row--){
				System.out.println("test value: " + matrix[col][row] + " mid: " + mid);
				if(matrix[col][row] > mid){
					count++;
				}
				else{
					break;
				}
			}
		}
		return count;
	}
	
	

}
