package dynmaicprogramming;

import java.util.Arrays;

public class ProductExceptItself {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[]{2,3,4,5};
		int[] output = product(input);
		System.out.println(Arrays.toString(output));
	}

	/*
	 * [2,3,4,5]
	 * output:
	 * 0: 1
	 * 1: 1*2=2
	 * 2: 2*3=6
	 * 3: 6*4=24
	 * [1,2,6,24]
	 * 
	 * 3: tmp=1             1*output[3] =1*24=24
	 * 2: tmp=1* num[3]=5,  5*output[2] =5*6 =30
	 * 1: tmp=5* num[2]=20, 20*output[1]=20*2=40
	 * 0: tmp=20*num[1]=60, 40*output[0]=60*1=60
	 * [60,40,30,24]
	 * 
	 */
	
	public static int[] product(int[] nums){
		int[] output = new int[nums.length];
		
		output[0] = 1;
		
		for(int i = 1; i< nums.length; i++){
			output[i] = nums[i-1] * output[i-1]; 
		}
		System.out.println(Arrays.toString(output));
		int tmp =1;
		for(int i = nums.length-1; i>= 0; i--){
			output[i] = tmp * output[i];
			tmp *= nums[i];
		}
		
		return output;
	}
}
