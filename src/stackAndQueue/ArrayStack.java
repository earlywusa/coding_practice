package stackAndQueue;

public class ArrayStack {
	
	int capacity = 10;
	int[] sharedBuffer = new int[capacity *3];
	int[] stackPointers = {0, 0, 0};
	public ArrayStack()
	{
		for(int i = 0; i< sharedBuffer.length; i ++)
		{
			sharedBuffer[i] = 0;
		}
	}
	/**
	 * 
	 * @param stackIndex 0, 1 or 2
	 * @param item
	 */
	public void push(int stackIndex, int item)
	{
		int targetIndex = stackIndex * capacity + stackPointers[stackIndex];
		
		stackPointers[stackIndex] ++; //update stack pointer
		//assign item
		System.out.println("Assign value " + item + " to index: " + targetIndex);
		sharedBuffer[targetIndex] = item;
	}
	
	public int pop(int stackIndex){
		int targetIndex = stackPointers[stackIndex] + stackIndex * capacity;
		int ret = sharedBuffer[targetIndex];
		sharedBuffer[targetIndex] = 0; //reset to initial value
		stackPointers[stackIndex] --;
		return ret;
	}
	
	public int peek(int stackIndex)
	{
		int targetIndex = capacity * stackIndex + stackPointers[stackIndex];
		return sharedBuffer[targetIndex];
	}
	
	public void dump(int stackIndex)
	{
		for (int i = 0; i<stackPointers[stackIndex]; i++)
		{
			System.out.print(" " + sharedBuffer[stackIndex * capacity + i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) 
	{
		ArrayStack shareStack = new ArrayStack();
		shareStack.push(0, 1);
		shareStack.push(0,  2);
		shareStack.push(1, 11);
		shareStack.push(2, 22);
		shareStack.dump(0);
		shareStack.dump(1);
		shareStack.dump(2);
	}
	
}
