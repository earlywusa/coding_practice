package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BinaryMinHeap<T extends Comparable<T>> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	int capacity;
	T[] storage;
	int size;
	
	public BinaryMinHeap(){
		int capacity = 10;
		storage = (T[])new Comparable[capacity];
		size = 0;
	}
	
	public void add(T item){
		if(size + 1 >= storage.length){
			storage=resize();
		}
		size++;
		storage[size] = item;
		bubbleUp();
	}
	
	public T[] resize(){
		 return Arrays.copyOf(storage, storage.length * 2);
	}
	
	public void bubbleUp(){
		int currentIndex = size;
		int pIndex = parentIndex(size);
		while(pIndex>0){
			if(storage[currentIndex].compareTo(storage[pIndex]) == -1){
				swap(currentIndex, pIndex);
			}
			currentIndex = pIndex;
			pIndex = parentIndex(currentIndex);
		}
	}
	
	public void bubbleDown(){
		int leftIndex = 1*2;
		int rightIndex = 1*2 +1;
		int currentIndex =1;
		int smallerIndex = currentIndex;
		while(leftIndex <= size ){
			if(storage[smallerIndex].compareTo(storage[leftIndex]) == 1){
				smallerIndex = leftIndex;
			}
			if(storage[smallerIndex].compareTo(storage[rightIndex]) == 1){
				smallerIndex = rightIndex;
			}
			
			if(smallerIndex != currentIndex){
				swap(smallerIndex, currentIndex);
				
			}
		}
	}
	
	private void swap(int a, int b){
		T tmp = storage[a];
		storage[a] = storage[b];
		storage[b] = tmp;
	}
	
	private int parentIndex(int i){
		return i/2;
	}
}
