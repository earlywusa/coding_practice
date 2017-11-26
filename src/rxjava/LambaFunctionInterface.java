package rxjava;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambaFunctionInterface {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
		Predicate<Integer> predicate = (n) -> n>3;
		
		
		eval(list, predicate);
		eval(list, n -> n%2 == 0);
		
		Vehicle aCar = (Integer n) -> {Vehicle.blowHorn();};
		aCar.doSomethingElse(10);
	}
	
	public static void eval(List<Integer> list, Predicate<Integer> predicate){
		for(Integer a: list){
			if(predicate.test(a)){
				System.out.println(a);
			}
		}
	}
	
	
	public class TestPredicate implements Predicate{

		@Override
		public boolean test(Object t) {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
	
	public interface Vehicle {
		default void print(String message){
			System.out.println("This is a vehicle." + message);
		}
		
		static void blowHorn(){
			System.out.println("Blowing horn.");
		}
		
		
		public void doSomethingElse(Integer i);
	}
}


