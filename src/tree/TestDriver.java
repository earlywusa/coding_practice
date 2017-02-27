package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import math.Permutation;
import tools.ExecutionTimeTracker;

public class TestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testTreeHeight();
		//testLevelTraverse();
		//testConvertTreeToArray(); //not working
		//testCompareTree();
		//testGenerateAllPossibleBST();		
		//testCommonAncester();
		testRegex();

	}
	public static void testRegex(){
		//"^hmac\\s(\\S+):(\\S+)$";
		// check for "hmac" scheme
		String HMAC_AUTH_REGEX_PATTERN = "^hmac\\s(\\S+):(\\S+)$";
		String authorizationHeader = "hmac ron:ljhgh";
		Pattern pattern = Pattern.compile(HMAC_AUTH_REGEX_PATTERN);
		Matcher matcher = pattern.matcher(authorizationHeader);
		if (matcher.matches()) {
			//authScheme = AuthScheme.HMAC;
			String authUser = matcher.group(1);
			String authEncodedHmac = matcher.group(2);
			
			System.out.println("matched");
			System.out.println("hmac: " + matcher.group());
			System.out.println("authUser: " + authUser);
			System.out.println("authEncodedHmac: " + authEncodedHmac);
		}
		else
		{
			System.out.println("not match");
		}
	}
	public static BinarySearchTree constructTree(){
		TreeNode root = new TreeNode(20);
		TreeNode node1 = new TreeNode(10);
		TreeNode node2 = new TreeNode(30);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(25);
		TreeNode node6 = new TreeNode(35);
		BinarySearchTree aTree = new BinarySearchTree(root);
		aTree.insert(node1);
		aTree.insert(node2);
		aTree.insert(node3);
		aTree.insert(node4);
		aTree.insert(node5);
		aTree.insert(node6);
		return aTree;
	}
	
	public static BinarySearchTree constructTree2(){
		TreeNode root = new TreeNode(20);
		TreeNode node1 = new TreeNode(8);
		TreeNode node2 = new TreeNode(30);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(16);
		TreeNode node5 = new TreeNode(25);
		TreeNode node6 = new TreeNode(35);
		BinarySearchTree aTree = new BinarySearchTree(root);
		aTree.insert(node1);
		aTree.insert(node2);
		aTree.insert(node3);
		aTree.insert(node4);
		aTree.insert(node5);
		aTree.insert(node6);
		return aTree;
	}
	
	public static void testCompareTree(){
		BinarySearchTree tree1 = constructTree();
		BinarySearchTree tree2 = constructTree2();
		
		System.out.println(tree1.equals(tree2));
		
		tree1 = constructTree();
		tree2 = constructTree();
		
		System.out.println(tree1.equals(tree2));
	}
	
	public static void testConvertTreeToArray(){
		Integer[] result = constructTree().converToIntegerArray();
		
		for(Integer item : result){
			if(item == null){
				System.out.print("null ");
			}
			else{
				System.out.print(item + " ");
			}
		}
	}
	
	public static void testDpAllPossibleBST(){
		List<Integer> intList = new LinkedList<Integer>();
		//intList.add(new Integer(3));
		intList.add(new Integer(2));
		intList.add(new Integer(1));
		List<TreeNode> cache = new ArrayList<TreeNode>();
		List<TreeNode> result = new ArrayList<TreeNode>();
		
	}
	
	private static void constructTree(List<TreeNode> cache, List<Integer> intList, List<TreeNode> result ){
		if(intList.size() == 0){
			Collections.copy(result, cache);
		}
		else
		{
			if(cache.size() == 0){
				for(int i=0; i<intList.size(); i++){
					cache.add(new TreeNode(i));
				}	
			}
			
			for(int index = 0; index<intList.size(); index ++){
				

				List<TreeNode> newCache = new ArrayList<TreeNode>();
				Collections.copy(newCache, cache);
				
				for(TreeNode tree: newCache){
					boolean insertSuccess = tryInsert(tree, intList.get(index).intValue());
					if(insertSuccess){
						List<Integer> newIntList = new ArrayList<Integer>();
						Collections.copy(newIntList, intList);
						newIntList.remove(index);
						constructTree(newCache, newIntList, result);
					}
				}
			}
		}
	}
	
	private static boolean tryInsert(TreeNode tree, int i){
		boolean ret = true;
		TreeNode curNode = tree;
		while(true){
			if(curNode.value == i){
				ret = false;
				break;
			}
			else if(curNode.value > i){
				if(curNode.left == null){
					curNode.left = new TreeNode(i);
					break;
				}
				else
				{
					curNode = curNode.left;
				}
			}
			else
			{
				if(curNode.right == null){
					curNode.right = new TreeNode(i);
					break;
				}
				else
				{
					curNode = curNode.right;
				}
			}
		}
		
		return ret;
	}
	
	
	public static void testGenerateAllPossibleBST(){
		//---- section 1-----//
		ExecutionTimeTracker tracker = new ExecutionTimeTracker();
		String section1_name = "permutation";
		tracker.start(section1_name);
		List<int[]> initContainer = new LinkedList<int[]>();
		int[] array = new int[1];
		int n = 8;
		array[0] = n;
		initContainer.add(array);
		List<int[]> result = Permutation.FactorialPermutation(initContainer, n-1);
//		for(int[] tmpArray : result){
//			System.out.println(Arrays.toString(tmpArray));
//		}
		tracker.end(section1_name);
		
		//-----section 2------//
		String section2_name = "generate_tree";
		tracker.start(section2_name);
		List<BinarySearchTree> treeList = new ArrayList<BinarySearchTree>();
		for(int[] tmpArray : result){
			BinarySearchTree newTree = generateTree(tmpArray);
			boolean foundDuplicated = false;
			for(BinarySearchTree oldTree : treeList){
				if(oldTree.equals(newTree)){
					foundDuplicated = true;
					break;
				}
			}
			if(! foundDuplicated){
				treeList.add(newTree);
			}
		}
		tracker.end(section2_name);
		tracker.stop();
//		System.out.println("Total generated Tree num: " + treeList.size());
//		for(BinarySearchTree tree : treeList){
//			System.out.println("--------");
//			tree.traverseLevel();
//		}
		
	}
	
	public static BinarySearchTree generateTree(int[] array){
		TreeNode root = new TreeNode(array[0]);
		BinarySearchTree newTree = new BinarySearchTree(root);
		
		for(int i = 1; i<array.length; i++){
			TreeNode tmpNode = new TreeNode(array[i]);
			newTree.insert(tmpNode);
		}
		
		return newTree;
		
	}
	
	public static void testLevelTraverse(){
		BinarySearchTree aTree = constructTree();
		aTree.traverseLevel();
	}
	
	public static void testTreeHeight(){
		BinarySearchTree aTree = constructTree();
		int height = aTree.getMaxHeight();
		System.out.println("TreeHeight: " + height);
	}
	/*
	[-1,0,3,-2,4,null,null,8]
			node with value 3
			node with value 8
			*/
	public static void testCommonAncester(){
		CommonAncester ca = new CommonAncester();
		TreeNode root = new TreeNode(-1);
		TreeNode l = new TreeNode(0);
		TreeNode r = new TreeNode(3);
		TreeNode l_l = new TreeNode(-2);
		TreeNode l_r = new TreeNode(4);
		TreeNode r_l = new TreeNode(38);
		TreeNode r_r = new TreeNode(39);
		TreeNode l_l_l = new TreeNode(8);
//		r.left = r_l;
//		r.right = r_r;
//		l.left = l_l;
//		l.right = l_r;
		root.left = l;
		root.right = r;
		l.left = l_l;
		l.right=l_r;
		l_l.left = l_l_l;
		TreeNode bigger = (l.value > r.value)? l : r;
		TreeNode result = ca.lowestCommonAncestor(root, l_r, l_l_l );
		System.out.println("common ancester: " + result.value);
	}

}
