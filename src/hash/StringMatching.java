package hash;

public class StringMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringMatching sm = new StringMatching();
		sm.hash("10");
		sm.find("absfasdfefsaf", "aabccdedf");
	}
	
	
	int base = 256;
	int patLength = 0;
	long patHash = 0;
	long prime = 1L;
	
	public int find(String text, String target){
		patLength = text.length();
		prime = findNextPrime(1000);
		System.out.println("prime: " + prime);
		patHash = hash(text);
		System.out.println("pattern hash: " + patHash);
		return -1;
	}
	/*
	 * input "abc"
	 * a = 98, b = 99, c = 100;
	 * base 256,
	 * 98 99 100
	 * 98 * 256^2 + 99 * 256^1 + 100 * 256^0
	 * 
	 */
	public long hash(String text){
		long tmpHash = 0;
		for(int i = 0; i< patLength; i++){
			tmpHash = (tmpHash * base + text.charAt(i))%prime;
		}
		return tmpHash;
	}
	
	public boolean isPrime(long target){
		if(target <= 0) return false;
		if(target <= 3) return true;
		long i = 5;
		while(i*i < target){
			if(target%i == 0){
				//System.out.println("i: " + i);
				return false;
			}
			i++;
		}
		return true;
	}
	
	public long findNextPrime(long target){
		long upperBound = target *2;
		long value = target +1;
		while(true && upperBound -- > 0){
			if(isPrime(value)){
				break;
			}
			value++;
		}
		return value;
	}
}
