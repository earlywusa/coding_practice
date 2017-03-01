package linkedList;

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//LinkedList target = generateList();
		//System.out.println("Original linked list: ");
		//target.dump();
		//testSubList(target, 3);
		//testGetNthItem2Tail(target, 3);
		testRemoveDup();
		
	}
	
	public static void testSubList(LinkedList sll, int n)
	{
		LinkedList tmp =  sll.getSubList(n);
		System.out.println("Sub linked list:");
		tmp.dump();
	}
	
	public static void testRemoveDup(){
		LinkedList target = generateDuplicatedList();
		target.dump();
		
		target.removeDupsNoBuffer();
		target.dump();
	}
	
	public static void testGetNthItem2Tail(LinkedList sll, int n)
	{
		Node tmp = sll.getNodeToTail(n);
		System.out.println("The " + n + "th Node to tail is: " + tmp.value());
	}
	
	public static LinkedList generateList()
	{
		Node head = new Node(5);
		Node n1 = new Node(4);
		Node n2 = new Node(2);
		Node n3 = new Node(7);
		Node n4 = new Node(10);
		Node n5 = new Node(3);
		Node n6 = new Node(8);
		LinkedList sll = new LinkedList(head);
		sll.append(n1);
		sll.append(n2);
		sll.append(n3);
		sll.append(n4);
		sll.append(n5);
		sll.append(n6);
		
		return sll;
	}
	public static LinkedList generateDuplicatedList()
	{
		Node head = new Node(5);
		Node n1 = new Node(4);
		Node n2 = new Node(2);
		Node n3 = new Node(7);
		Node n4 = new Node(10);
		Node n5 = new Node(2);
		Node n6 = new Node(5);
		LinkedList sll = new LinkedList(head);
		sll.append(n1);
		sll.append(n2);
		sll.append(n3);
		sll.append(n4);
		sll.append(n5);
		sll.append(n6);
		
		return sll;
	}

}
