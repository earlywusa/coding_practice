package dynmaicprogramming;

import java.util.Arrays;

public class MaxHistogramAreaWithArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Find the longest smallest non-zero list. 
		 * 4, 2, 2, 0, 5, 1 <- value
		 * 0  1  2  3  4  5 <- index
		 * 
		 * width = 1	width=2				width=3					width=4					width=5
		 * [0-0] : 4	[0-1] : 2(<4), 2	[0-2] : 2(<4), 2, 2		[0-3] : 2(<4), 2, 2		[0-4] : 2+2+2=6 > 5
		 * [1-1] : 2	[1-2] : 2, 2		[1-3] : 2, 2			[1-4] : 2+2=4 < 5		[1-5] : 2+2 = 4<5
		 * [2-2] : 2	[2-3] : 2			[2-4] : 5				[2-5] : 5
		 * [3-3] : 0	[3-4] : 5			[3-5] : 5
		 * [4-4] : 5	[4-5] : 1(<5), 1
		 * [5-5] : 1
		 * 
		 * width = 6
		 * [0-5] : 2+2+2=6 >5 > 1+1=2
		 * 
		 * width = 1    0 1 2 3 4 5
		 * preArray  = [4,2,2,0,5,1] 
		 * curArray  = [4,2,2,0,5,1]  cur_max=5
		 * 
		 * width = 2
		 * range = [0-1]  curArray[1]=MIN(preArray[0]=4, input[1]=2)=2   2*2=4 < 5 -> cur_max=5
		 * range = [1-2]  curArray[2]=MIN(preArray[1]=2, input[2]=2)=2   2*2=4 < 5 -> cur_max=5
		 * range = [2-3]  curArray[3]=MIN(preArray[2]=2, input[3]=0)=0   0*2=0 < 5 -> cur_max=5
		 * range = [3-4]  curArray[4]=MIN(preArray[3]=0, input[4]=5)=0   0*2=0 < 5 -> cur_max=5
		 * range = [4-5]  curArray[5]=MIN(preArray[4]=5, input[5]=1)=1   1*2=2 < 5 -> cur_max=5
		 * 
		 * curArray = [4,2,2,0,5] preArray = [4,2,2,0,0,1] --> preArray=currentArray
		 *             0  1 2 3 4 5
		 * preArray = [4, 2,2,0,0,1]
		 * 
		 * width = 3
		 * range = [0-2] curArray[2]=MIN(preArray[1]=2, input[2]=2)=2	2*3=6 > 5 -> cur_max=6
		 * range = [1-3] curArray[3]=MIN(preArray[2]=2, input[3]=0)=0	cur_max=6
		 * range = [2-4] curArray[4]=MIN(preArray[3]=0, input[4]=5)=0	cur_max=6
		 * range = [3-5] curArray[5]=MIN(preArray[4]=0, input[5]=1)=0	cur_max=6
		 * 
		 * preArray=curArray=[4,2, 2,2,0,0]
		 * 
		 *
		 */
		
		int[] input=new int[]{4,2,2,0,5,1};
		int[] curArray = Arrays.copyOf(input, input.length);
		int[] preArray = new int[input.length];
		
		System.out.println("input: " + Arrays.toString(input));
		System.out.println("curArray: " + Arrays.toString(curArray));
		System.out.println("preArray: " + Arrays.toString(preArray));
		int maxArea = 0;
		for(int width = 1; width < input.length; width ++){
			System.out.println("Width = " + width);
			for(int start=0; start+width<input.length+1; start++){
				if(width == 1){
					System.out.println("populate preArray when width=1: " + input[start]);
					preArray[start]=input[start];
					maxArea = Math.max(input[start], maxArea);
				}
				else
				{
					int end = start+width -1; //minus 1 to get the index, for example, start=0 + width=2 = 2, 
											  //the wanted index=1;
					System.out.println("start: " + start + " end: " + end );
					System.out.println("compare: " + preArray[start] + " vs " + input[end] );
					curArray[end]=Math.min(preArray[end -1], input[end]);
					System.out.println("tmp max area: " + curArray[end] + " x " + width + " = " + curArray[end] * width);
					maxArea=Math.max(maxArea, curArray[end]*width);
					System.out.println("current maxArea: " + maxArea);
				}
			}
			System.out.println();
			int[] tmp = preArray; //swap array pointer without creating new array.
			preArray = curArray;
			curArray = tmp;
		}
		
		System.out.println("Max Area: " + maxArea);
		
	}

}
