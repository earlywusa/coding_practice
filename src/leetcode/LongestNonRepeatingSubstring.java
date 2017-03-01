package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LongestNonRepeatingSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(getLongestNonRepeatingSubstring("djdvx"));
		String input="djdvu";
		System.out.println(getLongestNRS(input));	
		System.out.println(lengthOfLongestSubstring(input));
		System.out.println(lengthOfLongestSubstring2(input));
//		int[] cache = new int[256];
//		for(int i = 0; i< cache.length; i++) cache[i] = -1;
//		int index = 0;
//		cache['d'] = index;
//		System.out.println("d: " + (int)'d');
//		System.out.println("a: " + (int)'a');
//		System.out.println("b: " + (int)'b');
//		dumpCache(cache);
	}
	
	public static void dumpCache(int[] cache){
		for(int i = 0;i<cache.length; i++){
			if(cache[i] != -1)
			System.out.print(i +"=["+cache[i] + "] ");
		}
	}
	
	/*
	 * initialize the cache with 
	 * 
	 */
	public static int getLongestNRS(String s){
		int longest = 0;
		int start = 0;
		int[] cache = new int[256]; 
		for(int i = 0; i< cache.length; i++) cache[i] = -1;
		
		for(int end = 0; end < s.length(); end ++){
			//empty slot
			if(cache[s.charAt(end)] == -1){
				cache[s.charAt(end)] = end;
				longest = Math.max(longest, end-start);
			}
			else //occupied slot
			{
				//save previous duplicated position
				int newStart = cache[s.charAt(end)];
				System.out.println("new start: " + newStart);
				start = Math.max(newStart, start);
				//update entry
				cache[s.charAt(end)] = end;
				longest = Math.max(longest, end-start);
			}
			
		}
		
		
		
		return longest;
	}
	
	public static int getLongestNonRepeatingSubstring(String s){
	        Map<Character,Integer> indices = new HashMap<Character,Integer>();
	        int length = 0;
	        int start = -1;
	        int end = 0;
	        for(end=0; end < s.length(); end++){
	            char c = s.charAt(end);
	            if(indices.containsKey(c)){
	                int newstart = indices.get(c);
	                start = Math.max(start,newstart);
	            }
	            length = Math.max(length,end-start);
	            indices.put(c,end);
	            dumpMap(indices);
	            System.out.println();
	        }
	        return length;
	}
	public static void dumpMap(Map<Character, Integer> inMap){
		Iterator<Character> tmp = inMap.keySet().iterator();
		while(tmp.hasNext()){
			Character key = tmp.next();
			System.out.println("key: " + key + " " + inMap.get(key));
		}
	}
	public static int lengthOfLongestSubstring2(String s) {
        int max = 0, i =0 , j = 0,index;
        int[] hm = new int[128];
        while(j<s.length()){
            if(hm[s.charAt(j)] == 0){
                hm[s.charAt(j)] = j+1;
                j++;
                if((j-i) > max)
                    max = j-i;
            }
            else {
                index = hm[s.charAt(j)];
                hm[s.charAt(j)] = 0;
                if (i < index)
                    i = index;
            }
        }
        return max;
    }

public static int lengthOfLongestSubstring(String s) {
	        if(s  == null) return 0;
	        if(s.length() == 0 ) return 0;
	        if(s.length() == 1) return 1;
	        int longestNRStr = 1;
	        Map<Character, Integer> cache = new HashMap<Character, Integer>();
	        int start = 0;
	        
	        for(int i =0; i<s.length(); i++){
	            int end = i;
	            char item = s.charAt(i);
	            //duplicated found, find previous start, recompute length of longest
	            if(cache.get(item) != null){
	                int newstart = cache.get(item)+1;
			        start = Math.max(start, newstart);
			        
	                longestNRStr = Math.max(longestNRStr, end - start+1);
	                cache.put(item, i);
	                System.out.println("conflict:" +item+"  end: " + end + " start: " + start + " longest: " + longestNRStr);
	            }
	            else{
	                //store to cache
	                cache.put(item, i);
	                longestNRStr = Math.max(longestNRStr, end - start +1 );
	                System.out.println("no conflict:" +item+"  end: " + end + " start: " + start + " logest: " + longestNRStr);
	            }
	        }
	        return longestNRStr;
		    }
}
