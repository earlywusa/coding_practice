package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import tools.Dumpper;

public class GroupAnagram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println("sum dun: " + getSum("dun") + " sum ill: " + getSum("ill"));
		//System.out.println("prod dun: " + getProduct("dun") + " prod ill: " + getProduct("ill"));
		// TODO Auto-generated method stub
		String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		findAnagram(input);
		//groupAnagrams(input);
	}
	
	public static List<List<String>> findAnagram(String[] strArray){
		List<List<String>> result = new ArrayList<List<String>>();
		Map<String, List<String>> hash = new HashMap<String, List<String>>();
		if(strArray == null) return result;
		if(strArray.length == 0) return result;
		for(int i=0; i<strArray.length; i++){
			String key = "" + getSum(strArray[i]) + getProduct(strArray[i]);
			if(hash.get(key) == null){
				List<String> tmp = new ArrayList<String>();
				hash.put(key, tmp);
			}
			hash.get(key).add(strArray[i]);
		}
//		Iterator<String> itr = hash.keySet().iterator();
//		while(itr.hasNext()){
//			String key = itr.next();
//			if(hash.get(key) != null){
//				result.add(hash.get(key));
//			}
//		}
		result = new ArrayList<List<String>>(hash.values());
		Dumpper<String, String> mapDumpper = new Dumpper<String, String>();
		mapDumpper.dump(hash);
		//mapDumpper.dump(result);
		return result;
	}
	
	
	public static int getSum(String word){
		int sum =0;
		for(int i=0; i<word.length(); i++){
			sum+=(int)(word.charAt(i));
		}
		
		return sum;
	}
	public static int getDiff(String word){
		int diff = (int) (word.charAt(0));
		for(int i=1; i<word.length(); i++){
			diff-=(int)(word.charAt(i));
		}
		
		return diff;
	}
	
	public static long getProduct(String word){
		
		long product =1;
		for(int i=0; i<word.length(); i++){

			product*=(long)(word.charAt(i));
		}
		
		return product;
	}
	
	public static List<List<String>> groupAnagrams(String[] strs){
		if(strs==null || strs.length == 0){
			return new ArrayList<List<String>>();
		}
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		//Arrays.sort(strs);
		for (String s:strs) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String keyStr = String.valueOf(ca);
			if(!map.containsKey(keyStr))
				map.put(keyStr, new ArrayList<String>());
			map.get(keyStr).add(s);
		}
		Dumpper<String, String> mapDumpper = new Dumpper<String, String>();
		mapDumpper.dump(map);
		for(String key: map.keySet()) {
			Collections.sort(map.get(key));
		}
		System.out.println("After sorted:");
		mapDumpper.dump(map);
		return new ArrayList<List<String>>(map.values());
	}
	
}
