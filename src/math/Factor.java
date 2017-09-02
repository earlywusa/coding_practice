package math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class Factor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factor af = new Factor(496);
		System.out.println(af);
		//System.out.println(Arrays.toString(af.AllFactors) + " reminder: " + af.reminder);
	}
	public int[] Primitivefactors = null;
	public int reminder = 0;
	public int[] AllFactors = null;
	public Factor(int n){
		Primitivefactors = getfactor(n);
		reminder = getReminder(Primitivefactors, n);
		AllFactors = getAllFactors(n);
	}
	public String toString(){
		return Arrays.toString(AllFactors) + " reminder: " + reminder;
	}
	private int[] getfactor(int n){
		if(Prime.isPrime(n)){
			int[] ret = new int[1];
			ret[0] = 1;
			return ret;
		}
		
		int[] primes =  Prime.getPrimes(n);
		//System.out.println("primes: " + Arrays.toString(primes));
		List<Integer> factors = new LinkedList<>();
		factors.add(1);
		int reminder = n;
		int primeIndex = 1;
		while(reminder>1 && primeIndex<primes.length){
			int prime = primes[primeIndex];
			
			if(reminder%prime == 0){
				//System.out.println("try mod prime: " + prime); 
				factors.add(prime);
				reminder /= prime;
			}
			else{
				primeIndex++;
			}
		}
		int[] ret = new int[factors.size()];
		int index = 0;
		for(Integer tmp: factors){
			ret[index++] = tmp.intValue();
		}
		//System.out.println("factors" + Arrays.toString(ret));
		return ret;
	}

	
	private int getReminder(int[] factors, int n){
		int sum = 1;
		for(int factor: factors){
			sum *= factor;
		}
		return n-sum;
	}
	
	private int[] getAllFactors(int n){
		Set<Integer> cache = new HashSet<>();
		cache.add(1);
		int candidate = 2;
		while(candidate<n){
			if(n%candidate == 0){
				if(!cache.contains(candidate)){
					//System.out.println("added : " + candidate);
					cache.add(candidate);
					cache.add(n/candidate);
					
				}
				else break;
			}
			candidate ++;
		}
		
		Iterator<Integer> itr = cache.iterator();
		int[] tmp = new int[cache.size()];
		int index = 0;
		while(itr.hasNext()){
			tmp[index++] = itr.next().intValue();
		}
		
		return tmp;
	}
}
