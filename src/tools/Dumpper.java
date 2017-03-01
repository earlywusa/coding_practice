package tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Dumpper<T, E> {

	public Dumpper(){
		
	}
	
	public void dump(List<List<T>> a){
		for(int i=0; i<a.size(); i++){
			for(int j=0; j<a.get(i).size(); j++){
				System.out.print(i+ ": [" +a.get(i).get(j) + "] ");
			}
			System.out.println();
		}
	}
	
	public void dumpListOfLinkedList(List<LinkedList<T>> a){
		for(int i=0; i<a.size(); i++){
			for(int j=0; j<a.get(i).size(); j++){
				System.out.print(i+ ": [" +a.get(i).get(j) + "] ");
			}
			System.out.println();
		}
	}
	
	public void dumpListOfString(List<String> a){
		for(String str : a){
			System.out.println(str);
		}
		System.out.println();
	}
	
	public void dump(Map<T, List<E>> a){
		Iterator<T> keys = a.keySet().iterator();
		while(keys.hasNext()){
			T key = keys.next();
			List<E> val = a.get(key);
			for(int i = 0; i< val.size(); i++){
				System.out.print(key + ": [" + val.get(i) + "] ");
			}
			System.out.println();
		}
	}
	public void dumpListOfSet(List<Set<T>> a){
		for(int i=0; i<a.size(); i++){
			System.out.print("[");
			for(T item : a.get(i)){
				System.out.print(item + ",");
			}
			System.out.print("]");
			System.out.println();
		}
	}
	
	public void dumpStack(Stack<E> s){
		System.out.println(Arrays.toString(s.toArray()));
	}
	
	public static void bitPrinter(int input, int endPos)
	{
		Stack<String> printStk = new Stack<String>();
		int mask = 1;
		for(int i = 0; i< endPos; i++)
		{
			int bit = input & mask;
			if(bit == 1) printStk.push("1");
			else printStk.push("0");
			input = input>>1;
		}
		while(! printStk.isEmpty())
		{
			String v = printStk.pop();
			System.out.print(v);
		}
		System.out.println();
	}
	
	public static void bitPrinter(String input){
		String byteSpacing="       ";
		for(char c: input.toCharArray()){
			System.out.println(byteSpacing + c);
			bitPrinter(c, 8);
		}
		
	}

}
