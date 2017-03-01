package leetcode;

public class MaxRectangularMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
		getAreaByIteratingMatrix();
		
	}
	
	public static void getAreaByIteratingMatrix(){
		char[][] testMatrix = genMatrix();
		dump(testMatrix);
		int maxArea = 0;
		for(int y = 0; y<testMatrix.length; y++){
			for(int x=0; x<testMatrix[0].length; x++){
				int tmpArea = getArea(testMatrix, x, y);
				if(maxArea < tmpArea){
					maxArea = tmpArea;
				}
			}
		}
		System.out.println("Max Area=" + maxArea);

		
	}
	
	/*
	 * Algorithm
	 * from a point, from [0,0].
	 * 
	 * for y = 2, check [0,2] [1, 2] [ 2, 2] ... [x, 2]
	 * if the point is 1 on [0,2]
	 * check [0, 1] check [ 0, 0]  
	 * 
	 * if all true, continue check point [1, 2] ,
	 * if the point is 1 on [1, 2]
	 * check [1, 1], check [ 1, 0]
	 * 
	 * continue check point [2, 2],
	 * if point is 1 on [2, 2]
	 * check [2, 1], check [2, 0],
	 * 
	 * 1 0 0 0
	 * 1 1 0 0
	 * 1 1 1 0
	 * [2][0]=1 [2][1]=0 [2][2]=0 [2][3]=0
	 * [1][0]=1 [1][1]=1 [1][2]=0 [1][3]=0
	 * [0][0]=1 [0][1]=1 [0][2]=1 [0][3]=0
	 * 
	 * check [1][0], [0][0]
	 * check [1][1], [0][1]
	 * check [1][2] = 0, return area
	 */
	
	private static int getArea(char[][] source, int xpos, int ypos){
		int area = 0;
		int iteration = 0;
		if(source[ypos][xpos] == '0') return area;
		for(int i = xpos; i <source[0].length; i++){
			if(source[ypos][i] == '1'){
				area ++;
			}
			else{
				break;
			}
		}
		
		for(int j = ypos+1; j< source.length; j++){
			boolean columnValid = true;
			int rowIndexValid = 0;
			for( int i = xpos; i< source[0].length; i++){
				if(iteration > 100) break;
				iteration++;
				System.out.println("Starting at: [y x]=["+j + " " + i + "]");
					for(int tmpj = j; tmpj>= ypos; tmpj--){
						System.out.println("check inbound values: [y][x] = [" + tmpj + "][" + i+"]" );
						if(source[tmpj][i] == '1'){
							System.out.println("[y][x]=" + source[tmpj][i] );		
						}
						else{
							System.out.println("[y][x]=" + source[tmpj][i]);
							columnValid = false;
							break;
						}
					}
					if(!columnValid) break;
					rowIndexValid ++;
					System.out.println("number of row index valid: " + rowIndexValid);
			}

				
				int tmpArea = (j-ypos + 1) * rowIndexValid;
				System.out.println("tmp area: " + tmpArea);
				if(tmpArea > area){
					area = tmpArea;
				}
	
		}
		System.out.println("tmp max Area= " + area);
		return area;
	}
	
	
	public static char[][] genMatrix(){
		char[][] matrix = new char[3][4];
		matrix[0][0] = '0';
		matrix[0][1] = '1';
		matrix[0][2] = '1';
		matrix[0][3] = '1';
		
		matrix[1][0] = '1';
		matrix[1][1] = '1';
		matrix[1][2] = '1';
		matrix[1][3] = '1';
		
		matrix[2][0] = '0';
		matrix[2][1] = '0';
		matrix[2][2] = '0';
		matrix[2][3] = '0';
		
		
		return matrix;
	}
	
	public static void dump(char[][] input){
		System.out.println("y: " + input.length);
		System.out.println("x: " + input[0].length);
		
		for(int y = input.length-1; y>=0; y--){
			for(int x = 0; x<input[0].length; x++){
				System.out.print(input[y][x] + " ");
			}
			System.out.println();
		}
		System.out.println();
		for(int y = input.length-1; y>=0; y--){
			for(int x = 0; x<input[0].length; x++){
				System.out.print("[ " + y+"," + x + " ]=" + input[y][x] + " ");
			}
			System.out.println();
		}
		

	}

}
