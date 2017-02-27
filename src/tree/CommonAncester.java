package tree;

public class CommonAncester {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
			1) traverse all node at left, if both nodes are found, go down to left
			2) traverse all node at right, if both nodes are found, go down to right
			3) if two nodes are located on two sides. return current node
		*/

		if(root == p || root == q) return root;
		
		if(findNode(root.left, p)){
			if(findNode(root.left, q)){
				return lowestCommonAncestor(root.left, p, q);
			}
			else{
				return root;
			}
		}
		else if(findNode(root.left, q)){
			if(findNode(root.left, p)){
				return lowestCommonAncestor(root.left, p, q);
			}
			else{
				return root;
			}
		}
		else if(findNode(root.right, p)){
			if(findNode(root.right, q)){
				return lowestCommonAncestor(root.right, p, q);
			}
			else{
				return root;
			}
		}
		else if(findNode(root.right, q)){
			if(findNode(root.right, p)){
				return lowestCommonAncestor(root.right, p, q);
			}
			else{
				return root;
			}
		}
		else{
			return root;
		}	
		
    }
	
	public  boolean findNode(TreeNode current, TreeNode n){
		if(current == null){
			return false;
		}
		if(current == n){
			return true;
		}

		return findNode(current.left, n) || findNode(current.right, n);
	}
}
