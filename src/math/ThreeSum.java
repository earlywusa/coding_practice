package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	/**
	 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

		Note: The solution set must not contain duplicate triplets.
		
		For example, given array S = [-1, 0, 1, 2, -1, -4],
		
		A solution set is:
		[
		  [-1, 0, 1],
		  [-1, -1, 2]
		]
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSum o = new ThreeSum();
		List<List<Integer>> ans = o.threeSum(new int[]{-2, 0, 0, 2, 2});
		ans.forEach(x->{
			System.out.println(Arrays.toString(x.toArray()));
		});
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		if(nums == null || nums.length <3) return new ArrayList<>();
		   Arrays.sort(nums);
		   List<List<Integer>> ret = new ArrayList<>();
		   for(int i = 0; i< nums.length-2; i++){
			   if(i>0){
				   if(nums[i]==nums[i-1]){
					   continue;
				   }
			   }
			   int l = i+1, r = nums.length -1;
			   while(l<r){
				   int s = 0-nums[i];
				   if(nums[l] + nums[r] == s){
					   ret.add(Arrays.asList(nums[i], nums[l], nums[r]));
					   l++; r--;
					   while(l<r && nums[l] == nums[l-1]) l++;
					   while(l<r && nums[r] == nums[r+1]) r--;
				   }
				   else if(nums[l] + nums[r] < s){
					   l ++;
				   }
				   else{
					  r --;
				   }
			   }
		   }
		      
		   return ret;
    }
	
	

}
