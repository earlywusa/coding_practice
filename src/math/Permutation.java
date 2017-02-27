package math;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testPermutation();
//		int[] srcArray = new int[]{3,2};
//		int[] newArray = new int[srcArray.length + 1];
//		insertToArray(1, srcArray, newArray, 2);
//		System.out.println("new array: " + Arrays.toString(newArray));
	}
	
	public static void testPermutation(){
		List<int[]> initContainer = new LinkedList<int[]>();
		int[] array = new int[1];
		int n = 3;
		array[0] = n;
		initContainer.add(array);
		List<int[]> result = FactorialPermutation(initContainer, n-1);
		for(int[] tmpArray : result){
			System.out.println(Arrays.toString(tmpArray));
		}
	}
	
	public static List<int[]> FactorialPermutation(List<int[]> container, int currentNum){
		if(currentNum <= 0){
			return container;
		}
		else
		{
			List<int[]> newContainer = new LinkedList<int[]>();
			for(int[] array : container){
				for(int i = 0; i<= array.length; i ++ ){
					int[] newArray= new int[array.length + 1];
					insertToArray(currentNum, array, newArray, i);
					newContainer.add(newArray);
				}
			}
			return FactorialPermutation(newContainer, currentNum -1);
		}
	}
	
	public static void insertToArray(int value, int[] target, int[] newArray, int position){
		if(target!= null && newArray != null && (newArray.length > target.length)){
			System.arraycopy(target, 0, newArray, 0, position);
			newArray[position]=value;
			System.arraycopy(target, position, newArray, position+1, target.length-position);
			
		}
	}
}
