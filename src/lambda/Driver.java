package lambda;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Driver {
	public static void main(String[] arg){
		String[] input = new String[10000];
		Random random = new Random();
		for(int i = 0; i<input.length; i++){
			int next = random.nextInt(1000);
			input[i] = String.valueOf(next);
		}
		String target = String.valueOf(random.nextInt(1000));
		
		find(target, input);
		
		List<String> list = new LinkedList<String>();
		list.add("aaa"); list.add("bbb");
		String[] array = new String[list.size()];
		array = list.toArray(array);
		System.out.println(Arrays.toString(array));
		
		testArraysParameter(new String[]{"a","b"});
	}
	
	public static void find (String target, String... list){
		Date c1 = new Date();
		boolean a = Arrays.asList(list).contains(target);
		long diff = new Date().getTime() - c1.getTime();
		System.out.println("as array solution: " + a + " " + diff);
		//or 
		Date c2 = new Date();
		boolean b = Arrays.stream(list).anyMatch(x->x.equals(target));
		diff = new Date().getTime() - c2.getTime();
		System.out.println("lambda solution: "+ b + " " + diff);
	}
	
	public static void testArraysParameter(String... a){
		System.out.println("a: " + Arrays.toString(a));
	}
}
