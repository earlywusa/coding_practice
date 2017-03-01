package stackAndQueue;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Vector;


public class AbstractQueue<T> implements Queue<T>{
	Vector<T> container;
	int increase = 100;
	int pos = 0;
	@SuppressWarnings("unchecked")
	public AbstractQueue(){
//		container = (T[]) Array.newInstance(c, increase);
//		for(int i = 0;i <container.length; i++){
//			container[i]=null;
//		}
		container = new Vector<T>();
	}

	public int size() {
		// TODO Auto-generated method stub
		return pos;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(pos == 0){
			return false;
		}
		return true;
	}

	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		try{
			T item = (T) o;
			for(int i=0; i<container.size(); i++){
				if(container.contains(item)){
					return true;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}

	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public T[] toArray() {
		// TODO Auto-generated method stub
		return (T[])container.toArray();
	}

	public T[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public boolean add(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean offer(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	public T poll() {
		// TODO Auto-generated method stub
		return null;
	}

	public T element() {
		// TODO Auto-generated method stub
		return null;
	}

	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
