package string;
/*
 * 
 * Given a string, determine if a permutation of the string could form a palindrome.

	For example,
	"code" -> False, "aab" -> True, "carerac" -> True.
	
	Hint:
	
	Consider the palindromes of odd vs even length. What difference do you notice?
	Count the frequency of each character.
	If each character occurs even number of times, then it must be a palindrome. 
	How about character which occurs odd number of times?
 * 
 */
public class PalindromePerm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abccbas";
		System.out.println(canPermutePalindrome(s));
	}
	
    public static boolean canPermutePalindrome(String s) {
        int[] hash = new int[256];
        for(char ss : s.toCharArray()){
        	hash[ss]++;
        }
        int singleCount = 0;
        for(int i = 0; i< hash.length; i++){
        	int count = hash[i];
        	int reminder = count % 2;
        	if(reminder == 1) singleCount ++;
        }
    	if(singleCount > 1){
    		return false;
    	}
        return true;
    }

}
