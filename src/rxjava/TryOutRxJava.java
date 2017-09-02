package rxjava;

import io.reactivex.Flowable;

public class TryOutRxJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printRange();
	}

	public static void printRange(){
		
		Flowable.just("1", "2").map(x ->{
			return x + x;
		})
		.subscribe(x -> System.out.println(x));
	}
}
