package math;


public class LargeNumProductSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		doProductSum(1,2, 2016);
		doProductSum(4,8, 2016);
		doProductSum(7,8, 2016);
		doProductSum(6,8, 2016);
		doProductSum(5,3, 2000);
		doProductSum(4,6, 2000);
	}
	
	public static void doProductSum(int i1, int i2, int digit){
		int num1=i1;
		int num2=i2;
		int digitCount=digit;
		int d = num1*num2;
		int d0 = d%10;
		int d1 = (d-d0)/10;
		System.out.println("num 1: " + i1 + " num 2: " + i2 + " repeat: " + digit);
		//System.out.println(sumUpResult("6776")); //77*88
		//System.out.println(sumUpResult("689976")); //777*888
		System.out.println(sumUpResult("123456789")); //777...77 (9) * 888...88(9)
		
		int[] reminderTotal= new int[]{0}; 
		int numberOfAdd = 0;
		int sum=0;
		for(int i = 1; i<=digitCount; i++){
			int lastReminderDigit = takeLastDigit(reminderTotal);
			
			int tmpResult = (d0 * i) + (d1 * (i-1)) + lastReminderDigit;
			//System.out.println("tmpResult: " + tmpResult + " LastReminderDigit: " + lastReminderDigit);
			int lastDigit = fetchLastDigit(tmpResult);
			int tmpReminder = (tmpResult - lastDigit)/10;
			addToReminder(reminderTotal, tmpReminder);
			sum += lastDigit;
			numberOfAdd++;
			//System.out.println("tmpResult: " + tmpResult + " reminder: " + reminderTotal[0] + " current sum: " + sum);
		}
		//System.out.println("-------------");
		for(int i = digitCount; i>0; i--){
			int lastReminderDigit = takeLastDigit(reminderTotal);
			int tmpResult = (d0 * (i-1)) + d1 * i + lastReminderDigit;
			//System.out.println("tmpResult: " + tmpResult + " LastReminderDigit: " + lastReminderDigit);

			int lastDigit = fetchLastDigit(tmpResult);
			int tmpReminder = (tmpResult - lastDigit)/10;
			addToReminder(reminderTotal, tmpReminder);
			sum += lastDigit;
			numberOfAdd++;
			//System.out.println("tmpResult: " + tmpResult + " reminder: " + reminderTotal[0] + " current sum: " + sum);
		}
		
		//BigInteger result = new BigInteger((d * digitCount)+"");
		//System.out.println("result: " + result.toString() + " digit sum: " + sumUpResult(result.toString()));
		System.out.println("sum = " + sum + " add count: " + numberOfAdd);
		System.out.println();
	}
	
	public static void addToReminder(int[] currentReminder, int addon){
		//System.out.println("add tmp reminder: " + currentReminder[0] + " + " + addon);
		int value = currentReminder[0] + addon;
		currentReminder[0] = value;
	}
	
	public static int takeLastDigit(int[] currentReminder){
		int value = currentReminder[0];
		int ret = value % 10;
		currentReminder[0] = (value -ret )/10;
		return ret;
	}
	
	public static int fetchLastDigit(int result){
		String ret = String.valueOf(result);
		return Character.getNumericValue(ret.charAt(ret.length()-1));
	}
	
	public static int sumUpResult(String input){
		int sum = 0;
		for(int i = 0; i<input.length(); i++){
			sum += Character.getNumericValue(input.charAt(i));
		}
		
		return sum;
	}

}
