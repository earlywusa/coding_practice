package tree;

public class BiTreeNode {
	public BiTreeNode parent = null;
	public BiTreeNode left = null;
	public BiTreeNode right = null;
	public int val;
	
	BiTreeNode(BiTreeNode parent, int val){
		this.parent = parent;
		this.val = val;
	}
	
	public static void run(){
		BiTreeNode root = new BiTreeNode(null, 1);
		BiTreeNode two = new BiTreeNode(root, 2);
		BiTreeNode six = new BiTreeNode(root, 6);
		root.left = two; root.right = six;
		
		BiTreeNode three = new BiTreeNode(two, 3);
		BiTreeNode four = new BiTreeNode(two, 4);
		two.left = three; two.right = four;
		
		BiTreeNode five = new BiTreeNode(four, 5);
		four.left = five;
		
		BiTreeNode seven = new BiTreeNode(six, 7);
		six.right = seven;
		
		BiTreeNode next = nextNode(seven);
		String ret = (next == null ? "abc" : "def");
		System.out.println(ret);
	}
	
	public static BiTreeNode nextNode(BiTreeNode node){
		System.out.println("visited: " + node.val);
		boolean visitedRoot = false;
		if(node.left != null ){
			return node.left;
		}
		else if(node.left == null && node.right != null){
			return node.right;
		}
		else
		{
			BiTreeNode p = node.parent;
			if ( node == p.left && p.right != null)return p.right;
			else{
				node = p;
				p=p.parent;
				while(node != p.left){
					if( node.parent == null ) {visitedRoot = true; break;}
					node = p;
					p=p.parent;
					
					
					
				}
				if(visitedRoot) return null;
				return p.right;
			}

		}
	}
}
