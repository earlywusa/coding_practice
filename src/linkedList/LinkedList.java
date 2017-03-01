package linkedList;

public class LinkedList {
	Node head = null;
	
	public LinkedList(Node head)
	{
		this.head = head;
	}
	
	public void append(Node newNode)
	{
		Node c = head;
		while(c.getNext() != null) c = c.getNext();
		
		c.setNext(newNode);
	}
	
	public void delete(int value)
	{
		Node c = head;
		if(c.value() == value) 
		{
			head = head.getNext();
		}
		
		while(c.getNext() != null)
		{
			if(c.getNext().value()  == value)
			{
				c.setNext(c.getNext().getNext());
				return;
			}
			c = c.getNext();
		}
	}
	
	public void dump()
	{
		Node c = head;
		while(c != null)
		{
			System.out.print(" " + c.value());
			c = c.getNext();
		}
		System.out.println();
	}
	
	public void dump(int iteration)
	{
		int count = 0;
		Node c = head;
		while(c != null)
		{
			if(count < iteration)
			{
				System.out.print(" " + c.value());
				c = c.getNext();
			}
			else
			{
				break;
			}
			count ++;	
		}
		System.out.println();
	}
	
	public void removeDup()
	{
		
		Node c = head.getNext();
		Node p = head;
		while(c != null)
		{
			Node runner = head;
			while(runner != c)
			{
				if(runner.value() == c.value())
				{
					p.setNext(runner.getNext());
					break;
				}
				p = runner;
				runner = runner.getNext();
			}
			c = c.getNext();
		}
	}
	
	public void removeDupsNoBuffer(){
		//rewrite the solution to warm up
		Node current = head;
		Node runner = null;
		int watchdog = 0;
		while(current != null && watchdog < 1000){
			System.out.println("checking current: "  + current.value());
			runner = current.getNext();
			while(runner != null && runner.getNext() != null && watchdog < 1000){
				System.out.println("    sublooping; " + runner.value());
				if(runner.getNext().value() == current.value()){
					System.out.println("delete: " + runner.getNext().value());
					if(runner.getNext().getNext() != null){
						runner.setNext( runner.getNext().getNext());
					}
					else
					{
						runner.setNext(null);
					}
				}
				runner = runner.getNext();
				watchdog++;
			}
			current = current.getNext();
			watchdog++;
		}
	}
	
	public LinkedList getSubList(int n)
	{
		LinkedList ret = null;
		Node current = head;
		for(int i = 0; i< n; i++)
		{
			if(current.getNext() != null)
			{
				current = current.getNext();
			}
		}
		ret = new LinkedList(current);
		
		
		return ret;
	}
	
	public Node getNodeToTail(int n)
	{
		Node p1 = head;
		Node p2 = head;
		
		for(int i = 0; i< n-1; i++)
		{
			if(p2.getNext() != null)
			{
				p2 = p2.getNext();
			}
		}
		while(p2.getNext() != null){
			p1= p1.getNext();
			p2= p2.getNext();
		}
		return p1;
	}
	
	public Node getHead()
	{
		return head;
	}
}
