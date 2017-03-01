package bitwise;

public class Hex {
	byte value;
	public Hex(byte b){
		value = b;
	}
	
	public String toString(){
		Byte b = Byte.valueOf(value);
		String b_str = Integer.toHexString(b);
		return b_str;
	}
}
