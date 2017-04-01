package tree;

import java.util.HashMap;
import java.util.Map;

public class GraphNode {
	public int key;
	//public List<GraphNode> neighbors;
	public Map<GraphNode, Integer> neighbors;
	
	public GraphNode(int key){
		this.key = key;
		neighbors = new HashMap<>();
	}
	
	public void addNeighbor(GraphNode gn, int weight){
		neighbors.put(gn, new Integer(weight));
	}
}
