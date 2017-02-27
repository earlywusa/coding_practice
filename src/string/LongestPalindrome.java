package string;
/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

	Example:
	
	Input: "babad"
	
	Output: "bab"
	
	Note: "aba" is also a valid answer.
	Example:
	
	Input: "cbbd"
	
	Output: "bb"
 * @author esuo
 *
 */
public class LongestPalindrome {
/*
 *  s="abaufdeedu"
	   0123456789
	backtracing:
	end = 0 longest=0
	
	The minimum number (except single letter) of a palindrome is either 2 or 3, "aa" "aba" 
	therefore, we need to check if the combination of currentIndex - lcount 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaaa";
		//System.out.println("isPalindrome: " + isPalindrome(s, 0, s.length()-1 ));
		
		System.out.println("longest palindrome: " + longestPalindrome("a"));
	}
	
	public static String longestPalindrome(String s){
		if(s == null || s.length()== 0 ) return "";
		String ret = "";
		int lstCount = 0;
		for(int right = 0; right< s.length(); right++){
			int left = right - lstCount;
			boolean foundPalin = false;
			if(isPalindrome(s, left, right)){
				foundPalin = true;
			}
			if(!foundPalin){
				left = right - lstCount -1;
				if(isPalindrome(s, left, right)){
					foundPalin = true;
				}
			}
			if(foundPalin){
				ret = s.substring(left, right +1);
				lstCount = right - left +1;
			}
		}
		return ret;
	}
	

	
	public static boolean isPalindrome(String s, int left, int right){
		if(left < 0 || right < 0) return false;
		if(right < left) return false;
		while(right >= left){
			if(s.charAt(left) == s.charAt(right)){
				left++; right --;
			}
			else
			{
				return false;
			}
		}
		return true;
	}
	
    public static  String longestPalindrome_bruteForce(String s) {
    	if(s == null ) return new String();
    	if(s.length() == 0) return new String();
        int left = 0; int right = 0; 
        String longest = "" + s.charAt(0);
        while(left < s.length()){
        	right = left;
        	while(right < s.length() ){
        		if(isPalindrome(s, left, right)){
        			if(right -left +1 > longest.length()){
        				longest = s.substring(left, right +1);
        			}
        		}
        		right ++;
        	}
        	left ++;
        	
        }
        return longest;
    }
	
}
