package sort;

public class SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] source = new int[]{0,5,3,2,11,1};
		
		printArray(source);
		
		sort(source);
		printArray(source);
		
	}
	/*
	 * for 1st item to the end.
	 * find the smallest value, and switch it with the beginning of the array
	 * 
	 */
	public static void sort(int[] source){
	
		for(int i = 0; i<source.length; i++){
			int min_index = i;
			for(int j=i; j<source.length; j++){
				if(source[j] < source[min_index]){
					min_index = j;
				}
			}
			if(i != min_index){
				swapInt(source, i , min_index);
			}
		}
	}
	/*
	 * swap without variable
	 * a=10, b=3
	 * a=10-3=7
	 * b=b+a=10
	 * a=b-a
	 */
	public static void swapInt(int[] source, int pos1, int pos2){
		int a = source[pos1];
		int b = source[pos2];	
		a=a-b;
		b=b+a;
		a=b-a;
		source[pos1] = a;
		source[pos2] = b;
	}
	
	public static void printArray(int[] array){
		for(int i = 0; i<array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
