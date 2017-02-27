package hmac;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Sha256 {
	public static String encode(String input){
		System.out.println("input id: " + input);
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(md == null)return "INVALID_ID";
		md.update(input.getBytes());
		
		byte byteData[] = md.digest();
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<byteData.length; i++){
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		System.out.println("Hex format : " + sb.toString());
		return sb.toString();
	}
	
	public Sha256(){
		
	}
	
	public static String hash(String message, String key){
		int blockSize = 64; //64 bytes
		byte[] orignalKeyByteArray = key.getBytes();
		byte[] keyByteArray = new byte[blockSize];
		for(int i = 0; i< blockSize ; i++){
			keyByteArray[i] = (new Integer(0)).byteValue();
		}
		
		if(orignalKeyByteArray.length > 64){
			System.arraycopy(orignalKeyByteArray, 0, keyByteArray, 0, blockSize);
		}
		else{
			
			int fillUpLength = blockSize - orignalKeyByteArray.length;
			System.out.println("fill up length: " + fillUpLength);
			System.out.println("orignal message: ");
			System.out.println(byteArrayToHex(orignalKeyByteArray));
			System.out.println("inital message: ");
			System.out.println(byteArrayToHex(keyByteArray));
			System.arraycopy(orignalKeyByteArray, 0, keyByteArray, fillUpLength, orignalKeyByteArray.length);
			
		}
		
		System.out.println(byteArrayToHex(keyByteArray));
		
		
		
		return "";
	}
	
	public static String byteArrayToHex(byte[] a){
		StringBuilder sb = new StringBuilder(a.length *2);
		for(byte b:a){
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();
	}
}
