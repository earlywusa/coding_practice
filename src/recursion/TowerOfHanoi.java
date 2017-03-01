package recursion;

import java.util.ArrayDeque;
import java.util.Stack;

import tools.Dumpper;

public class TowerOfHanoi {
	Dumpper<Integer, Integer> dumpper = new Dumpper<Integer, Integer>();
	Stack<Integer> x, y, z;
	public TowerOfHanoi(){
		x = new Stack<Integer>();
		y = new Stack<Integer>();
		z = new Stack<Integer>();
	}
	
	public void doHanoi(int n){
		for(int i = n ; i> 0; i--){
			x.push(i);
		}
		dump();
		//fMoveN(x, y, z);
		fMoveN(n, x, y, z);
		dump();
	}
	
	public void fMove1(Stack<Integer> x, Stack<Integer> y ){
		Integer disk = x.pop();
		y.push(disk);
	}
	
	public void fMove2(Stack<Integer> x, Stack<Integer> y, Stack<Integer> z){
		Integer move1 = x.pop();
		z.push(move1);
		Integer move2 = x.pop();
		y.push(move2);
		Integer move3 = z.pop();
		y.push(move3);	
	}
	
	public void fMove3(Stack<Integer> x, Stack<Integer> y, Stack<Integer> z){
		fMove2(x, z, y);
		fMove1(x, y);
		fMove2(z, y, x);
	}
	public void fMoveN(int n, Stack<Integer> x, Stack<Integer> y, Stack<Integer> z){
		if(n <=0){
			return;
		}
		else if(n == 1){
			fMove1(x, y);
		}
		else if(n == 2){
			fMove2(x, y, z);
		}
		else {
			fMoveN(n-1, x, z, y);
			fMove1(x, y);
			fMoveN(n-1, z, y, x);
		}
	}
	
	public void dump(){
		System.out.println();
		System.out.println("Stack x: ");
		dumpper.dumpStack(x);
		System.out.println("Stack y: ");
		dumpper.dumpStack(y);
		System.out.println("Stack z: ");
		dumpper.dumpStack(z);
		System.out.println();
	}

}


