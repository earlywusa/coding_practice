package dynmaicprogramming;

public class AppleSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] appleMap = new int[][]
		{
			{0, 2, 1},
			{3, 4, 5},
			{2, 1, 0}
		};
		int yLength = 3;
		int xLength = 3;
		
		int[][] cache = new int[yLength][xLength];
		for(int y=0; y<cache.length; y++){
			for(int x=0; x<cache[0].length; x++){
				cache[y][x] = Integer.MIN_VALUE;
			}
		}
		
		for(int y = appleMap.length-1; y>=0; y--){
			for(int x = 0; x<appleMap[0].length; x ++){
				System.out.print(appleMap[y][x] + " ");
			}
			System.out.println();
		}
		cache[2][0] = 0;
		
		/*	2 1 0 
		  	3 4 5 
          	0 2 1 
		 * 
		 * d[2,0]=2 
		 * d[2,1]=d[2,0]+1=3
		 * d[1,0]=d[2,0]+3=5
		 * d[1,1]=max{d[2,1], d[1,0]}+4
		 * d[y,x]=max{d[y+1,x] , d[y,x-1]} + v[y,x]
		 */
		for(int y= yLength-1; y>= 0; y --){
			for(int x=0; x<xLength; x++){
				int yPlusOne = y+1;
				int xMinusOne = x-1;
				if(yPlusOne < yLength){
					cache[y][x] = Math.max(cache[yPlusOne][x], cache[y][x]);
				}
				if(xMinusOne >= 0){
					cache[y][x] = Math.max(cache[y][x-1], cache[y][x]);
				}
				cache[y][x] = cache[y][x] + appleMap[y][x];
			}
		}
		
		System.out.println();
		
		for(int y=yLength-1; y>=0; y--){
			for(int x=0; x<xLength; x ++){
				System.out.print(cache[y][x] + " ");
			}
			System.out.println();
		}
		
		
		
	}

}
