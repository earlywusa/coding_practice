package stackAndQueue;

import java.lang.reflect.Array;

public class DiyStack<T> {
	
	private T[] container;
	int cursor = 0;
	int capacity;
	
	public DiyStack(Class<T> c,int size){
		@SuppressWarnings("unchecked")
		final T[] aContainer = (T[]) Array.newInstance(c, size);
		this.container = aContainer;
		this.capacity = size;
		for(int i=0; i<this.capacity; i++){
			container[i] = null;
		}
	}
	
	public void push(T item) throws Exception{
		if(cursor >= capacity){
			throw new Exception("The stack is full");
		}
		container[cursor] = item;
		cursor++;
	}
	
	public T pop(){
		int index = cursor -1;
		T val = container[index];
		cursor --;
		return val;
	}
	
	public T peek(){
		int index = cursor -1;
		T val = container[index];
		return val;
	}
	
	public T peekAt(int index){
		T val = container[index];
		return val;
	}
	
	public boolean isFull(){
		if(cursor == capacity){
			return true;
		}
		
		return false;
	}
	
	
}
