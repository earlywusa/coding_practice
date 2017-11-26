package mutithreading.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class MyThread extends Thread {

	private BlockingQueue<Task> blockingQueue = null;
	private boolean stop = false;
	public MyThread(BlockingQueue<Task> bq) {
		blockingQueue = bq;
	}
	
	public void run() {
		while(! stop) {
			try {
				Task task = blockingQueue.poll(Long.MAX_VALUE, TimeUnit.SECONDS);
				task.execute();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("stop the thread: " + Thread.currentThread().getName());
				stop = true;
			}
		}
		System.out.println("exits thread: " + Thread.currentThread().getName());
	}
	
	public void doStop() {
		this.interrupt();
	}
}
