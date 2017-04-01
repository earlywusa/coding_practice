package tree.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import tree.GraphNode;

public class ShortestPath {

	public static List<GraphNode> constructTestNode(){
		List<GraphNode> ret = new ArrayList<>();
		GraphNode a = new GraphNode('a');
		GraphNode b = new GraphNode('b');
		GraphNode c = new GraphNode('c');
		GraphNode d = new GraphNode('d');
		GraphNode e = new GraphNode('e');
		GraphNode f = new GraphNode('f');
		
		a.addNeighbor(b,5);a.addNeighbor(d,9); a.addNeighbor(e, 2);
		b.addNeighbor(c,2);b.addNeighbor(a,5);
		c.addNeighbor(d,3);c.addNeighbor(b,2);
		d.addNeighbor(c,3);d.addNeighbor(a,9);d.addNeighbor(f,2);
		e.addNeighbor(a,2);e.addNeighbor(f,3);
		f.addNeighbor(d,2);f.addNeighbor(e,3);
		
		ret.add(a);
		ret.add(b);
		ret.add(c);
		ret.add(d);
		ret.add(e);
		ret.add(f);
		return ret;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestPath sp = new ShortestPath();
		List<GraphNode> nodeList = constructTestNode();
		List<GraphNode> path = sp.findPath(nodeList,getNode(nodeList, 'a'), getNode(nodeList, 'f'));
		System.out.print("Path: ");
		for(int i = 0; i<path.size(); i++){
			System.out.print("" + path.get(i) + " " );
		}
		System.out.println();
	}
	
	private static GraphNode getNode(List<GraphNode> list, char key){
		GraphNode n = null;
		for(int i = 0; i< list.size(); i++){
			if(list.get(i).key == key){
				n = list.get(i);
				break;
			}
		}
		return n;
	}
	
	private Binary
	
	PriorityQueue<WeightedNode> pq = null;
	Map<WeightedNode, WeightedNode> parentMap = null;
	Set<WeightedNode> visitedSet = null;
	public ShortestPath(){
		pq = new PriorityQueue<>(new Comparator<WeightedNode>(){
			@Override
			public int compare(WeightedNode a, WeightedNode b){
				
				if(a.currentWeight > b.currentWeight){
					return 1;
				}
				else if(a.currentWeight < b.currentWeight){
					return -1;
				}
				else
					return 0;
			}

		});
		
		parentMap = new HashMap<>();
		visitedSet = new HashSet<>();
		
	}
	
	public List<GraphNode> findPath(List<GraphNode> nodes, GraphNode start, GraphNode target){
		Map<Integer, WeightedNode> nodeMap = new HashMap<>();
		for(int i = 0; i<nodes.size(); i++){
			WeightedNode wnd = new WeightedNode(nodes.get(i));
			pq.add(wnd);
			nodeMap.put(wnd.node.key,wnd);
		}
		dumpPriorityQueue();
		Iterator itr = nodeMap.keySet().iterator();
		while(itr.hasNext()){
			Integer key = (Integer)itr.next();
			System.out.println("key: " + key);
		}
		nodeMap.get(new Integer('c')).currentWeight = 100;
		dumpPriorityQueue();
		
		List<GraphNode> path = new ArrayList<GraphNode>();
		WeightedNode firstNode = pq.poll();
		firstNode.currentWeight = 0;
		visitNode(firstNode);
		
		while(! pq.isEmpty()){
			WeightedNode min = pq.poll();
			visitNode(min);
		}
		
		return path;
	}
	
	private void visitNode(WeightedNode current){
		for(int i = 0; i<current.node.neighbors.size(); i++){
			
		}
	}
	
	
	public void dumpPriorityQueue(){
		Iterator<WeightedNode> itr = pq.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
}
