package dynamicProgramming;

import java.util.Arrays;
import java.util.ArrayList;

public class RobotInAGrid {

	RobotInAGrid instance = new RobotInAGrid();
	public RobotInAGrid(){
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Is there a path: " + isThereAPath(3));
		int n = 3;
		boolean[][] offMatrix = new boolean[n][n];
		for(int i = 0; i<offMatrix.length; i++){
			Arrays.fill(offMatrix[i], true);
		}
		offMatrix[0][1] = false;
		getPath(offMatrix);
	}
	/*
	 * Question: imagine a robot sitting on the upper left corner of grid with r rows and c columns, 
	 * The robot can only move in two directions, right and down, but certain cells are "off limits" 
	 * such that the robot cannot step on them. Design an algorithm to find a path for the robot 
	 * from the top left to the bottom right. 
	 * 
	 * 
	 */
	
	public static boolean isThereAPath(int n){
		boolean[][] offMatrix = new boolean[n][n];
		for(int i = 0; i<offMatrix.length; i++){
			Arrays.fill(offMatrix[i], false);
		}
		offMatrix[1][1] = true;
		offMatrix[1][0] = true;
		offMatrix[1][2] = true;
		
		return goBack(0, n-1, n, offMatrix);
	}
	
	public static boolean goBack(int y, int x, int n , boolean[][] offLimit){
		System.out.println("Examing: y:" + y + " x:" + x );
		if(!validate(y, x, n, offLimit)) {
			System.out.println("x: " + x + " y: " + y + " off limit");
			return false;
		}
		
		if(y == (n-1) && x == (0)) {
			System.out.println("found robot!");
			return true;
		}
		
		else{
			boolean result = goBack(y+1, x, n, offLimit) || goBack(y, x-1, n, offLimit);
			System.out.println("y: " + y + "x: " + x +" return: " + result);
			return result;
		}
	}
	
	public static boolean validate(int y, int x, int n, boolean[][] offLimit){
		if(x <0 || x >=n ) {
			System.out.println("x invalid");
			return false;
		}
		if(y <0 || y >= n) {
			System.out.println("y invalid");
			return false;
		}
		if(offLimit[y][x]) {
			System.out.println("offlimit");
			return false;
		}
		
		return true;
	}
	
	public static void getPath(boolean[][] maze	){
		ArrayList<Integer> pathRow = new ArrayList<Integer>();
		ArrayList<Integer> pathCol = new ArrayList<Integer>();
		boolean[][] failedPoints = new boolean[maze.length][maze[0].length];
		
		for(int i = 0; i<failedPoints.length; i++){
			Arrays.fill(failedPoints[i], false);
		}
		getPath(maze, maze.length -1, maze[0].length -1, pathRow, pathCol, failedPoints);
		for(int i = 0; i< pathRow.size(); i ++ )
		{
			System.out.println("point: " + pathRow.get(i) + "," + pathCol.get(i));
		}
	}
	
	public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Integer> pathRow, ArrayList<Integer> pathCol, boolean[][] failedPoints){
		
		if (col < 0 || row < 0 || !maze[row][col]) {
		//if (col < 0 || row < 0 ){
			return false;
		}
		
		if(failedPoints[row][col]) return false;
		System.out.println("get path: " + row + "," + col);
		boolean isDest = (row==0) && (col == 0);
		
		if(isDest || getPath(maze, row-1, col, pathRow, pathCol, failedPoints) || getPath(maze, row, col-1, pathRow, pathCol, failedPoints)){
			pathRow.add(row);
			pathCol.add(col);
			return true;
		}
		failedPoints[row][col] = true;
		return false;
	}
	
	

}
