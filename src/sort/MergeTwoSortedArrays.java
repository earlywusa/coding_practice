package sort;

import java.util.Arrays;

public class MergeTwoSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrayA = new int[]{2,4,5};
		int[] arrayB = new int[]{3,7};
		arrayA = merge(arrayA, arrayB);
		System.out.println(Arrays.toString(arrayA));
	}
	
	public static int[] merge(int[] arrayA, int[] arrayB){
		int[] newA = new int[arrayA.length + arrayB.length];
		int lastIndex = arrayA.length + arrayB.length -1;
		int lastIndexA = arrayA.length -1;
		int lastIndexB = arrayB.length -1;
		for(int i = 0; i< arrayA.length; i++){
			newA[i] = arrayA[i];
		}
		arrayA= newA;
		System.out.println("new arrayA : " + Arrays.toString(arrayA));
		
		//quick check:  A=[1,2] B=[2,4]
		//final: A=[1,2,2,4] lastIndex = 3;
		while(lastIndex >=0){
			if(lastIndexA >= 0 && lastIndexB >=0){
				if(arrayA[lastIndexA] >= arrayB[lastIndexB]){
					System.out.println("set index: " + lastIndex + " to be arrayA at index: " + lastIndexA + " value: " + arrayA[lastIndexA]);
					arrayA[lastIndex] = arrayA[lastIndexA];
					System.out.println("arrayA : " + Arrays.toString(arrayA));
					lastIndexA--;
				}
				else{
					System.out.println("set index: " + lastIndex + " to be arrayB at index: " + lastIndexB + " value: " + arrayB[lastIndexB]);
					arrayA[lastIndex] = arrayB[lastIndexB];
					System.out.println("arrayA : " + Arrays.toString(arrayA));
					lastIndexB--;
				}
			}
			else{
				if(lastIndexB >=0){
					arrayA[lastIndex] = arrayB[lastIndexB];
					lastIndexB--;
				}
			}

			lastIndex --;
		}
		return arrayA;
	}
}
