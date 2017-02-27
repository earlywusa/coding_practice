package dynmaicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LongestNonRepeatingSubstring {

	//"udzyeavofanfxngqyhubmaftqyzq"
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("longest = "+getLongestNonRepeatingSubstring("fpdcztbudxfipowpnamsrfgexjlbjrfoglthewbhtiriznzmolehqnlpwxrfowwwjrd"));
		System.out.println("longest = " + getNRPLength("djdvja"));
	}

	//"fpdcztbudxfipowpnamsrfgexjlbjrfoglthewbhtiriznzmolehqnlpwxrfowwwjrd"
	/*    0 1 2 3 4 5
	 * s=[d|j|d|v|a|v]
	 * L=1
	 * d[0,0] = set{d}
	 * d[1,1] = set{j}
	 * d[2,2] = set{d}
	 * d[3,3] = set{v}
	 * d[4,4] = set{a}
	 * d[5,5] = set{v}
	 * 
	 * L=2
	 * d[0,1] = d[0,0] merge s[1] = set{d, j}
	 * d[1,2] = d[1,1] merge s[2] = set{j, d}
	 * d[2,3] = d[2,2] merge s[3] = set{d, v}
	 * d[3,4] = d[3,3] merge s[4] = set{v, a}
	 * d[4,5] = d[4,4] merge s[5] = set{a, v}
	 * 
	 * 
	 * L=3
	 * d[0,2] = d[0,1] merge s[2] = set{d, j, d} ==> d[1,1] merge s[2] = set{j,d}
	 * d[1,3] = d[1,2] merge s[3] = set{j, d, v}
	 * d[2,4] = d[2,3] merge s[4] = set{d, v, a}
	 * d[3,5] = d[3,4] merge s[5] = set{v, a, v} ==> d[4,4] merge s[5] = set{a,v}
	 * 
	 * L=4
	 * d[0,3] = d[0,2] merge s[3] = set{j, d, v}
	 * d[1,4] = d[1,3] merge s[4] = set{j, d, v, a}
	 * d[2,5] = d[2,4] merge s[5] = set{d, v, a, v} == > d[3,4] merge s[5] = set{v, a, v} ==> d[4,4] merge s[5] = set{a,v}
	 * 
	 * L=5
	 * d[0,4] =
	 * d[1,5] =
	 * 
	 * L=6
	 * d[0,5] =
	 */
	public static int getLongestNonRepeatingSubstring(String s){
		List<List<Set<Character>>> cache = new ArrayList<List<Set<Character>>>();
		
		if(s == null) return 0;
		if(s.length() == 0 ) return 0;
		int longest = 1;
		
		for(int x = 0; x < s.length(); x++){
			cache.add(new ArrayList<Set<Character>>());
			for(int y=0; y<s.length(); y ++){
				cache.get(x).add(new HashSet<Character>());
			}
		}
		
		for(int length = 1;length <= s.length(); length ++){
			int start, end;
			for(int i = 0; i<s.length(); i++){
				if(length == 1){
						cache.get(i).get(i).add(s.charAt(i));
				}
				else{
					start = i; end = i+ length -1;
					int origStart = start, origEnd = end;
					if(end < s.length()){
						System.out.println("");
						System.out.println("about to insert: " + s.charAt(end) + " to d[" + start + "," + end+"]" );
						while(start<end){
							
							Character cc = s.charAt(end);
							Set<Character> previousSet = cache.get(start).get(end -1);
							if(previousSet.contains(cc)){
								System.out.println("Conflict found [" + start + "," + (end -1) + "]");
								if(previousSet.size() + 1 <= longest)
									break;
							}
							else
							{
								Set<Character> currentSet = cache.get(origStart).get(origEnd);
								System.out.println("copy previousSet: [" + start + ", " + (end-1) + "] to [" + origStart + "," + origEnd + "]"   );
								currentSet.addAll(previousSet);
								currentSet.add(s.charAt(end));
								System.out.println("prev: " + Arrays.toString(previousSet.toArray()) + " ==> current: " + Arrays.toString(currentSet.toArray()));
								if(currentSet.size() > longest){
									longest = currentSet.size();
									System.out.println("Longest updated: " + longest);
								}
								break;
							}
							
							start ++;
						}
						System.out.println("d[" + origStart + "," + origEnd +"] =: " + convertSetToString(cache.get(origStart).get(origEnd)));
					}
				}
			}
		}
		
		return longest;
	}
	
	public static void cloneSet(Set<Character>source, Set<Character>dest){
		dest.addAll(source);
	}
	
	public static String convertSetToString(Set<Character> s){
		StringBuilder sb = new StringBuilder();
		Character[] dumpArray = new Character[s.size()];
		s.toArray(dumpArray);
		for(Character c : dumpArray)
		{
			sb.append( c + ",");
		}
		return "[" + sb.toString() + "]";
	}
	
	public static int getNRPLength(String s){
			int len = s.length();
			int curr_len = 1;
			int max_len = 1;
			int prev_idx;
			int[] visited = new int[256];

			for(int i=0; i<256; i++){
				visited[i] = -1;
			}

			visited[s.charAt(0)] = 0;
			System.out.println("input: " + s);
			for(int i=1; i<len; i++){
				prev_idx = visited[s.charAt(i)];
				System.out.println("prev_idx: " + prev_idx + " for " + s.charAt(i));
				System.out.println("i=" + i + " current_length=" + curr_len);
				if(prev_idx==-1 || i-curr_len>prev_idx){
					curr_len ++;
				}else{
					if(curr_len > max_len){
						max_len = curr_len;
					}
					curr_len = i - prev_idx;
				}
				System.out.println("Set visited[" + s.charAt(i) + "] to " + i);
				visited[s.charAt(i)] = i;
				System.out.println();
			}

			if(curr_len > max_len){
				max_len = curr_len;
			}
			return max_len;
		}

}
