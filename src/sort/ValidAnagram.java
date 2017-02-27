package sort;
/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.

	For example,
	s = "anagram", t = "nagaram", return true.
	s = "rat", t = "car", return false.
	
	Note:
	You may assume the string contains only lowercase alphabets.
	
	Follow up:
	What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * @author esuo
 *
 */

import java.util.Arrays;

public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "anagram";
		String t = "nagaram";
		System.out.println(isAnagram(s, t));
	}
	
	public static boolean isAnagram(String s, String t) {
      if(s == null || t == null) return false;
      if(s.length() != t.length() ) return false;
      
      int[] hash = new int[256];
      for(char sc : s.toCharArray()){
    	  hash[sc] ++;
      }
      
      for(char ts : t.toCharArray()){
    	  hash[ts] --;
      }

     for(char ss: s.toCharArray()){
    	 if(hash[ss] != 0) return false;
     }
     
     return true;
      
      
    }

}
