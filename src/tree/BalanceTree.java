package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BalanceTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testSubList();
		
		List<RBNode> sortedList = genSortedList();
		
		//RBNode root = doBalance(sortedList);
		
		RBNode root = genTree();
		levelTraverse(root);
		System.out.println();
		levelTraverseWithDeque(root);
	}
	
	public static void testSubList(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		List<Integer> subListA = list.subList(0, 1);
		List<Integer> subListB = list.subList(1+1, list.size());
		System.out.println("size of subListA: " + subListA.size());
		System.out.println("size of subListB: " + subListB.size());
	}
	
	public static List<RBNode> genSortedList(){
		List<RBNode> sortedList = new ArrayList<RBNode>();
		RBNode root = new RBNode(0);
		RBNode a = new RBNode(1);
		RBNode b = new RBNode(2);
		RBNode c = new RBNode(3);
		RBNode d = new RBNode(4);
		RBNode e = new RBNode(5);
		RBNode f = new RBNode(6);
		//RBNode g = new RBNode(7);
		sortedList.add(root);
		sortedList.add(a);
		sortedList.add(b);
		sortedList.add(c);
		sortedList.add(d);
		sortedList.add(e);
		sortedList.add(f);
		//sortedList.add(g);
		
		return sortedList;
	}
	//[3,9,20,null,null,15,7]
	public static RBNode genTree(){
		RBNode root = new RBNode(3);
		RBNode level11 = new RBNode(9);
		RBNode level12 = new RBNode(20);
		RBNode level2_15 = new RBNode(15);
		RBNode level2_7	 = new RBNode(7);
		root.setLeft(level11);
		root.setRight(level12);
		level12.setLeft(level2_15);
		level12.setRight(level2_7);;
		
		return root;
	}
	
	public static RBNode doBalance(List<RBNode> nodeList){
		if (nodeList == null) return null;
		int size = nodeList.size();
		RBNode ret = null;
		if(size <= 0){
			//System.out.println("size of list is smaller or equals to 0.");
		}
		else{
			int middle =  size/2;
			ret = nodeList.get(middle);
			ret.setLeft(doBalance(nodeList.subList(0, middle)));
			ret.setRight(doBalance(nodeList.subList(middle+1, nodeList.size())));
			
		}
		
		return ret;
	}
	
	
	public static List<List<Integer>> levelTraverse(RBNode root)
	{
		List<List<Integer>> levelList = new ArrayList<List<Integer>>();
		
		Levelhelper(root, levelList, 0);
		
		dumpLevelList(levelList);
		return levelList;
	}
	
	public static void Levelhelper(RBNode current, List<List<Integer>> levelList, int height ){
		if(current == null) return;
		if(height >= levelList.size()){
			List<Integer> newList = new LinkedList<Integer>();
			levelList.add(newList);
		}
		levelList.get(height).add(current.value);
		Levelhelper(current.getLeft(), levelList, height +1 );
		Levelhelper(current.getRight(), levelList, height +1 );
	}
	
	public static void dumpLevelList(List<List<Integer>> levelList){
		for(int i = 0; i<levelList.size(); i++){
			System.out.println("i: " + i + " " + Arrays.toString(levelList.get(i).toArray()));
		}
		
	}
	
	public static List<List<Integer>> levelTraverseWithDeque(RBNode root){
		List<List<Integer>> resList = new LinkedList<List<Integer>>();

		Deque<RBNode> cache = new ArrayDeque<RBNode>();
		cache.push(root);
		int count = 1;
		
		while(! cache.isEmpty()){
			List<Integer> valList = new LinkedList<Integer>();
			int tmpCount = 0, nextLevelCount = 0;
			
			while(tmpCount < count){
				RBNode current = cache.pop();
				System.out.println("processing current; " + current.getValue());
				valList.add(current.getValue());
				if(current.getLeft() != null) {
					nextLevelCount ++;
					cache.add(current.getLeft());
				}
				
				if(current.getRight() != null){
					nextLevelCount++;
					cache.add(current.getRight());
				}
				tmpCount++;
			}
			
			count = nextLevelCount;
			resList.add(valList);
		}
		dumpLevelList(resList);
		
		return resList;
	}

}
