package heap;

import java.util.Arrays;

public class MinHeap {
	int[] storage;
	int count;
	

	public MinHeap(){
		storage = new int[3];
		init(storage);
		count = 0;
	}
	
	public MinHeap(int[] unsorted){
		storage = new int[unsorted.length];
		init(storage);
		count = 0;
		for(int i = 0; i<unsorted.length; i++){
			add(unsorted[i]);
		}
	}
	
	private void init(int[] s){
		for(int i = 0; i<s.length; i++){
			s[i] = Integer.MAX_VALUE;
		}
	}
	
	public void add(int value){
		if(count >= storage.length){
			int[] newStorage = new int[storage.length *2];
			init(newStorage);
			System.arraycopy(storage, 0, newStorage, 0, storage.length);
			storage = newStorage;
			
		}
		System.out.println("add :" + value + " to position: " + count);
		storage[count] = value;
		count++;
		bubbleUp(count -1);
		//bubbleUpSolution();
	}
	
	public int extractMin(){
		int ret = storage[0];
		swap(0, count-1);
		count --;
		sinkdown();
		return ret;
	}
	public void sinkdown(){
		int index = 0;
		int minIndex = index;
		while(index < count){
			int leftIndex = index*2 + 1;
			int rightIndex = index*2 + 2;
			System.out.println("current min index; " + minIndex + " value: " + storage[minIndex]);
			if(leftIndex < count){
				if(storage[leftIndex] < storage[minIndex])
				{
					System.out.println("left is min, index: " + leftIndex + " value: " + storage[leftIndex]);
					minIndex = leftIndex;
				}
			}
			if(rightIndex <count){
				System.out.println("right is min, index: " + rightIndex + " value: " + storage[rightIndex]);
				if(storage[rightIndex] < storage[minIndex])
				{
					minIndex = rightIndex;
				}
			}
			if(minIndex == index) {
				break;
			}
			else{		
				swap(minIndex, index);
				index = minIndex;
			}
		}
	}
	
	public int size(){
		return count;
	}
	/*  0 1 2 3 4 5 6
	 * [1,2,3,4,5,6,7]
	 * parent = (6-1)/2 = 5/2 = 2
	 */
	public void bubbleUp(int i){
		int index = i;
		while(index >=0){
			System.out.println("current index: " + index + " value: " + storage[index]	);
			int parent = (index-1)/2;
			if(parent >= 0){
				if(storage[parent] > storage[index]){
					System.out.println("swap parent: " + storage[parent] + " with " + storage[index]);
					swap(parent, index);
					index = parent;
				}
				else{
					break;
				}
			}
			System.out.println(toString());
			System.out.println();
		}
	}
	
	public void bubbleUpSolution(){
		int pos = count-1;
		while(pos>0 && storage[pos/2]>storage[pos]){
			int y = storage[pos];
			storage[pos]=storage[pos/2];
			storage[pos/2] = y;
			pos = pos/2;
		}
	}
	private void swap(int a, int b){
		//System.out.println("swappinh" + mH[a] + " and " + mH[b]);
		int temp = storage[a];
		storage[a] = storage[b];
		storage[b] = temp;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = 0; i<count; i++){
			if(i == count-1)
				sb.append(storage[i]);
			else
				sb.append(storage[i]).append(",");
		}
		sb.append("]");
		return sb.toString();
	}
}
