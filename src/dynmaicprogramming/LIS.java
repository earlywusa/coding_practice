package dynmaicprogramming;

public class LIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] set = {5, 3, 4, 8, 6, 7};
		/*
		 * d(0):5 = 1 {}+5
		 * d(1):3 = 1 {}+3
		 * d(2):4 = 2 {3}+4
		 * d(3):8 = 3 {3,4}+8
		 * d(4):6 = 3 {3,4,8}||{3,4}+6
		 * d(5):7 = 4 {3,4,6}+7
		 * 
		 * storage map:hash
		 * idx lisCount 
		 * 
		 * for i=0 to 5
		 * 	for j = 0 to i -1
		 *		if set[i] > set[j]
		 *			hash[i] = max{hash[j], hash[j] + 1}
		 * return hash[i]
		 */
		
		int[] hash = new int[set.length];
		hash[0] = 1;
		for(int i =1; i<hash.length; i++){
			hash[i] = Integer.MIN_VALUE;
		}
		
		for(int i = 0; i<set.length; i++){
			for(int j=0; j< i; j++){
				if(set[i] > set[j]){
					hash[i] = Math.max(hash[j]+1, hash[i]);
				}
				else{
					hash[i]= Math.max(hash[j], hash[i]);
				}
			}
		}
		
		for(int i = 0; i<hash.length; i ++ ){
			System.out.println("d_" + i + " : " + hash[i]);
		}
	}

}
