package bitwise;

public class ParityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long val = Long.parseLong("11010111", 2);
		System.out.println("long: " + val);
		System.out.println(parity(val));
	}
	
	public static short parity(long x) {
		System.out.println("before   " + Long.toBinaryString(x));
		long b = x >>>32;
		x ^= b;
		System.out.println("shift 32 " + Long.toBinaryString(b) + " XORed: " + Long.toBinaryString(x));
		b = x >>>16;
		x ^= b;
		System.out.println("shift 16 " +Long.toBinaryString(b) + " XORed: " + Long.toBinaryString(x));
		b = x >>>8;
		x ^= b;
		System.out.println("shift 8  " +Long.toBinaryString(b) + " XORed: " + Long.toBinaryString(x));
		b = x >>>4;
		x ^= b;
		System.out.println("shift 4  " +Long.toBinaryString(b) + " XORed: " + Long.toBinaryString(x));
		b = x >>>2;
		x ^= b;
		System.out.println("shift 2  " +Long.toBinaryString(b) + " XORed: " + Long.toBinaryString(x));
		b = x >>>1;
		x ^= b;
		System.out.println("shift 1  " +Long.toBinaryString(b) + " XORed: " + Long.toBinaryString(x));
		return (short) (x & 0x1);
	}

}
