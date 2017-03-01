package sort;

import java.util.Arrays;

public class SortedSearchNoSize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[200];
		for(int i = 0 ; i< 100; i++){
			a[i] = i+i;
		}
		for(int i = 100; i<200; i++){
			a[i] = -1;
		}
		System.out.println("a: " + Arrays.toString(a));
		int target = 50*2;
		System.out.println("index of target: " + doSearch(a, target)	);
	}
	
	public static int doSearch(int[] a, int target){
		int high = getSize(a);
		return bsc(a, target, 0, high);
	}
	
	public static int bsc(int[] a, int target, int low, int high){
		int mid = (low + high)/2;
		if(a[mid] == -1){
			
			return bsc(a, target, low, mid -1);
		}
		else{
			if(a[mid] >target){
				return bsc(a, target, low, mid -1);
			}
			else if (a[mid] < target){
				return bsc(a, target, mid+1, high);
			}
			else{
				return mid;
			}
		}
	}
	
	public static int getSize(int[] a ){
		int index = 1;
		
		while(a[index] != -1){
			index *= 2;
			if(a[index] == -1){
				System.out.println("found out of bound -1: " + index);
			}
		}
		
		return index;
	}
}
