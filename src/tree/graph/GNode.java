package tree.graph;

import java.util.LinkedList;
import java.util.List;

public class GNode {

	public String id;
	public int value;
	public List<GNode> neighs;
	
	public GNode(String id, int value) {
		neighs = new LinkedList<>();
		this.id = id;
		this.value = value;
	}
}
