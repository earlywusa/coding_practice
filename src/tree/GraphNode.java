package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphNode implements Comparable<GraphNode> {
	public char key;
	public int dist;
	public List<GraphNode> neighbors;
	public Map<GraphNode, Integer> distMap;
	
	public GraphNode(int key){
		this.key = (char)key;
		distMap = new HashMap<>();
		neighbors = new ArrayList<>();
		this.dist = Integer.MAX_VALUE;
	}
	
	public void addNeighbor(GraphNode gn, int weight){
		neighbors.add(gn);
		distMap.put(gn, new Integer(weight));
	}
	
	@Override
	public int compareTo(GraphNode node){
		
		if(this.dist > node.dist){
			return 1;
		}
		if(this.dist< node.dist){
			return -1;
		}
		
		return 0;
	}
	
	
	@Override
	public String toString(){
		return "[" +  (char)key + " Cost(" + dist+")]";
	}


}
