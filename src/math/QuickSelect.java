package math;

import java.util.Arrays;
import java.util.Random;

public class QuickSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSelect q = new QuickSelect();
		int[] nums1 = new int[]{1,2};
		int[] nums2 = new int[]{3,4};
		System.out.println(q.findMedianSortedArrays(nums1, nums2));
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m1Pos = nums1.length/2; //sorted array, n/2 index gives median
        int m2Pos = nums2.length/2;
        
        int mVal = (nums1[m1Pos] + nums2[m2Pos])/2; //median value of two medians
        int[] array = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, array, 0, nums1.length);
        System.arraycopy(nums2, 0, array, nums1.length, nums2.length);
        System.out.println("array: " + Arrays.toString(array));
       
        
       // int m = partition(array, 0, array.length-1, mVal);
        
        if(array.length %2 == 0){
        	int medianIndex1 = array.length/2;
        	int medianIndex2 = array.length/2 +1;
        	
        	int valMedian1 = quickSelectMin(array, 0, array.length-1, medianIndex1);
        	
        	int valMedian2 = quickSelectMin(array, 0, array.length-1, medianIndex2);
        	System.out.println("v1: " + valMedian1 + " medianIndex1: " + (medianIndex1));
        	System.out.println("v2: " + valMedian2);
        	return ((double)valMedian1 + (double)valMedian2)/2.0;
        	
        	
        }else{
        	int medianIndex1 = array.length/2;
        	int valMedian1 = quickSelectMin(array, 0, array.length-1, medianIndex1+1);
        	System.out.println("v1: " + valMedian1);
        	return (double)valMedian1;
        }
        
       

//        double r = (double)array[m-1];
//        if(array.length %2 == 0){
//        	 int minFromHighHalf = quickSelectMin(array, m, array.length-1, 1);
//        	 System.out.println(" min from high half: "  + minFromHighHalf);
//        	 r = (r + (double)minFromHighHalf)/2.0;
////        	if(m>=2) r = (r + (double)array[m-2])/2.0;
//        }
//        
//        
//        System.out.println("r: " + r);
//        return r;
//        return 0.0;
    }
    
    public int quickSelectMin(int[] a, int lo, int hi, int kthMin){
    	System.out.println("quicksort: low: " + lo + " high: " + hi);
    	if(lo == hi){
    		return a[lo];
    	}
        int m = partition(a, lo, hi);
        System.out.println("partition m: " + m);
        
        int count = (m-lo)+1;
        
        if(count == kthMin){
        	return a[m];
        }
        else if(count<kthMin){
        	return quickSelectMin(a, m+1, hi, kthMin-count);
        }
        else
        {
        	return quickSelectMin(a, lo, m-1, kthMin);
        }
    }
    
    public int partition(int[] a, int lo, int hi){
      Random rand = new Random();
      int randPivote = rand.nextInt(hi-lo+1) + lo;
      System.out.println("random pivote: " + randPivote + " lo: " + lo + " hi: " + hi);
      swap(a, randPivote, hi);
    	int i = lo;
    	for(int j = lo; j< hi; j++){
    		if(a[j]<= a[hi]){
    			swap(a, j, i);
    			i++;
    		}
    	}
    	swap(a, i, hi);
    	return i;
    }
    
    public int partition(int[] a, int lo, int hi, int mVal){

        System.out.println("pivot: " + mVal);
        int i = lo;
        for(int j = lo; j<=hi; j++){
        	if(a[j]<= mVal){
        		swap(a, i, j);
        		i++;
        	}
        }
        
        System.out.println("sorted array: " + Arrays.toString(a) + " i: " + i);
        return i;
    }
    
    public void swap(int[] a, int i, int j){
    	int tmp = a[i];
    	a[i] = a[j];
    	a[j] = tmp;
    }
}
