package mutithreading;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

public class TimerTest {

	public void testTimer(){
		TimerTask task1 = new TimerTask(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("print a timer task stuff 1111");
			}
			
		};
		
		TimerTask task2 = new TimerTask(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("print a timer task stuff 2222");
			}
			
		};
		
		
	   Timer aTimer = new Timer();
	   aTimer.schedule(task1, 10*1000);
	   aTimer.schedule(task2, 5*1000);
	   
	   List<TimerTask> list = new CopyOnWriteArrayList<TimerTask>();
	   list.add(task1);
	   list.add(task2);
	   int count = 0;
	   while(true){
		   try {
			Thread.sleep(1000);
			System.out.println(++count);
			for(TimerTask ts : list){
				System.out.println("scheduled execution time: " + ts.scheduledExecutionTime());
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	}
}
