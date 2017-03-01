package linkedList;

public class AddDriver {

	public static int limit = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node hundred_a = new Node(5);
		Node ten_a = new Node(1);
		Node digit_a = new Node(3);
		
		Node hundred_b = new Node(4);
		Node ten_b = new Node(9);
		Node digit_b = new Node(5);
		
		LinkedList a = new LinkedList(digit_a);
		a.append(ten_a);
		a.append(hundred_a);
		
		LinkedList b = new LinkedList(digit_b);
		b.append(ten_b);
		b.append(hundred_b);
		b.append(new Node(9));
		a.dump();
		b.dump();
		
		LinkedList sum = sum(a, b);
		if(sum != null) sum.dump();
	}
	
	public static LinkedList sum(LinkedList a, LinkedList b)
	{
		LinkedList sum = null;
		
		Node currentNodeA = a.head;
		Node currentNodeB = b.head;
		int carry = 0;
		
		while(currentNodeA != null || currentNodeB != null || carry != 0)
		{
			if(limit > 100) return null;
			limit ++;
			Node validA = currentNodeA; Node validB = currentNodeB;
			if(currentNodeA == null)
			{
				validA = new Node(0);
			}
			if(currentNodeB == null)
			{
				validB = new Node(0);
			}
			
			int tmpSum = validA.value() + validB.value() + carry; carry = 0;
			if(tmpSum > 9)
			{
				tmpSum = tmpSum - 10;
				carry = 1;
			}
			System.out.println("Sum = " + tmpSum + " carry = " + carry);
			if(sum == null)
			{
				sum = new LinkedList(new Node(tmpSum));
			}
			else
			{
				sum.append(new Node(tmpSum));
			}
			
			currentNodeA = validA.getNext();
			currentNodeB = validB.getNext();
		}
		
		return sum;
	}

}
