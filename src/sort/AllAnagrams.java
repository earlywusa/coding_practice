package sort;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class AllAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abab";
		String p = "ab";
		s = "cbaebabacd";
		p = "abc";
		List<Integer> r = findAnagrams(s, p);
		System.out.println(Arrays.toString(r.toArray()));
//		int i = 0;
//		int[] array = new int[10];
//		System.out.println("number at :" + i + " : " + array[i]++);
//		System.out.println("array[" + i +"] = " + array[i]);
		
//		System.out.println("char at "+ i + " : "+s.charAt(i++));
//		System.out.println("i=" + i );

	}
	
	//window sliding
	public static List<Integer> findAnagramsSolution(String s, String p) {
	    List<Integer> list = new ArrayList<>();
	    if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
	    int[] hash = new int[256]; //character hash
	    //record each character in p to hash
	    for (char c : p.toCharArray()) {
	        hash[c]++;
	    }
	    //two points, initialize count to p's length
	    int left = 0, right = 0, count = p.length();
	    while (right < s.length()) {
	        //move right everytime, if the character exists in p's hash, decrease the count
	        //current hash value >= 1 means the character is existing in p
	        if (hash[s.charAt(right++)]-- >= 1) count--; 
//	    	System.out.println("right: " + s.charAt(right) + " hash count: " + hash[s.charAt(right)]);
//	        if(hash[s.charAt(right)] >= 1){	
//	        	count--;
//	        	
//	        }   
//        	hash[s.charAt(right)] --;
//	        right ++;
	        dumpArray(hash, p);
	        //when the count is down to 0, means we found the right anagram
	        //then add window's left to result list
	        if (count == 0) list.add(left);
	    
	        //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
	        //++ to reset the hash because we kicked out the left
	        //only increase the count if the character is in p
	        //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
	        if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
//	        if(right -left == p.length()){
//	        	System.out.println("left: " + s.charAt(left) + " hash count: " + hash[s.charAt(left)]);
//	        	if(hash[s.charAt(left)]>=0){
//	        		count ++;
//	        	}
//	        	hash[s.charAt(left)] ++;
//	        	left ++;
//	        }
	    }
	    return list;
	}
	
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> records = new LinkedList<Integer>();
        //s: can be empty - source
		//p: not empty 
		if(s == null || s.length() == 0) return records;
		if(p == null || p.length()<=0) return records;
		int[] hash = new int[256];
		for(char c : p.toCharArray()){
			hash[c] ++;
		}
		//dumpArray(hash, p);
		int count = p.length();
		int leftIndex = 0; int rightIndex=0;
		while(rightIndex < s.length()){
			//visited every character
			if(hash[s.charAt(rightIndex)]>=1){
				count --;
			}
			hash[s.charAt(rightIndex)] --;
			rightIndex ++;
			
			if(count == 0) records.add(leftIndex);
			
			if(rightIndex - leftIndex == p.length()){
				if(hash[s.charAt(leftIndex)] >= 0){
					count ++;
				}
				hash[s.charAt(leftIndex)] ++;
				leftIndex++;
			}
		}
		
		return records;
    }
	
	public static List<Integer> findAnagramsDiy(String s, String p) {
		List<Integer> records = new LinkedList<Integer>();
        //s: can be empty - source
		//p: not empty 
		if(s == null || s.length() == 0) return records;
		if(p == null || p.length()<=0) return records;
		int[] origCache = new int[256];
		for(char c : p.toCharArray()){
			origCache[c] ++;
		}
		dumpArray(origCache, p);
		for(int i = 0; i< s.length() - p.length() +1 ; i++){
			int[] tmpCache = origCache.clone();
			int tmpEnd = i+p.length();
			StringBuilder sb = new StringBuilder();
			for(int j = i; j<tmpEnd; j++){
				tmpCache[s.charAt(j)]--;
				sb.append(s.charAt(j));
			}
			dumpArray(tmpCache, sb.toString());
			boolean unmatched = false;
			for(char c : p.toCharArray()){
				if(tmpCache[c] != 0) {
					unmatched = true;
					break;
				}
			}
			if(! unmatched)
			records.add(i); //i is valid, add
		}
		return records;
    }
	
	public static void dumpArray(int[] array, String str){
		for(char c : str.toCharArray()){
			System.out.printf("%-10s", c + ":" + array[c]+" ");
		}
		System.out.println();
		
	}
	
	public static List<Integer> findAnagrams1(String s, String p) {
		List<Integer> records = new LinkedList<Integer>();
        //s: can be empty - source
		//p: not empty 
		if(s == null || s.length() == 0) return records;
		if(p == null || p.length()<=0) return records;
		
		Set<Character> pHashSet = new HashSet<Character>();
		char[] pArray = p.toCharArray();
		Arrays.sort(pArray);
		for(char a : pArray){
			pHashSet.add(a);
		}
		
		for(int i=0; i< s.length() - (p.length()-1); i++){
			char cur = s.charAt(i);
			if(! pHashSet.contains(cur)) continue;
			
			String subs = s.substring(i, i+p.length());
			char[] subArray = subs.toCharArray();
			Arrays.sort(subArray);
			if(Arrays.equals(subArray, pArray)){
				records.add(i);
			}
		}
		
		
		return records;
    }
	
}
