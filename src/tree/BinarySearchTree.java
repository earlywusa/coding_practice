package tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree {
	public TreeNode root = null;
	
	public BinarySearchTree(TreeNode root){
		this.root = root;
	}
	
	public void insert(TreeNode aNode){
		TreeNode current = root;
		if(root == null){
			root = aNode;
			return;
		}
		else
		{
			while(true){
				if(current.value > aNode.value){
					if(current.left == null){
						current.left = aNode;
						return;
					}
					else
					{
						current = current.left;
					}
				}
				else if(current.value < aNode.value){
					if(current.right == null){
						current.right = aNode;
						return;
					}
					else
					{
						current = current.right;
					}
				}
				else{
					System.err.println("Duplicated item is NOT accepted, skip and return");
					return;
				}
			}
		}	
	}
	
	//NOT WORKING PROPERLY
	public Integer[] converToIntegerArray(){
		Queue<TreeNode> cache = new ArrayDeque<TreeNode>();
		cache.add(root);
		int maxHeight = getMaxHeight();
		Integer[] ret = new Integer[(int) (Math.pow(2, maxHeight +1))];
		for(int i = 0; i<ret.length; i++){
			ret[i] = Integer.MIN_VALUE;
		}
		int count = 0;
		while(!cache.isEmpty()){
			if(cache.peek() != null){
				TreeNode current = cache.remove();
				ret[count] = current.value;
				count ++;
				if(current.left != null){
					System.out.println("added : " + current.left.value);
					cache.add(current.left);
				}
				else
				{
					ret[count] = null;
					count ++;
				}
				if(current.right != null) {
					System.out.println("added : " + current.right.value);
					cache.add(current.right);
				}
				else
				{
					ret[count] = null;
					count ++;
				}
				
			}
		}
		return ret;
		
	}
	

	public void traverseLevel(){
		int lvlCount = getMaxHeight();
		for(int i = 0; i< lvlCount; i++){
			printTreeAtLevel(i);
		}
	}
	
	private void printTreeAtLevel(int level){
		levelRecursive(0, root, level);
	}
	
	private void levelRecursive(int height, TreeNode current, int targetLevel){
		if(current == null) return;
		if(height == targetLevel) System.out.println("Level: " + height + " value: " + current.value);
		levelRecursive(height + 1, current.left, targetLevel);
		levelRecursive(height + 1, current.right, targetLevel);
	}
	
	public int getMaxHeight(){
		return(maxHeight(root));
	}
	
	private int maxHeight(TreeNode aNode){
		if(aNode == null) return 0;
		
		int heightLeft = maxHeight(aNode.left) + 1;
		int heightRight = maxHeight(aNode.right) + 1;
		return (Math.max(heightLeft, heightRight));
	}
	
	public boolean equals(BinarySearchTree otherTree){
		boolean identical = true;
		
		identical = compare(root, otherTree.root);
		
		return identical;
	}
	
	private boolean compare(TreeNode n1, TreeNode n2){
		if(n1 == null || n2 == null){
			return n1 == n2;
		}
		
		if(n1.value != n2.value){
			return false;
		}
		
		return compare(n1.left, n2.left) && compare(n1.right, n2.right);
		
	}
}
