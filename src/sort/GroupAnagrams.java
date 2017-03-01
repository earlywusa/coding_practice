package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = new String[]{"abc","efm", "bca", "ccb","mfe"};
		groupAnagrams(input);
		System.out.println(Arrays.toString(input));
	}
	
	public static void groupAnagrams(String[] ss){
		Map<String, List<String>> cache = new HashMap<String, List<String>>();
		for(String s : ss){
			char[] sorted =s.toCharArray();
			Arrays.sort(sorted);
			String key = Arrays.toString(sorted);
			if(cache.get(key) == null){
				cache.put(key, new ArrayList<String>());
			}
			cache.get(key).add(s);
		}
		int count = 0;
		for(List<String> al : cache.values()){
			for(String item : al){
				ss[count] = item;
				count++;
			}
		}
	}
	
	class anagramComparator implements Comparator<String>{
		

		public int compare(String a, String b){
			return sortedChars(a).compareTo(sortedChars(b));
			
		}
		
		public String sortedChars(String a){
			char[] content =a.toCharArray();
			Arrays.sort(content);
			return new String(content);
			
		}
	}
}
