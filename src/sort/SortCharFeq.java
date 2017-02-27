package sort;

import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import tree.SortedSet.DataPair;

public class SortCharFeq {

	/*
	 * give a string, rearrange according to the characters rate of appearences. 
	 * bcaaa -> aaabc
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "aabdccc";
		String result = frequencySort(input);
		System.out.println(result);
//		testSwap();
		
	}
	
	public static void testSwap(){
		ArrayList<Entry<Character, Integer>> array = new ArrayList<Entry<Character, Integer>>();
		Entry<Character, Integer> entry1 = new SimpleEntry<Character, Integer>('a', 2);
		Entry<Character, Integer> entry2 = new SimpleEntry<Character, Integer>('b', 1);
		Entry<Character, Integer> entry3 = new SimpleEntry<Character, Integer>('c', 3);
		Entry<Character, Integer> entry4 = new SimpleEntry<Character, Integer>('d', 1);
		array.add(entry1);
		array.add(entry2);
		array.add(entry3);
		array.add(entry4);
//		dumpArray(array);
//		swap(array, 0, 3);
		dumpArray(array);
		divideAndSort(array, 0, array.size()-1);
		dumpArray(array);
	}
	
	public static void swap(ArrayList<Entry<Character, Integer>> array, int pos1, int pos2){
		Entry<Character, Integer> tmpEntry = array.get(pos1);
		array.set(pos1, array.get(pos2));
		array.set(pos2, tmpEntry);
		
	}
	
	public static void dumpArray(ArrayList<Entry<Character, Integer>> array){
		for(int i = 0; i<array.size(); i++){
			System.out.println(array.get(i).getKey() + " = " + array.get(i).getValue());
		}
		System.out.println();
	}

	
    public static String frequencySort(String s) {
        return regularMappingMethod(s);
    }
    
    public static String sortedMappingMethod(String s){
    	String ret = "";
    	
    	
    	return ret;
    }
    
    public static String regularMappingMethod(String s){
    	String ret="";
    	Map<Character, Integer> cache = new HashMap<Character, Integer>();
    	for(int i=0; i<s.length(); i++){
    		Character c = s.charAt(i);
    		
    		if(cache.containsKey(c)){
    			int value = cache.get(c).intValue();
    			value ++;
    			cache.put(c, value);
    		}
    		else
    		{
    			cache.put(c, new Integer(1));
    		}
    	}
    	
    	ArrayList<Entry<Character, Integer>> entryAL = new ArrayList<>();
    	
    	Iterator<Character> itr = cache.keySet().iterator();
    	while(itr.hasNext()){
    		Character key = itr.next();
    		int value = cache.get(key);
    		Entry<Character, Integer> tmp = new SimpleEntry<Character, Integer>(key, value);
    		System.out.println("key: " + key + "=" +value);
    		entryAL.add(tmp);
    	}
    	dumpArray(entryAL);
    	divideAndSort(entryAL, 0, entryAL.size() -1);
    	dumpArray(entryAL);
    	StringBuffer sb = new StringBuffer();
    	for(int i = entryAL.size()-1; i>=0; i--){
    		int repeat = entryAL.get(i).getValue();
    		String c = entryAL.get(i).getKey().toString();
    		for(int r = 0; r<repeat; r++){
    			sb.append(c);
    		}
    	}
    	ret = sb.toString();
    	return ret;
    }
    
    /*
     * quicksort algorithm review
     * get he pivot position, normally last index
     * 
     */
    public static void divideAndSort(ArrayList<Entry<Character, Integer>> entryAL,int start, int end){
    	
    	if(start < end)
    	{
    		int p1 = quickSort(entryAL, start, end);
    		divideAndSort(entryAL, start, p1-1);
    	
    		divideAndSort(entryAL, p1+1, end);
    	}
    	
    }
    
    public static int quickSort(ArrayList<Entry<Character, Integer>> entryAL, int start, int end){
    	int retPivot = end;

    		Entry<Character, Integer> pivot = entryAL.get(end);
    		int i=start;
    		for(int j = i; j<end; j++){
    			Entry<Character, Integer> tmpj = entryAL.get(j);
    			if(tmpj.getValue().intValue() <= pivot.getValue().intValue()){
    				swap(entryAL, i, j);
    				i ++;
    			}
    		}
    		swap(entryAL, i, end);
    	return i;
    }
    
    public class DataComp implements Comparator<DataPair>{

		@Override
		public int compare(DataPair o1, DataPair o2) {
			if(o1.getValue() < o2.getValue()) return 1;
			if(o1.getValue() > o2.getValue()) return -1;
			return 0;
		}
		
	}
}
