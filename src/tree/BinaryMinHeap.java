package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class BinaryMinHeap<T extends Comparable<T>> {

	public static void main(String[] args) {
//		HashMap<GraphNode, String> testMap = new HashMap<>();
//		GraphNode item1 = new GraphNode('a');
//		GraphNode item2 = new GraphNode('b');
//		testMap.put(item1, "avalue");
//		testMap.put(item2, "bvalue");
//		Iterator<GraphNode> keyItr = testMap.keySet().iterator();
//		while(keyItr.hasNext()){
//			System.out.println(keyItr.next());
//		}
//		testMap.remove(item2);
//		keyItr = testMap.keySet().iterator();
//		while(keyItr.hasNext()){
//			System.out.println(keyItr.next());
//		}
		
		// TODO Auto-generated method stub
		BinaryMinHeap<GraphNode> minHeap = new BinaryMinHeap<GraphNode>();
		int[] input = new int[]{3,1,6,4,2};
		for(int i = 0; i<input.length; i++){
			GraphNode node = new GraphNode(input[i]);
			//node.weight = new Random().nextInt(20);
			node.dist = i*10;
			minHeap.add(node);
		}
		System.out.println(minHeap.dumpHash());
		System.out.println(minHeap);//System.out.println(minHeap.dumpHash());
		
		GraphNode target = minHeap.get(2);
		System.out.println(target);
		target.dist = 58;
		minHeap.rearrange(target);
		
		System.out.println(minHeap.dumpHash());
		System.out.println(minHeap);//System.out.println(minHeap.dumpHash());
		
//		System.out.println(minHeap.extractMin());
//		System.out.println(minHeap);//System.out.println(minHeap.dumpHash());
//		
//		System.out.println(minHeap.extractMin());
//		System.out.println(minHeap);//System.out.println(minHeap.dumpHash());
//		System.out.println(minHeap.extractMin());
//		System.out.println(minHeap);//System.out.println(minHeap.dumpHash());
//		System.out.println(minHeap.extractMin());
//		System.out.println(minHeap);//System.out.println(minHeap.dumpHash());
//		System.out.println(minHeap.extractMin());
//		System.out.println(minHeap);//System.out.println(minHeap.dumpHash());
	}
	int capacity;
	T[] storage;
	int size;
	Map<T, Integer> hash;
	
	public BinaryMinHeap(){
		int capacity = 10;
		storage = (T[])new Comparable[capacity];
		size = 0;
		hash = new HashMap<T, Integer>();
	}
	
	public void rearrange(T obj){
		int index = hash.get(obj);
		if(obj.compareTo(storage[index/2]) == -1){
			bubbleUp(index);
		}else{
			bubbleDown(index);
		}
		
	}
	
	public T get(int location){
		if(location <1 || location > size){
			return null;
		}
		return storage[location];
	}
	
	
	public void add(T item){
		if(size + 1 >= storage.length){
			storage=resize();
		}
		size++;
		storage[size] = item;
		hash.put(item, size);
		bubbleUp(size);
	}
	
	public T extractMin(){
		T ret = null;
		if(size >= 1){
			ret = storage[1];
			//System.out.println("remove ret: "  + ret);
			
			swap(1, size);
			size --;
			
			bubbleDown(1);
			hash.remove(ret);
			//System.out.println(dumpHash());
		}
				
		return ret;
	}
	
	public T[] resize(){
		 return Arrays.copyOf(storage, storage.length * 2);
	}
	
	public void bubbleUp(int i){
		int currentIndex = i;
		int pIndex = parentIndex(i);
		while(pIndex>0){
			if(storage[currentIndex].compareTo(storage[pIndex]) == -1){
				swap(currentIndex, pIndex);
			}
			currentIndex = pIndex;
			pIndex = parentIndex(currentIndex);
		}
	}
	
	public void bubbleDown(int i){
		int countGuard = 0;
		int leftIndex = i*2;
		int rightIndex = i*2 +1;
		int currentIndex =i;
		int smallerIndex = currentIndex;
		while(leftIndex <= size && countGuard++<20 ){
			if(storage[smallerIndex].compareTo(storage[leftIndex]) == 1){
				smallerIndex = leftIndex;
			}
			if(rightIndex <= size){
				if(storage[smallerIndex].compareTo(storage[rightIndex]) == 1){
					smallerIndex = rightIndex;
				}
			}
			
			if(smallerIndex != currentIndex){
				System.out.println("");
				swap(smallerIndex, currentIndex);
				currentIndex = smallerIndex;
				leftIndex = currentIndex *2;
				rightIndex = currentIndex * 2+1;
			}
			
			
		}
	}
	
	private void swap(int a, int b){
//		System.out.println("swap: i=" + a + " value=" + storage[a] + " i="+b + " value=" + storage[b] );
		T tmp = storage[a];
		storage[a] = storage[b];
		storage[b] = tmp;
		
//		System.out.println("put: " + storage[a] + " to position: " + a);
//		System.out.println("put: " + storage[b] + " to position: " + b);
		hash.put(storage[a], a);
		hash.put(storage[b], b);
	}
	
	private int parentIndex(int i){
		return i/2;
	}
	
	public boolean isEmpty(){
		if(size > 1) return false;
		return true;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<= size; i++){
			sb.append("index: " + i+ " -- " + storage[i] + "\n");
		}
		return sb.toString();
	}
	
	public String dumpHash(){
		StringBuilder sb = new StringBuilder();
		Iterator<T> itr = hash.keySet().iterator();
		while(itr.hasNext()){
			T key = itr.next();
			
			sb.append("[" + key + "," + hash.get(key)+"] ");
		}
		return sb.toString();
	}
}
