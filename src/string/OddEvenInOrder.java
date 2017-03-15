package string;

import java.util.Arrays;

public class OddEvenInOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{2,3,3,5,4,5,8,6,7};
		sort(a);
		System.out.println(Arrays.toString(a));
	}

	public static void sort(int[] a){
		int n = a.length;
		int nextEven = n/2;
		int nextOdd = 0;
		
		int index = 0;
		while(index<=n/2){
			int cv = a[index];
			if(isEven(cv)){
				swap(a, index, nextEven);
				nextEven++;
			}
			else{
				swap(a, index, nextOdd);
				nextOdd++;
			}
			index++;
		}
	}
	
	public static boolean isEven(int n){
		return n%2==0;
	}
	
	public static void swap(int[] a, int ia, int ib){
		int tmp = a[ia];
		a[ia] = a[ib];
		a[ib] = tmp;
	}
}
