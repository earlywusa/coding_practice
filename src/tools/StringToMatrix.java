package tools;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class StringToMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "[[1,2,3],[3,4,5]]";
		int[][] ret = StringToMatrix.convert(input);
		for(int col = 0; col<ret.length; col++){
			for(int row = 0; row<ret[0].length; row++){
				System.out.print(ret[col][row] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static int[][] convert(String input){
		/*
		 * sample input: [[1,2,3],[3,4,5]]
		 * output = array[0] = [1,2,3]
		 * output = array[1] = [3,4,5]
		 */
		List<String> array_strs  = new ArrayList<String>();
		boolean stateOpen = false;
		int lo = 0; int hi = 0;
		//Stack<Character> symbolStk = new Stack<Character>(); 
		while(hi<input.length()){
			Character hiChar = input.charAt(hi);
			if(Objects.equals(hiChar, '[')){
				//symbolStk.push(hiChar);
				lo = hi;
				stateOpen = true;
			}
			else if (Objects.equals(hiChar, ']')){
				if(stateOpen){
					String sub = input.substring(lo+1, hi);
					array_strs.add(sub);
				}
				stateOpen = false;
			}
			hi++;
		}
		int[][] ret = new int[array_strs.size()][];
		for(int i = 0; i< array_strs.size(); i++){
			//System.out.println(array_strs.get(i));
			String[] splited = array_strs.get(i).split(",");
			ret[i] = new int[splited.length];
			for(int j=0; j<splited.length; j++){
				ret[i][j] = Integer.parseInt(splited[j]);
			}
		}
		
		return ret;
	}

}
