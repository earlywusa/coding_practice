package stackAndQueue;

import java.util.Iterator;
import java.util.Stack;

public class MyQueue {
	Stack<Integer> addStack = null;
	Stack<Integer> removeStack = null;
	
	public MyQueue()
	{
		addStack = new Stack<Integer>();
		removeStack = new Stack<Integer>();
	}
	
	public void enqueue(int i)
	{
		addStack.push(new Integer(i));
	}
	
	public Integer dequeue()
	{
		Integer ret = null;
		if(! removeStack.isEmpty())
		{
			ret = removeStack.pop();
		}
		else
		{
			while(! addStack.isEmpty())
			{
				removeStack.push(addStack.pop());
			}
			if(removeStack.peek() != null)
			{
				ret = removeStack.pop();
			}
		}

		
		return ret;
	}
	
	public int size()
	{
		return addStack.size() + removeStack.size();
	}
	
	public void dump()
	{
		
		Iterator<Integer> tmpItr = addStack.iterator();
		
		while(tmpItr.hasNext())
		{
			System.out.print(" " + tmpItr.next().intValue());
		}
		
		Integer[] tmp = new Integer[removeStack.size()];
		int index =0;
		tmpItr = removeStack.iterator();
		while(tmpItr.hasNext())
		{
			tmp[index] = tmpItr.next().intValue();
			index++;
		}
		for(int i= tmp.length-1; i>=0; i--)
		{
			System.out.print(" " + tmp[i]);
		}
		System.out.println();
		
		
		
	}
}
