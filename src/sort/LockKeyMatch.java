package sort;

public class LockKeyMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] locks = new char[]{'!','@','#','$'};
		char[] keys = new char[]{'#','@','$','!'};
		
		printString(locks);
		printString(keys);
		sort(locks, keys, 0, keys.length -1);
		
		printString(locks);
		printString(keys);
	}
	
	public static void sort(char[] locks, char[] keys, int low, int high){
		if(low<high){
			int lockpos = partition_with_pivot(locks, low, high, keys[high]);
			int keypos = partition_with_pivot(keys, low, high, locks[lockpos]);
			System.out.println("lockpos: " + lockpos + " keypos: " + keypos);
			
			sort(locks, keys, low, lockpos-1);
			sort(locks, keys, lockpos+1, high);
		}
		
	}
	
	public static int partition(char[] array, int low, int high, char pivot){
		int i = low;
		char v_pivot = pivot;
		System.out.println("pivot value: " + v_pivot + " value " + Integer.toString(v_pivot));
		for(int j = low; j<=high; j++){
			if(array[j] < v_pivot){
				System.out.println("call swap: " + array[j] + " " + array[i]);
				swap(j, i, array);
				i++;
			}
		}

		return i;
	}
	
	public static int partition_with_pivot(char[] arr, int low, int high, char pivot){
		int i = low;
		for(int j = low; j<high; j++){
			if(arr[j] < pivot){
				swap(i,j,arr);
				i++;
			}
			else if(arr[j] == pivot){
				swap(j, high, arr);
				j--;
			}
		}
		swap(i,high, arr);
		return i;
	}
	
	
	public static void swap(int i, int j, char[] arr){
		if(arr[i] != arr[j]){
			char tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
	}
	
	public static void printString(char[] array){
		for(char c : array){
			System.out.print(c + "=" + (int)c + " ");
		}
		System.out.println();
	}

}
