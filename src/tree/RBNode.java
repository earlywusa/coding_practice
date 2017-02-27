package tree;

//color 0:black 1:red

public class RBNode {
	color c = color.black; 
	protected RBNode left=null;
	protected RBNode right=null;
	int value;
	
	public RBNode(int value){
		this.value = value;
	}
	
	public RBNode(color c, int value){
		this.c = c;
		this.value = value;
	}
	
	public void setLeft(RBNode n){
		this.left = n;
	}
	
	public void setRight(RBNode n){
		this.right = n;
	}
	
	public void setColor(color c){
		this.c = c;
	}
	
	public RBNode getLeft(){
		return left;
	}
	
	public RBNode getRight(){
		return right;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public static enum color{
		black, red
	}
}
