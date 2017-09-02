package sort;

import java.util.Arrays;

public class MergeSort1 {
	static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{5,4,2,1,5,6};
		mergeSort(a, 0, a.length-1);
	}
	
	public static int[] mergeSort(int[] array, int low, int hi){
		//System.out.println("count " + count++  + " low: " + low + " hi: " + hi);
		if(count>20) System.exit(1);
		count++;
		dump(array, low, hi);
		int[] part1 = null;
		int[] part2 = null;
		if(low <hi){
			int mid = low + (hi-low)/2;
			System.out.println("mid: " + mid);
			System.out.println("partition part low: " + low + "," + mid); 
			part1 = mergeSort(array, low, mid);
			System.out.println("partition part high: " + (mid+1) + "," + hi); 
			part2 = mergeSort(array, mid+1, hi);
		}
		else if(low == hi){
			return new int[]{array[low]};
		}
		else{
			System.out.println("should not get here");
			part1 = new int[]{array[low]};
			part2 = new int[]{array[hi]};
		}
		
		int[] ret =  merge(part1, part2);
		System.out.println("ret: " + Arrays.toString(ret));
		return ret;
	}

	public static int[] merge(int[] a, int[] b){
		int ia = 0;
		int ib = 0;
		int[] ret = new int[a.length + b.length];
		int rc = 0;
		while(ia<a.length || ib<b.length){
			if(ia<a.length && ib<b.length){
				if(a[ia]<b[ib]){
					ret[rc++] = a[ia];
					ia++;
				}
				else{
					ret[rc++] = b[ib];
					ib++;
				}
			}
			else{
				if(ia >= a.length) {
					ret[rc++] = b[ib++];
				}
				else{
					ret[rc++] = a[ia++];
				}
			}
		}
		return ret;
	}
	
	public static void dump(int[] array, int low, int hi){
		for(int i = low; i<=hi; i++){
			System.out.print(array[i] + " " );
		}
		System.out.println();
	}
}
