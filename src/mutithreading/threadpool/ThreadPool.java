package mutithreading.threadpool;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

	BlockingQueue<Task> taskQueue = null;
	List<MyThread> threadList = null;
	public ThreadPool(int numberOfThreads, int maxTaskAllowed){
		taskQueue = new LinkedBlockingQueue<>(maxTaskAllowed);
		threadList = new LinkedList<>();
		for(int i =0; i<numberOfThreads; i++) {
			MyThread myThread = new MyThread(taskQueue);
			threadList.add(myThread);
		}
		
		startAllThreads();
	}
	
	public void submit(Task newTask) {
		this.taskQueue.offer(newTask);
	}
	
	private void startAllThreads() {
		for(MyThread t : threadList) {
			t.start();
		}
	}
	
	public void stopAll() {
		for(MyThread t : threadList) {
			t.doStop();
		}
	}
	
	
}
