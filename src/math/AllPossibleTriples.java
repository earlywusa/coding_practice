package math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import tools.Tuple;

public class AllPossibleTriples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1000;
		Map<Double, List<Tuple<Integer, Integer>>> map = new HashMap<Double, List<Tuple<Integer, Integer>>>(); 
		
		for(int i = 1; i<= n; i++){
			for(int j = 1; j<= n; j++ ){
				double result = Math.pow(i, 3) + Math.pow(j, 3);
				List<Tuple<Integer, Integer>> l = map.get(result);
				if(l == null){
					l = new ArrayList<Tuple<Integer, Integer>>();
					map.put(result, l);
				}
				l.add(new Tuple<Integer, Integer>(i, j));
			}
		}
		dump(map);
	}
	
	public static void dump(Map<Double, List<Tuple<Integer, Integer>>> m){
		int count = 0;
		for(Entry<Double, List<Tuple<Integer, Integer>>> e : m.entrySet()){
			Double key = e.getKey();
			List<Tuple<Integer, Integer>> l = e.getValue();
			for(Tuple<Integer, Integer> t : l){
				System.out.println("Key: " + key + " pair: " + t.getT() + " : " +t.getE());
				if(count++ >= 20) break;
			}
			if(count++ >= 20) break;
		}
	}

}
