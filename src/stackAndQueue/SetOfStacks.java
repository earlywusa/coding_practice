package stackAndQueue;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class SetOfStacks {
	
	public Vector<DiyStack<String>> piles;
	int capacity = 10;
	
	public SetOfStacks(int size){
		piles = new Vector<DiyStack<String>>();
		this.capacity = size;
		DiyStack<String> pile = new DiyStack<String>(String.class,capacity);
		piles.add(pile);
	}
	
	public void push(String item){
		DiyStack<String> lastPile = getLastStack();
		try {
			lastPile.push(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String pop(){
		DiyStack<String> lastPile = getLastStack();
		String item = null;
		try{
			item = lastPile.pop();
		}catch(Exception e){
			e.printStackTrace();
		}
		return item;
	}
	
	public String peek(){
		DiyStack<String> lastPile = getLastStack();
		String item = null;
		try{
			item = lastPile.peek();
		}catch(Exception e){
			e.printStackTrace();
		}
		return item;
	}
	
	public DiyStack<String> getLastStack(){
		int lastIndex = piles.size()-1;
		DiyStack<String> lastPile = piles.get(lastIndex);
		if(lastPile.isFull()){
			DiyStack<String> newPile = new DiyStack<String>(String.class, capacity);
			piles.add(newPile);
			return newPile;
		}else{
			return lastPile;
		}
	}
	
	public void dump(){
		System.out.println("pile size = " + piles.size());
		for(int i = 0; i< piles.size(); i++){
			DiyStack<String> container = piles.get(i);
			for(int j = 0; j<this.capacity ; j++){
				String item = container.peekAt(j);
				if(item != null){
					System.out.println("Index: " + j + " : " + item );
				}else{
					System.out.println("Index: " + j + " : null" );
				}
				
			}
			System.out.println();
		}
		
	}

}
