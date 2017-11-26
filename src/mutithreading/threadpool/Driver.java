package mutithreading.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreadPool tp = new ThreadPool(10,10);
		tp.submit(()->{
			boolean running = true;
			while(running) {
				System.out.println("hello from " + Thread.currentThread().getName());
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					running = false;
				}
			}
		});
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tp.submit(()->{
			boolean running = true;
			while(running) {
				System.out.println("hello from " + Thread.currentThread().getName());
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					running = false;
				}
			}
		});
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tp.stopAll();
		System.out.println("exit main thread..");
	}

}
