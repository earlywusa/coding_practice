package recursion;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class PowerSet {
	public List<Set<Character>> getPowerSet(Set<Character> aSet){
		List<Set<Character>> result = new ArrayList<Set<Character>>();
		Queue<Character> input = new ArrayDeque<Character>();
		input.addAll(aSet);
		
		genSubPowerSet(input, result);
		
		return result;
	}
	
	private void genSubPowerSet(Queue<Character> aSet, List<Set<Character>> result){
		while(! aSet.isEmpty()){
			char newChar = aSet.remove();
			System.out.println("Processing: " + newChar);
			ArrayList<Set<Character>> newList = new ArrayList<Set<Character>>();
			for(Set<Character> subSet : result){
				Set<Character> modSet = new HashSet<Character>();
				for(Character c: subSet){
					modSet.add(c);
					modSet.add(newChar);
				}
				System.out.println("add set: " + Arrays.toString(modSet.toArray()));
				newList.add(modSet);
			}
			Set<Character> newCharSet = new HashSet<Character>();
			newCharSet.add(newChar);
			System.out.println("add set: " + Arrays.toString(newCharSet.toArray()));
			newList.add(newCharSet);
			result.addAll(newList);
		}
	}
	
	
	
List<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		List<ArrayList<Integer>> allsubsets;
		if (set.size()== index) {//Base case - add empty set
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>()); // Empty set
		} else {
			allsubsets = getSubsets(set, index+ 1);
			int item= set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allsubsets) {
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset); //
				newsubset.add(item);
				moresubsets.add(newsubset);		
			}
			allsubsets.addAll(moresubsets);
		 }
			return allsubsets;
	}
}
