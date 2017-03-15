package tree;

public class TreeConstructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] val = new String[]{"1","2","null"};
		TreeNode tree = constructTree(val);
		
	}
	
	public static TreeNode constructTree(String[] values){
		return genNode(0, values);
	}
	
	public static TreeNode genNode(int index, String[] values){
		if(index<0 || index>=values.length ) return null;
		if(values[index].equals("null")) return null;
		int val = Integer.parseInt(values[index]);
		TreeNode c = new TreeNode(val);
		c.left = genNode(index*2+1, values);
		c.right = genNode(index*2+2, values);
		return c;
	}

}
