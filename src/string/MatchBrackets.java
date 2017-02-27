package string;

import java.util.Stack;

public class MatchBrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "((";
		System.out.println(validate(s));
	}
	
	public static boolean validate(String s){
		Stack<Character> cache = new Stack<Character> ();
		if(s == null || s.length() <2) return false;
		for(int i = 0; i< s.length(); i++){
			char c = s.charAt(i);
			if(c != '[' && c != ']' && c != '{' && c != '}' && c != '(' && c != ')')
				return false;
			
			if(c=='[' || c == '(' || c == '{'){
				cache.push(c);
			}
			else
			{
				if(! cache.empty()){
					char vc = cache.pop();
					if(c==']' && vc != '['){
						return false;
					}
					if(c== ')' && vc != '('){
						return false;
					}
					if(c== '}' && vc != '{'){
						return false;
					}
				}
				else
				{
					return false;
				}
			}
			
		}
		if(! cache.isEmpty()) return false;
		return true;
	}
	
}
