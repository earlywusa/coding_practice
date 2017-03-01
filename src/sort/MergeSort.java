package sort;

import java.util.LinkedList;
import java.util.List;

public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> source = new LinkedList<Integer>();
		source.add(new Integer(10));
		source.add(new Integer(6));
		source.add(new Integer(2));
		source.add(new Integer(11));
		source.add(new Integer(8));
		source.add(new Integer(3));
		dump(source);
		List<Integer> ret = divide(source);
		dump(ret);
		
		//List<Integer> source1 = new LinkedList<Integer>();
		//source1.add(new Integer(10));
		//source1.add(new Integer(6));
		//testSpliteList(source1);
	}
	public static void testSpliteList(List<Integer> source){
		List<Integer> a = source.subList(0, 1);
		List<Integer> b = source.subList(1, 2);
		System.out.println("Size of a: " + a.size());
		System.out.println("Size of b: " + b.size());
		
	}
	
	public static List<Integer> divide(List<Integer> source){
		System.out.println("sorting: " + source.size());
		
		/*
		 * 
		 */
		List<Integer> retList = new LinkedList<Integer>();
		if(source.size() > 1)
		{
			int index = source.size()/2;
			System.out.println("sub list: 0 -> " + (index-1) );
			List<Integer> inputListA = (List<Integer>)source.subList(0, index);
			System.out.println("sub list: " + index + " -> " + (source.size() -1));
			List<Integer> inputListB = (List<Integer>)source.subList(index, source.size());
			System.out.println("1. call with size: " + inputListA.size());
			List<Integer> sortedListA = divide(inputListA);
			System.out.println("2. call with size: " + inputListB.size());
			List<Integer> sortedListB = divide(inputListB);
			return merge(sortedListA, sortedListB);
		}else
		{
			System.out.println("source size: " + source.size());
			List<Integer> sortedList = new LinkedList<Integer>();
			sortedList.add(source.get(0));
			return merge(sortedList, null);
		}
		
	}

	public static List<Integer> merge(List<Integer> a, List<Integer> b){
		List<Integer> ret = new LinkedList<Integer>();
		if(b == null){
			ret.add(a.get(0));
			return ret;
		}
		
		System.out.println("sorted list A: ");
		if(a != null)
		dump(a);
		System.out.println("sorted list B: ");
		if(b != null)
		dump(b);
		
		
		int sizeA = a.size();
		int sizeB = b.size();
		
		int countA=0, countB=0;
		while(countA < sizeA && countB < sizeB){
			if(a.get(countA) < b.get(countB)){
				ret.add(a.get(countA));
				countA++;
			}
			else{
				ret.add(b.get(countB));
				countB++;
			}
		}
		if(countA<sizeA){
			ret.add(a.get(countA));
			countA++;
		}
		if(countB<sizeB){
			ret.add(b.get(countB));
			countB++;
		}
		System.out.println("merged list size: "+ ret.size());
		return ret;
	}
	
	
	public static void dump(List<Integer> src){
		
		if(src == null) {
			System.out.println("src is null");
			return;
		}
		
		for(int i = 0; i< src.size() -1; i++){
			int value = src.get(i).intValue();
			System.out.print(value + " ");
		}
		System.out.println();
	}

}
