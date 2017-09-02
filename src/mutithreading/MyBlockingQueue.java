package mutithreading;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {
	
	private LinkedList<E> storage = null;
	private AtomicInteger count = null;
	private Lock qLock = null;
	public MyBlockingQueue() {
		storage = new LinkedList<>();
		count = new AtomicInteger(0);
		qLock = new ReentrantLock();
	}
	
	public void addItem(E item) {
		try{
			qLock.lock();
			int sleepSec = new Random().nextInt(10);
			storage.add(item);
			count.incrementAndGet();
			TimeUnit.SECONDS.sleep(sleepSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			qLock.unlock();
		}
		
	}
	
	public E poll() {
		E item = null;
		try {
			qLock.lock();
			if(count.get()>0) {
				item =storage.poll();
				count.getAndDecrement();
			}
		}finally {
			qLock.unlock();
		}
		return item;
	}
	
	public int size() {
		return count.get();
	}
}
