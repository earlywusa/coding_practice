package rxjava;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.*;

public class LambdaExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LambdaExpression lambdaExpression = new LambdaExpression();
		
		MathOperation addition = (int a, int b) ->  { return a + b;};
		SayMessage sayMsg = message -> { System.out.println(message);};
		
		System.out.println(lambdaExpression.operate(100, 22, addition));
		sayMsg.sayMessage("a message");
		
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.forEach(LambdaExpression::print);
	}
	
	public static void print (String a){
		System.out.println(a);
	}
	
	interface MathOperation {
		int operation(int a, int b);
	}

	interface SayMessage {
		void sayMessage(String message);
	}
	
	int operate(int a, int b, MathOperation mathOperation){
		return mathOperation.operation(a, b);
	}
}
