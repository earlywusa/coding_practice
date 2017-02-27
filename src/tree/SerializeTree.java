package tree;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] input = new String[]{"1", "2", "3", "null", "6"};
//		Queue<String> inputQ = new LinkedList<String>();
//		for(String s : input){
//			inputQ.offer(s);
//		}
//		TreeNode root = buildTree(inputQ);
//		traverse(root);
		BiTreeNode test = new BiTreeNode(null, 0);
		test.run();
	}
	
	
	public static TreeNode constructTree(String[] input){
		Queue<String> inputQ = new LinkedList<String>();
		for(String s : input){
			inputQ.offer(s);
		}
		TreeNode root = buildTree(inputQ);
		return root;
	}
	
	public static TreeNode buildTree(Queue<String> q){
		if(q == null || q.size() == 0) return null;
		Queue<TreeNode> treeNodeQueue = new LinkedList<TreeNode>();
		TreeNode rootNode;
		String root = q.poll();
		if(root.equalsIgnoreCase("null")) {
			rootNode = null;
			return rootNode;
		}
		else {
			rootNode = new TreeNode(Integer.parseInt(root));
		}
		treeNodeQueue.offer(rootNode);
		
		while(! treeNodeQueue.isEmpty()){
			TreeNode cur = treeNodeQueue.poll();
			if(! q.isEmpty()){
				TreeNode left = createNode(q);
				TreeNode right = createNode(q);
				if(left != null) {
					cur.left = left;
					treeNodeQueue.offer(left);
				}
				if(right != null){
					cur.right = right;
					treeNodeQueue.offer(right);
				}
			}
		}
		return rootNode;
	}
	
	public static TreeNode createNode(Queue<String> q){
		if(q.peek() != null){
			String val = q.poll();
			if( ! val.equalsIgnoreCase("null")){
				int val_int = Integer.parseInt(val);
				return new TreeNode(val_int);
			}
		}
		return null;
	}
	
	public static void traverse(TreeNode root){
		Queue<TreeNode> cache = new LinkedList<TreeNode>();
		cache.offer(root);
		StringBuffer sb = new StringBuffer();
		while(!cache.isEmpty()){
			TreeNode cur = cache.poll();
			if(cur != null){
				sb.append(cur.value).append(" ");
				cache.offer(cur.left);
				cache.offer(cur.right);
			}
			else{
				sb.append("null ");
			}


		}
		System.out.println(sb.toString());
	}
}
