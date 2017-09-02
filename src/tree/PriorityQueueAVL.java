package tree;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class PriorityQueueAVL<T> implements Queue<T>{

	private AvlTree<T> storage;
	public PriorityQueueAVL(){
		storage = new AvlTree<T>();
	}
	public void dump(){
		storage.traversal(true);
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return storage.size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return storage.size==0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		for(Object o:c){
			this.add((T)o);
		}
		return true;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		try {
			storage.insert(e);
			return true;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean offer(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}
	



	
	
}
