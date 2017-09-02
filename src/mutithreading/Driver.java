package mutithreading;

import java.util.Random;

public class Driver {
	public static void main(String[] args){
//		TimerTest test = new TimerTest();
//		test.testTimer();
		
		MyBlockingQueue<Integer> bq = new MyBlockingQueue<>();
		
		Runnable r1 = ()->{
			while(true) {	
				int num = new Random().nextInt(100);
				System.out.println("try to add new item: " + num + " "+ Thread.currentThread().getName());
				bq.addItem(num);
				System.out.println("added item: " + num + " " + Thread.currentThread().getName());
			}
		};
		Runnable r2 = ()->{
			while(true) {	
				int num = new Random().nextInt(100);
				System.out.println("try to add new item: " + num + " " + Thread.currentThread().getName());
				bq.addItem(num);
				System.out.println("added item: " + num + " " + Thread.currentThread().getName());
			}
		};
		Thread t1 = new Thread(r1);
		t1.start();
		Thread t2 = new Thread(r2);
		t2.start();
		try {
			t1.join();
			t2.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
