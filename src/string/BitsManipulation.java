package string;

public class BitsManipulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char a = '\u01ff';
//		System.out.println("a: " + a);
//		byte b = (byte)a;
//		String bStr = String.format("%04x",	 b);
//		System.out.println("b: " + bStr);
//		char c = (char)b;
//		System.out.println("c: " + c);
//		
//		strToByteArray("68656c6c6f576f726c64");
		
//		String greeting = "h"; 
//		byte[] greetingBytes = greeting.getBytes();
//		byteArrayDisplay(greetingBytes); // 68656c6c6f576f726c64
//		System.out.println();
//		strToByteArray(greeting);
		
		
		
		int hInt = Integer.parseInt("11001", 2);
		System.out.println("hInt: " + hInt + " char: " + (char)hInt);
		
		System.out.println(decodeHexStr("68656c6c6f576f726c64"));
	}
	
	public static void byteArrayDisplay(byte[] ba){
		for(byte b : ba){
			System.out.print(byteToHex(b));
		}
	}
	
	public static String byteToHex(byte a){
		StringBuffer sb = new StringBuffer();
		sb.append(String.format("%02x", a));
		
		return sb.toString();
	}
	
	public static String decodeHexStr(String s){
		//s = 68656c6c6f576f726c64;
		char[] chars = s.toCharArray();
		int index = 0;
		StringBuilder sb = new StringBuilder();
		while(index < s.length()){
			StringBuilder tmps = new StringBuilder();
			//tmps.append("00");
			tmps.append(chars[index]);
			index++;
			tmps.append(chars[index]);
			index++;
			System.out.println("tmps: " + tmps.toString());
			char c = (char)Integer.parseInt(tmps.toString(), 16);
			sb.append(c);
		}
		
		
		return sb.toString();
	}
	
	public static void strToByteArray(String s){
		char[] sb = s.toCharArray();
		for(char c : sb){
			byte b = (byte)c;
			String bStr = String.format("%02x",	 b);
			System.out.print(bStr);
		}
		
	}

}
