package tree.graph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimMst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public GNode findMst(GNode root) {
		GNode ret = null;
//		PriorityQueue<GNode> pq = new PriorityQueue<>(new GNodeComp());
		PriorityQueue<GNode> pq = new PriorityQueue<>((a,b)->a.value-b.value);
		
		return ret;
	}
	
	public class GNodeComp implements Comparator<GNode>{

		@Override
		public int compare(GNode o1, GNode o2) {
			if (o1.value == o2.value)
			return 0;
			return o1.value-o2.value > 0 ? 1: -1;
		}
		
	}

}
