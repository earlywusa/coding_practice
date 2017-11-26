package array;

import java.util.PriorityQueue;

public class BscInTwoDArray {

	public BscInTwoDArray(){
		int m = 3;
		int n = 3;
		int[][] matrix = new int[m][n];
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;

		findMid(matrix, new Coordinate(0,0), new Coordinate(0,2));
		PriorityQueue pq = new PriorityQueue();
		//System.arraycopy(src, srcPos, dest, destPos, length);
	}
	
	
	public Coordinate findMid(int[][] matrix, Coordinate low, Coordinate high){
		Coordinate mid = null;
		int m = matrix.length;
		int n = matrix[0].length;
		int col_count = 0;
		int row_count = 0;
		if(low.compareTo(high) == -1){
			col_count = high.c - low.c -1;
			int low_r_count = n -1 -low.r;
			int high_r_count = high.r;
			int total = low_r_count + high_r_count + col_count*n ;
			System.out.println("total = " + total);
			
		}else if(low.c == high.c){
			if(high.r > low.r){
				int total = high.r - low.r;
				System.out.println("same row: total:" + total);
			}
		}
		else{
			System.out.println("error");
		}
		
		return mid;
	}
	

	
	
	
	
	private class Coordinate implements Comparable{
		public int c = 0;
		public int r = 0;
		
		public Coordinate(int c, int r){
			this.c = c;
			this.r = r;
		}

		@Override
		public int compareTo(Object o) {
			Coordinate b = (Coordinate)o;
			
			if(this.c > b.c){
				return 1;
			}else if(this.c< b.c){
				return -1;
			}else{
				if(this.r < b.r){
					return -1;
				}else if(this.r > b.r){
					return 1;
				}
				else{
					return 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BscInTwoDArray i = new BscInTwoDArray();
	}

}
