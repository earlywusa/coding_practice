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
import java.util.Stack;

import tree.BinaryMinHeap;
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
		List<GraphNode> ret = new ArrayList<>();
	
		ShortestPath sp = new ShortestPath();
		List<GraphNode> nodeList = constructTestNode();
		List<GraphNode> path = sp.findPath(nodeList,getNode(nodeList, 'a'), getNode(nodeList, 'd'));
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
	
	
	BinaryMinHeap<GraphNode> bmh = null;
	Map<GraphNode, GraphNode> parentMap = null;
	Set<GraphNode> visitedSet = null;

	public ShortestPath(){
		bmh = new BinaryMinHeap<>();
		parentMap = new HashMap<>();
		visitedSet = new HashSet<>();
		
	}
	
	public List<GraphNode> findPath(List<GraphNode> nodes, GraphNode start, GraphNode target){
		List<GraphNode> path = new ArrayList<>();
		start.dist = 0;
		for(int i = 0; i<nodes.size(); i++){
			bmh.add(nodes.get(i));
		}
		GraphNode current = null;
		while(!bmh.isEmpty()){
			current = bmh.extractMin();
			visitNode(current);
			dump();
		}
		GraphNode parent = parentMap.get(target);
		Stack<GraphNode> spath = new Stack<>();
		spath.push(target);spath.push(parent);
		while(parent != start){
			parent = parentMap.get(parent);
			spath.push(parent);
		}
		while(!spath.isEmpty()){
			path.add(spath.pop());
		}
		return path;
	}
	
	private void visitNode(GraphNode current){
		if(current == null) return;
		System.out.println("start processing: " + current);
		visitedSet.add(current);
		for(int i = 0; i<current.neighbors.size(); i++){
			GraphNode neighbor = current.neighbors.get(i);
			if(!visitedSet.contains(neighbor)){
				System.out.println("visiting " + neighbor.key + " from " + current);
				int distance = current.distMap.get(neighbor) + current.dist;
				if(neighbor.dist > distance){
					neighbor.dist = distance;
					parentMap.put(neighbor, current);
					System.out.println("update distance of " + neighbor.key + " to " + neighbor.dist);
					bmh.rearrange(neighbor);
				}
			}
		}
	}
	
	public void dump(){
		System.out.println("Min Heap:");
		System.out.println(bmh);
		
		System.out.println("visited set:");
		Iterator<GraphNode> itr = visitedSet.iterator();
		while(itr.hasNext()){
			System.out.print("{"+itr.next().toString() + "} ");
		}
		System.out.println();
		System.out.println("parent map: ");
		Iterator<GraphNode> pitr = parentMap.keySet().iterator();
		while(pitr.hasNext()){
			GraphNode key = pitr.next();
			System.out.println(key + " parent: " + parentMap.get(key));
		}
		System.out.println();
	}
	
}
