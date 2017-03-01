package linkedList;

import java.util.Iterator;

public class RemoveDuplicatedDriver {

	/**
	 * @param args
	 */
	
	private static int itr_num = 0;
	public static void main(String[] args) {
		Node head = new Node(5);
		Node n1 = new Node(4);
		Node n2 = new Node(8);
		Node n3 = new Node(7);
		Node n3_1 = new Node(4);
		Node n4 = new Node(8);
		Node n5 = new Node(3);
		Node n6 = new Node(8);
		LinkedList sll = new LinkedList(head);
		sll.append(n1);
		sll.append(n2);
		sll.append(n3);
		sll.append(n3_1);
		sll.append(n4);
		sll.append(n5);
		sll.append(n6);
		
		dumpSingleLinkedList(sll);
		sll.removeDup();
		dumpSingleLinkedList(sll);
		
	}
	
	public static void dumpSingleLinkedList(LinkedList sll)
	{
		sll.dump();
		
	}

}
