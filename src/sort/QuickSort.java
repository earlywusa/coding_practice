package sort;

public class QuickSort {

	public static int limit = 0;
	public static void main(String[] arg)
	{
		int[] testA = {22,6,18,7,4,13};
		
		sort(testA, 0, testA.length-1);
		dump(testA);
	}
	
	public static void sort(int[] array, int low, int high)
	{
		
		if(low < high)
		{
			dump(array);
			int p = partition(array, low, high);
			sort(array, low, p-1);
			sort(array, p+1, high);
		}
	}
	
	public static int partition(int[] array, int low, int high)
	{
		if(limit > 100) return -1;
		limit ++;
		System.out.println("Start patition: " + " low : " + array[low] + " high: " + array[high]);
		int pivot = array[high];
		int i = low;
		for(int j = low; j<high; j++)
		{
			if(array[j] <= pivot){
				int tmp = array[j];
				System.out.println("swap: " + tmp + " -> " + array[i]);
				array[j] = array[i];
				array[i] = tmp;
				i ++;
			}
			else{
				System.out.println("passby: " + array[j]);
			}
		}
		System.out.println("end patition swap: " + array[i] + " -> " + array[high] + " i = " + i + " high = " + high);
		int tmp = array[i];
		array[i] = array[high];
		array[high] = tmp;
		
		return i;
	}
	
	public static void dump(int[] array){
		for(int i=0; i<array.length; i++)
		{
			System.out.print(" " + array[i]);
		}
		System.out.println();
	}
}
