package math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{-3, 4, 3, 90};
		int target = 0;
		int[] result = twoSum(nums, target);
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] twoSum(int[] nums, int target) {
	    int[] ret = new int[2];
	    if(nums == null) return ret;
	    if(nums.length <3) return ret;
	     HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
	    
	     for(int i = 0; i<nums.length ; i++){
             int sub = target - nums[i];
             Integer sub_index = cache.get(sub);
             if(sub_index != null){
                 ret[0] = sub_index.intValue();
                 ret[1] = i;
                 return ret;
             }
             cache.put(new Integer(nums[i]), new Integer(i)); //overwrite when duplicated

	     }
	     
	     Iterator<Integer> keys = cache.keySet().iterator();
	     while(keys.hasNext()){
	         Integer key = keys.next();
	         int num = key.intValue();
	         int sub = target - num;
	         Integer sub_index = cache.get(sub);
	         if(sub_index != null){
	             ret[0] = sub_index.intValue();
	             ret[1] = cache.get(num);
	             return ret;
	         }
	     }
	     
	     return ret;
	    }

}
