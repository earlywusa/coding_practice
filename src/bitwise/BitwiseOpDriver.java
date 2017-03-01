package bitwise;

import java.util.LinkedList;
import java.util.Stack;

import tools.Dumpper;

public class BitwiseOpDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//replaceBits(1024, 21, 2, 6);
		
		//bitPrinter(8, 4);
		//bitPrinter(4<<1, 4);
		//replaceBits2(73, 6, 2, 5);
		//System.out.println(binaryToString(0.75));
		//System.out.println(printBinaryToString(0.75));
		//System.out.println(flipBitToWin(1773));
		testNextNum();
	}
	
	public static void testNextNum(){
		String s = "11011001111100";
		int val = stringToBinary(s);
		int posOfTrailingZero = findTrailingZero(val);
		System.out.println("val: " + val + " pos of trailing zero: " + posOfTrailingZero);
		nextNum(val, 1);
	}
	
	public static int flipBitToWin(int n){
		int longest = 0;
		int currentLongest = 0;
		int mask = 1;
		bitPrinter(n, 16);
		bitPrinter(mask, 16);
		boolean flipped = false;
		while(n !=00){
			int currentBit = n & mask;
			if(currentBit == 1){
				
				currentLongest ++;
				System.out.println("current bit == 1, currentLongest: " + currentLongest);
			}
			else
			{
				if(!flipped){
					flipped = true;
					System.out.println("flipped");
					currentLongest ++;
				}
				else
				{
					System.out.println("reset: current longest: " + currentLongest + " previous longest: " + longest);
					flipped = false;
					longest = Math.max(currentLongest, longest);
					currentLongest=0;
				}
			}
			n=n>>1;
		}
		longest = Math.max(currentLongest, longest);
		return longest;
	}
	
	public static String printBinaryToString(double d){
		if(d>=1 || d<=0) return "ERROR";
		StringBuilder ret = new StringBuilder(".");
		double frac = 0.5;
		while (d > 0){
			if(ret.length() > 32) return "ERROR";
			if(d >= frac){
				d = d - frac;
				ret.append(1);
			}
			else
			{
				ret.append(0);
			}
			frac /=2;
		}
		return ret.toString();

	}

	public static String binaryToString(double d){
		double base = 2^-1;
		int naturalNumPart = 0;
		if(d > 1){
			naturalNumPart = (int)d;
			System.out.println("natural number part: " + naturalNumPart);
			
		}
		double decimalPart = d - (double)naturalNumPart;
		System.out.println("decimal number part: " + decimalPart);
		int power = 1;
		StringBuilder result = new StringBuilder();
		while(true){
			double powerProduct = Math.pow(0.5, power);
			
			System.out.println("PowerProduct: " + powerProduct + " power: " + power);
			if(power > 31){
				result = new StringBuilder("ERROR");
				return result.toString();
			}
			if(  (decimalPart - powerProduct) > 0){
				System.out.println("append 1, continue..");
				
				power ++;
				
				result.append("1");
				
			}
			else if( (decimalPart -powerProduct) == 0){
				System.out.println("append 1, stop..");
				result.append("1");
				break;
			}
			else
			{
				System.out.println("append 0, continue..");
				power ++;
				result.append("0");
			}
			decimalPart = decimalPart - powerProduct; 
		}
		return result.toString();
	}
	

	public static int replaceBits2(int n, int m, int i, int j){
		assert j>i;
		int ret = 0;
		System.out.print("n: "); bitPrinter(n, 8);
		System.out.print("m: "); bitPrinter(m, 8);
		/*
		/*
		 * n = 0100 1001 = 64+1 = 73
		 * m = 0110 = 6
		 * i = 2
		 * j = 5
		 * 0100 1001
		 * 0001 1000
		 * 0101 1001
		 */
		
		//clean up position 2,3,4,5 for n
		//need a mask like   1100 0011
		//generate all 1s
		int left = ~0;
		left = left<<(j+1); // 1100 0000
		System.out.println("left: " );bitPrinter(left, 8);
		//generate 0000 0011
		int right = (1<<i)-1;
		int mask = left | right;
		System.out.println("mask: "); bitPrinter(mask, 8);
		ret = n & mask;
		System.out.println("ret: "); bitPrinter(ret, 8);
		ret = ret | (m << i);
		System.out.println("ret: "); bitPrinter(ret, 8);
		return ret;
		
	}
	
	public static int replaceBits(int n, int m, int pos_start, int pos_end)
	{
		//make a mask
		int max = ~0;
		//bitPrinter(max, 10);
		int mask = max << pos_end; //111...111000000
	    mask = mask + 3; //111...111000011
	    bitPrinter(mask, 10);
		m = m<<pos_start;
		n = (n & mask) | m;
		bitPrinter(n, 15);
		
		return n;
	}
	
	public static int nextNum(int input, int large){
		int endpos = 16;
		bitPrinter(input, endpos);
		//example: 
		/*        43210
		 * input: 10100
		 * output: 
		 * 10100->11100 (change rightmost non trailing zero to one)
		 *        
		 * 11100->11001 (shift all the ones to the end)
		 * 
		 * p = 3;
		 * c0 = 2;
		 * c1 = 1;
		 */
		int c = input;
		int c0 = 0;
		int c1 = 0;
		
		while(  ( c & 1 ) == 0 && ( c1 == 0) ){
			System.out.println("Increment 0 ...");
			c0 ++;
			c >>=1;
		}
		
		while( ( c & 1 ) == 1 ){
			System.out.println("Increment 1 ...");
			c1 ++;
			c >>=1;
		}
		
		int p = c0 + c1; 
		
		System.out.println("P: " + p + " c0: " + c0 + " c1: " + c1);
		
		//mask: 1111 0000
		//targ: 0010 1100
		//and : 0010 0000
		int mask = ~0 << (c0+c1);
		
		System.out.print("input:" );bitPrinter(input, endpos);
		input = input & mask;
		//set p to 1;
		int pmask = 1 << p;
		System.out.print("pmask:" );bitPrinter(pmask, endpos);
		input = input | pmask;
		bitPrinter(input, 12);
		for(int i = 0; i< c1-1; i++){
			int c1mask = 1 << i;
			input = input | c1mask;
		}
		System.out.print("after c1 mask:" );bitPrinter(input, endpos);
		return 0;
		
	}
	
	public static int findRightMostNonTrailingZero(int in){
		//find first one, than continue looking. 
		//find first zero.
		//return number of shift. 
		int trailingZeroCount = 0;
		int mask = 1;
		while(true){
			if((in & mask) != 1){
				trailingZeroCount ++;
			}
		}
		
		
	}
	
	public static int findTrailingZero(int in){
		int mask = 1;
		int pos = 0;
		while((in & mask) == 0){
			pos ++;
			in = in >>> 1;
		}
		//need to return the position -1 to indicate the last index that is a '0'
		return pos - 1;
	}
	
	public static int stringToBinary(String s){
		int multiplier = 0;
		int result = 0;
		char one = '1';
		
		for(int i = s.length() -1; i>= 0; i--){
			if(s.charAt(i) == one ){
				result +=  Math.pow(2, multiplier);
			}
			multiplier ++;
		}
		
		return result;
	}
	
	public static void bitPrinter(int input, int endPos)
	{
		
		Stack<String> printStk = new Stack<String>();
		int mask = 1;
		for(int i = 0; i< endPos; i++)
		{
			int bit = input & mask;
			if(bit == 1) printStk.push("1");
			else printStk.push("0");
			input = input>>1;
		}
		while(! printStk.isEmpty())
		{
			String v = printStk.pop();
			System.out.print(v);
		}
		System.out.println();
	}
}
