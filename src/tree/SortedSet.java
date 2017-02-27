package tree;
import java.util.*;
public class SortedSet {
	Set<DataPair> diySet;
	public SortedSet(){
		diySet = new TreeSet<DataPair>(new DataComp());
		DataPair p1 = new DataPair('a', new Integer(1));
		DataPair p2 = new DataPair('b', new Integer(2));
		DataPair p3 = new DataPair('c', new Integer(3));
		DataPair p4 = new DataPair('d', new Integer(4));
		DataPair p5 = new DataPair('e', new Integer(5));
		diySet.add(p4);
		diySet.add(p2);
		diySet.add(p1);
		diySet.add(p3);
		diySet.add(p5);
		
	}
	
	public Set<DataPair> getSet(){
		return diySet;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedSet aSet = new SortedSet();
		printSet(aSet.getSet());
		
	}
	
	
	public static void printSet(Set<DataPair> aSet){
		for(DataPair a : aSet){
			System.out.println(a.toString());
		}
	}
	
	//inner data structure
	public class DataPair{
		private char key;
		private int value;
		
		public DataPair(char key, int value){
			this.key = key;
			this.value = value;
		}
		
		public int getValue(){
			return value;
		}
		
		public char getKey(){
			return key;
		}
		
		public void setValue(int value){
			this.value = value;
		}
		
		@Override
		public String toString(){
			return "[" + key + ":" + value +"]";
		}
	}
	
	public class DataComp implements Comparator<DataPair>{

		@Override
		public int compare(DataPair o1, DataPair o2) {
			if(o1.getValue() < o2.getValue()) return 1;
			if(o1.getValue() > o2.getValue()) return -1;
			return 0;
		}
		
	}
}
