package linkedList;

public class Node{
	private int value;
	private Node next = null;
	
	public Node(int value)
	{
		this.value = value;
	}
	
	public void setNext(Node iNode)
	{
		this.next = iNode;
	}
	
	public Node getNext()
	{
		return next;
	}
	
	public void setValue(int iValue)
	{
		value = iValue;
	}
	
	public int value()
	{
		return value;
	}
	
	public Node moveForward(int step)
	{
		Node ret = next;
		for(int i = 0; i< step-1; i++)
		{
			ret = ret.getNext();
		}
		
		return ret;
	}
	
}
