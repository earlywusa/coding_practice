package recursion;

public class MagicIndexSol {
	public int findMagicIndex(int[] vals){
		int magicIndex = -1;
		System.out.println("start");
		System.out.println("binary search result: "+ binarySearch(vals, 0, vals.length-1));
		
		return magicIndex;
	}
	
	public int binarySearch(int[] vals, int start, int end){
		System.out.println("checking: start=" + start + " end="+ end);
		if(start <= end){
			int mid = start + (end - start)/2;
			if(vals[mid] == mid){
				System.out.println("mid matches:" + mid);
				return mid;
			}
			if(vals[mid] > mid){
				System.out.println("mid val greater then mid index: val=" + vals[mid] + " index=" + mid );
				return -1;
			}
			return binarySearch(vals, mid + 1, end );
		}
		return -1;
	}
}
