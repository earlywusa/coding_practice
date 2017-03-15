package tree;

public class TraversalLevelNoCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(3); root.right = new TreeNode(2);
		root.left.left = new TreeNode(5); root.right.left = new TreeNode(9);
		root.left.left.left = new TreeNode(4);
		
		String[] val = new String[]{"1","11","12","111","2222","null","3333"};
		TreeNode tree = TreeConstructor.constructTree(val);
		breadthFirstNoCache(tree);
	}
	/*
	 * height= 0 ---> 4  
	 * number of nodes traversal: 2^(n!) = 2^(n+1) -1 = 2^h
	 * 
	 */
	public static void breadthFirstNoCache(TreeNode root){
		int height = getHeight(root);
		System.out.println("height = " + height);
		for(int i =0;i<height; i++){
			traversalBfs(root, i);
		}
	}
	
	public static void traversalBfs(TreeNode node, int depth){
		if(node == null || depth<0) return;
		if(depth == 0) System.out.println("Node: " + node.value);
		traversalBfs(node.left, depth-1);
		traversalBfs(node.right, depth-1);
	}
	
	public static int getHeight(TreeNode root){
		return depthFirstTraversal(root);
	}

	public static int depthFirstTraversal(TreeNode cn){
		if(cn == null) return 0;
		int left = depthFirstTraversal(cn.left) +1;
		int right = depthFirstTraversal(cn.right) +1;
		return Math.max(left, right);
	}
}
