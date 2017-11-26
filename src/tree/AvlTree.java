package tree;

import java.util.Collection;

public class AvlTree<T> {
	
	TreeNode<T> root = null;
	int size = 0;
	public AvlTree(){
		root = new TreeNode<T>(true);
	}
	public AvlTree(T val){
		root = new TreeNode<T>(true);
		try {
			root.insert(new TreeNode<T>(val));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public TreeNode<T> insert(T val) throws Exception{
		TreeNode<T> newNode = new TreeNode<T>(val);
		if(root == null){
			root = newNode;
			size++;
		}else{
			root.insert(newNode);
			size++;
		}
		return newNode;
	}
	
	public void traversal(boolean inorder){
		if(inorder){
			inOrderTraversal(root);
		}
		else{
			breadthFirstTraversalNoCache(root);
		}
	}
	
	public boolean addAll(Collection c) {
		for(Object o:c){
			try {
				this.insert((T)o);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
	
	private void inOrderTraversal(TreeNode<T> current){
		if(current != null){
			inOrderTraversal(current.left);
			System.out.println("[Value:" + current.value + ", Height:" + current.height + "]");
			inOrderTraversal(current.right);
		}
		
	}
	
	public void breadthFirstTraversalNoCache(TreeNode<T> root){
		int height = getHeight(root);
		System.out.println("depth = " + height);
		for(int i =0;i<height; i++){
			System.out.println("current depth: " + i);
			traversalBfs(root, i);
			System.out.println();
		}
	}
	
	public void testRotate(){
		root.rotateRight();
	}
	
	private void traversalBfs(TreeNode<T> node, int depth){
		if(node == null || depth<0) return;
		if(depth == 0) System.out.print(node.value + " ");
		traversalBfs(node.left, depth-1);
		traversalBfs(node.right, depth-1);
	}
	
	private int getHeight(TreeNode<T> root){
		return depthFirstTraversal(root);
	}
	
	private int depthFirstTraversal(TreeNode<T> cn){
		if(cn == null) return 0;
		int left = depthFirstTraversal(cn.left) +1;
		int right = depthFirstTraversal(cn.right) +1;
		return Math.max(left, right);
	}
	
	private class TreeNode<T>{
		public TreeNode<T> parent = null;
		public TreeNode<T> left = null;
		public TreeNode<T> right = null;
		public int height = 0;
		public T value = null;
		public boolean isDummy = false;
		
		public TreeNode(boolean dummy){
			isDummy = true;
		}
		public TreeNode(T val){
			this.value = val;
		}
		
		public TreeNode<T> insert(TreeNode<T> node) throws Exception{
			if(this.compareTo(node) == 1){
				if(this.left == null){
					this.left = node;
					node.parent = this;
					updateHeight();
					return node;
				}
				return this.left.insert(node);
			}else if(this.compareTo(node) == -1){
				if(this.right == null){
					this.right = node;
					node.parent = this;
					updateHeight();
					return node;
				}
				return this.right.insert(node);
			}else {
				System.err.println("Duplicated entry encountered.");
				return null;
			}
		}
		
		public void updateHeight(){
			int newHeight = Math.max(getLeftHeight(), getRightHeight()) +1;
			
			if(this.height != newHeight){
				this.height = newHeight;
				if(this.parent != null && this.isDummy == false){
					this.parent.updateHeight();
					
				}
			}
		}
		
		public void toBalance(){
			//left.height > right.height
			if(needToBalance()){
				if((this.left.height - this.right.height)>1){
					/*
					 *             this
					 *              |
					 *           /     \
					 *        left=4   right=2
					 *        
					 *              |
					 *              V
					 *              
					 *            left
					 *              |
					 *          /      \
					 *  left.left=3     this=3|4
					 *                   |
					 *                /     \
					 *     left.right=2|3   right=2
					 *                 
					 */
					if(this.left.left.height >= this.left.right.height){
						this.rotateRight();
					}
					else{
						this.left.rotateLeft();
						this.rotateRight();
					}
				}
				//right.height > left.height
				else{
					//we know that the right tree is higher
					//before decide which to rotate, we need to compare the subtree heights
					if(this.right.right.height >= this.right.left.height){
						this.rotateLeft();
					}
					else{
						this.right.rotateRight();
						this.rotateLeft();
					}
					
				}
			}
		}

		private boolean needToBalance(){
			return Math.abs(this.right.height - this.left.height) >1;
		}

		
		private int getLeftHeight(){
			if(this.left == null) return -1;
			return this.left.height;
		}
		
		private int getRightHeight(){
			if(this.right == null) return -1;
			return this.right.height;
		}
		
		public void rotateRight(){
			if (this.isDummy) return;
			TreeNode<T> preLeftChild = this.left; //reserve for easier arrange
			System.out.println("preleft: " + preLeftChild.value);
			if(parent != null){
				//1, change parent link
				if(this == parent.left){
					parent.left = this.left;
					this.left.parent = parent;
				}else{
					parent.right = this.left;
					this.left.parent = parent;
				}
			}
			//2, change current node's left child to be the right child of this node's left child
			this.left = this.left.right;
			
			//3, change my left child's right child to be me. My parent pointer to my previous left child
			preLeftChild.right = this;
			this.parent = preLeftChild;
			
		}
		
		public void rotateLeft(){
			if (this.isDummy) return;
			TreeNode<T> preRightChild = this.right;
			if(parent != null){
				//1, change parent link
				if(this == parent.left){
					parent.left = this.right;
					this.right.parent = parent;
				}else{
					parent.right = this.right;
					this.right.parent = parent;
				}
			}
			
			this.right = this.right.left;
			
			preRightChild.left = this;
			this.parent = preRightChild;
		}
		
		public boolean equals(TreeNode<T> node){
			if(this == node || this.value.equals(node.value)) return true;
			else return false;
		}
		
		public int compareTo(TreeNode<T> node) throws Exception{
			if(node.value instanceof Comparable){
					Comparable inputVal = (Comparable)(node.value);
					Comparable thisVal = (Comparable)this.value;
					return thisVal.compareTo(inputVal);
			}
			else{
				throw new Exception("Invalid input");
			}
		}	
	}
}

