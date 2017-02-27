package sort;

import java.util.Arrays;

public class QuickSort {

	public static void sort(int[] a){
		quickSort(0, a.length-1, a);
	}
	
	public static void quickSort(int low, int hi, int[] array){
		if(low < hi){
			int p = patition(low, hi, array);
			quickSort(low, p-1, array);
			quickSort(p+1, hi, array);
		}

	}
	
	public static int patition(int start, int end, int[] a){
		int p = end;
		int i = start;
		for(int j = start; j<end; j++){
			if(a[j] < a[p]){
				swap(i, j, a);
				i++;
			}
		}
		swap(i,p,a);
		System.out.println("return " + i);
		return i;
	}
	
	private static void swap(int i, int j, int[] arr){
		if(arr[i] != arr[j]){
			System.out.println("swap: " + arr[i] + " " + arr[j]);
			arr[i] = arr[i] ^ arr[j];
			arr[j] = arr[i] ^ arr[j];
			arr[i] = arr[i] ^ arr[j];
			System.out.println("swapped: " + arr[i] + " " + arr[j]);
		}
	}
//	private static void swap(int i, int j, int[] arr){
//		System.out.println("swap: " + arr[i] + " " + arr[j]);
//		int tmpv = arr[i];
//		arr[i] = arr[j];
//		arr[j] = tmpv;
//	}
	
	public static void main(String[] args){
		int[] input = new int[]{10,2,3,6,6,7};
		
		sort(input);
		
		System.out.println(Arrays.toString(input));
	}
	
}
