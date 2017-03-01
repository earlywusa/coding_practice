package sort;

public class SearcInRotatedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		System.out.println("search result: " + search(input, 5));
	}
	
	public static int search(int[] a, int target){
		int indexOfMin = getMinIndex(a);//wrong thinking. log(n) guaranteed. bsc becomes pointless. 
		if(target == a[indexOfMin]) return indexOfMin;
		
		else if(target > a[indexOfMin] && target < a[a.length -1]){
			return bsearch(a, target, indexOfMin, a.length -1);
		}
		else{
			return bsearch(a, target, 0, indexOfMin -1);
		}
		
	}
	
	public static int bsearch(int[] a, int target, int low, int heigh){
		int m = (low+heigh)/2;
		if(target > a[m]){
			return bsearch(a, target, m + 1, heigh);
		}
		else if(target<a[m]){
			return bsearch(a, target, low, m-1);
		}
		else
		{
			return m;
		}
	}
	
	public static int getMinIndex(int[] a){
		int ret = 0;
		//int minVal = a[ret]; 
		for(int i = 1; i<a.length ; i++	){
			if(a[i]<a[ret]){
				ret = i;
			}
		}
		return ret;
	}
}
