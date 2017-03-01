package stackAndQueue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

import treeStruct.BinaryTree;
import treeStruct.Node;

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//testSort();
		//testSetDiyStack();
		//testBfs();
		//testMaxDepth();
		//testPrintNodeAtLevel();
		//testPrintNodeLevelByLevel();
		testPriorityQueue();
	}
	
	public static void testPriorityQueue(){
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		//String[] array = new String[]{"aa","b","c"};
		Integer[] array = new Integer[]{2,3,6,8,2,1};
		List<Integer> l = Arrays.asList(array);
		q.addAll(l);
		
		System.out.println(Arrays.toString(q.toArray()));
	}
	
	public static void testAbstractQueue(){
		AbstractQueue<Node> aQueue = new AbstractQueue<Node>();
		Node aNode = new Node(10, null, "root");
		
		
	}
	
	public static void testPrintNodeLevelByLevel(){
		BinaryTree bt = new BinaryTree();
		bt.genTestTree();
		
		//bt.printLevelByLevel(); //without storage
		bt.bfsTraverseWithBuffer(); //with storage
	}
	
	
	public static void testPrintNodeAtLevel(){
		BinaryTree bt = new BinaryTree();
		bt.genTestTree();
		
		bt.bfsTraversal();
		
		Node root = bt.getRoot();
		
		
		bt.printNodeAtLevel(root, 2);
	}
	
	public static void testMaxDepth(){
		BinaryTree bt = new BinaryTree();
		bt.genTestTree();
		
		Node root = bt.getRoot();
		int max = bt.getMax(root);
		System.out.println("max depth = " + max);
		
		int max2 = bt.maxDepth(root);
		System.out.println("max2 depth = " + max2);
		
	}
	
	public static void testBfs(){
		BinaryTree bt = new BinaryTree();
		bt.genTestTree();
		bt.inOrderTraversal();
		
		bt.bfsTraversal();
	}
	
	public static void testSetDiyStack(){
		
		SetOfStacks aSetStk = new SetOfStacks(3);
		aSetStk.push("A1");
		aSetStk.push("A2");
		aSetStk.push("A3");
		aSetStk.push("B1");
		
		aSetStk.dump();
	}
	public static void testSort(){
		
		MyQueue testQueue = new MyQueue();
		testQueue.enqueue(1);
		testQueue.enqueue(2);
		testQueue.enqueue(3);
		testQueue.dump();
		testQueue.dequeue();
		testQueue.dump();
		
		
		Stack<Integer> test = new Stack<Integer>();
		test.push(new Integer(22));
		test.push(new Integer(2));
		test.push(new Integer(52));
		test.push(new Integer(12));
		test.push(new Integer(22));
		
		dump(test);
		Stack<Integer> sorted = sort(test);
		dump(sorted);
		
		System.out.println("Test diy stack");
		
		DiyStack<String> aDiyStack = new DiyStack<String>(String.class, 10);
		try {
			aDiyStack.push("aabbcc");
			System.out.println("Previously pushed item is: " + aDiyStack.pop());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Stack<Integer> sort(Stack<Integer> iStack)
	{
		Stack<Integer> ret = new Stack<Integer>();
		
		while(! iStack.isEmpty())
		{
			int tmp = iStack.pop().intValue();
			
			while(! ret.isEmpty() && ret.peek()> tmp)
			{
				System.out.println("compare: " + ret.peek() + " vs " + tmp);
				iStack.push(ret.pop());
			}
			System.out.println("push: " + tmp);
			ret.push(tmp);
		}
		
		return ret;
	}
	
	public static void dump(Stack<Integer> iStack)
	{
		Iterator<Integer> itr = iStack.iterator();
		while(itr.hasNext())
		{
			int val = itr.next().intValue();
			System.out.print(" " + val);
			
		}
		System.out.println();
	}
}
