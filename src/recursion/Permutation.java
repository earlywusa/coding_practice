package recursion;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class Permutation {
	
	public List<LinkedList<Character>> findAllPermutation(String s){
		List<LinkedList<Character>> result = new LinkedList<LinkedList<Character>>();
		LinkedList<Character> firstll = new LinkedList<Character>();
		firstll.add(s.charAt(0));
		result.add(firstll);
		for(int i = 1; i<s.length(); i++){
			result = genPermutation(result, s.charAt(i));
		}
		
		return result;
	}
	
	public List<LinkedList<Character>> genPermutation(List<LinkedList<Character>> result, char c ){
		List<LinkedList<Character>> ret = new LinkedList<LinkedList<Character>>();
		for(LinkedList<Character> ll : result){
			ll.add(c);
			ret.add((LinkedList<Character>) ll.clone());
			for(int i = 0; i<ll.size()-1; i ++){
				moveHeadToEnd(ll);
				ret.add((LinkedList<Character>) ll.clone());
			}
		}
		
		return ret;
	}
	
	private List<Character> convertStringToCharLinkedList(String s){
		LinkedList<Character> ll= new LinkedList<Character>();
		for(char c : s.toCharArray()){
			ll.add(c);
		}
		return ll;
	}
	
	private void moveHeadToEnd(LinkedList<Character> ll){
		Character head = ll.removeFirst();
		ll.addLast(head);	
	}
	//recursive way --- concise and clear
	public void getPerms(String str){
		System.out.println("getPerm: " + str);
		List<String> ret = new ArrayList<String>();
		getPerms("", str, ret , 0);
	}
	
	public void getPerms(String prefix, String reminder, List<String> result, int recurCount){
		recurCount ++;
		System.out.println("prefix: " + prefix + " reminder: "+ reminder + " recurCount: " + recurCount);
		if(reminder.length() == 0) {
			System.out.println("return result adding prefix: " + prefix + " recurCount: " + recurCount);
			result.add(prefix);
		}
		int len = reminder.length();
		
		for(int i=0; i<len; i++){
			
			String before = reminder.substring(0,i);
			char c = reminder.charAt(i);
			String after = reminder.substring(i+1, len);
			System.out.println("	i: " + i + "=" + c + " before:{" + before + "} after: {" + after + "} recurCount: " + recurCount);
			getPerms(prefix+c, before+after, result, recurCount);
		}
		System.out.println("return with rec: " + recurCount);
	}
}
