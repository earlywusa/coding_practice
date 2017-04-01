package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestPairs {
/**
 * NOT WORKING....
 * @param args
 */
	public static void main(String[] args) {
		int[] nums1 = new int[]{1, 7, 11};
		int[] nums2 = new int[]{2, 3, 6};
		SmallestPairs p = new SmallestPairs();
		p.kSmallestPairs(nums1, nums2, 5);
		
		Comparator<SmallestPairs> c = new Comparator<SmallestPairs>(){

			@Override
			public int compare(SmallestPairs o1, SmallestPairs o2) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		};
		
		PriorityQueue<int[]> mq = new PriorityQueue<>((int[] a, int[]b)->(a[0]+a[1])-(b[0]+b[1]));
		mq = new PriorityQueue<int[]>(new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]+o1[1] - o2[0]-o2[1];
			}
		});
		mq.add(nums2);mq.add(nums1);
		System.out.println(mq.peek()[0]+ " " + mq.peek()[1]);

	}
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		
        List<int[]> store = new ArrayList<>();
        int[] first = new int[]{0, 0};
        store.add(first);
        
        
        for(int i =  0; i< store.size(); i++){
        	int[] pair = store.get(i);
        	System.out.print("("+nums1[pair[0]] + "," + nums2[pair[1]] + ") ");
        }
        System.out.println();
        Tuple pair1 = new Tuple(0, 1, nums1[0], nums2[1]);
        Tuple pair2 = new Tuple(1, 0, nums1[1], nums2[0]);
        boolean done = false;
        while(store.size()<k && !done){
        	
        	Tuple targetPair;
        	boolean updatePair1 = true;
            if(pair1.sum <= pair2.sum){
            	targetPair = pair1;
           
            }
            else{
                targetPair = pair2;
                updatePair1 = false;
            }
            System.out.println("add pair: " + targetPair.pos1 + "," + targetPair.pos2 + " updatePair1? " + updatePair1);
            int[] last = store.get(store.size() -1 );
            if( targetPair.pos1 == last[0] && targetPair.pos2 == last[1] ){
            	System.out.println("duplicate pair, skip");
            }else{
            	int[] newEntry = new int[2];
            	newEntry[0] = targetPair.pos1;
            	newEntry[1] = targetPair.pos2;
            	store.add(newEntry);
            	
            	if(updatePair1){
	            	if(pair1.pos2+1 <= nums2[nums2.length -1]){
	            		pair1.pos2++;
	            	}
	            	else{
	            		if(pair1.pos1 +1 <= nums1[nums1.length -1]){
	            			pair1.pos2 = 0;
	            			pair1.pos1 ++;
	            			System.out.println("pair1 becomes: " + pair1.pos1 + "," + pair1.pos2);
	            		}
	            		else{
	            			System.out.println("pair1 out of range: " + pair1.pos1 + "," + pair1.pos2);
	            			done = true;
	            		}
	            	}
            	}else{
            		if(pair2.pos1+1 < nums1[nums1.length -1]){
            			pair2.pos1 ++;
            		}
            		else{
            			if(pair2.pos2+1 <= nums2[nums2.length -1]){
            				pair2.pos1 = 0;
            				pair2.pos2 ++;
            				System.out.println("pair2 becomes: " + pair2.pos1 + "," + pair2.pos2);
            			}
            			else{
	            			System.out.println("pair2 out of range: " + pair2.pos1 + "," + pair2.pos2);
	            			done = true;
	            		}
            		}
            	}
            }
            	
        }
        System.out.println();
        for(int i =  0; i< store.size(); i++){
        	int[] pair = store.get(i);
        	try{
        	System.out.print("("+nums1[pair[0]] + "," + nums2[pair[1]] + ") ");
        	}
        	catch(Exception e){
        		
        	}
        }
        return store;
    }
    
    public int getSum(int[] pair){
        return pair[0] + pair[1];
    }

    /**
     * pos1 : pos in array 1
     * pos2 : pos in array 2
     * @author esuo
     *
     */
    private class Tuple{
    	public int pos1, pos2, sum;
    	public int v1, v2;
    	public Tuple(int pos1, int pos2, int v1, int v2){
    		this.pos1 = pos1;
    		this.pos2 = pos2;
    		this.v1 = v1;
    		this.v2 = v2;
    		this.sum = v1+v2;

    	}
    	
    	public boolean equals(Tuple target){
    		if(target.sum == this.sum){
    			if(target.pos1 == this.pos1 && target.pos2==this.pos2){
    				return true;
    			}
    		}
    		return false;
    	}
    }
}
