package dynmaicprogramming;

import java.util.Arrays;

public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildcardMatching wm = new WildcardMatching();
		String pattern = "x?y*z?";
		String string = "xaylmsfsfadfza";
		boolean r = wm.solution(pattern, string);
		System.out.println("Matching? : " + r);
	}
	/*
	 * ? = single char
	 * * = 0-x chars
	 * pattern = x?ay*z
	 * string = xyacmiz
	 * 
	 * returns true
	 */
	public boolean solution(String pattern, String string){
		
		if(!valid(pattern, string)) return false;
		pattern = ' ' + pattern;
		string = ' ' + string;
		
		int rows = string.length();
		int cols = pattern.length();
		boolean[][] cache = new boolean[rows][cols];
		
		//we know that when no string, they are matching. 
		//so we need to set [0][0] to be true to start with. 
		cache[0][0] = true; 
		
		//initial the first row, because empty matches nothing.
		//we actually don't need the explicit declaration.
		//Everything in cache is set to false in the initialization. 
//		for(int col = 1; col < cols; col++ ){
//			cache[1][col] = false; 
//		}
		
		
		
		for(int row = 1; row<rows; row ++){
			for(int col = 1; col<cols; col++){
				if(pattern.charAt(col) == string.charAt(row) || pattern.charAt(col) == '?'){
					cache[row][col] = cache[row - 1][col -1];
				}
				else if(pattern.charAt(col) == '*'){
					cache[row][col] = cache[row-1][col] | cache[row][col-1];
				}
				else{
					cache[row][col] = false;
				}
			}
		}
		
		dump(cache);
		
		return cache[rows-1][cols-1];
	}
	
	private boolean valid(String p, String s){
		return true;
	}
	
	public void dump(boolean[][] cache){
		for(int i = 0; i<cache.length; i++){
			System.out.println(Arrays.toString(cache[i]));
		}
	}

}
