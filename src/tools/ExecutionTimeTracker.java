package tools;

import java.util.*;
import java.util.Map.Entry;

public class ExecutionTimeTracker {
	HashMap<String, TimeEntry> records;
	long total = 0;
	
	public ExecutionTimeTracker(){
		records = new HashMap<String, TimeEntry>();
	}
	
	public void start(String name){
		records.put(name, new TimeEntry(getCurrentTime()));
	}
	
	public void end(String name){
		TimeEntry entry = records.get(name);
		entry.setStop(getCurrentTime());
		total+=entry.timeSpan();
		System.out.println("TIME RECORD: " + name + " : " + entry.timeSpan() + "(ms)");
		
	}
	
	public void stop(){
		Iterator<String> itr = records.keySet().iterator();
		System.out.println("Dumpping Execution Time:" + total);
		while(itr.hasNext()){
			String key = itr.next();
			TimeEntry temp = records.get(key);
			
			long timeSpan = temp.timeSpan();
			double tempPercent = (double)timeSpan / (double)total;
			//System.out.println("tmp: " + tempPercent + " timeSpan: " + timeSpan + " total: " + total);
			//int percent = (int) (timeSpan/total * 100);
			System.out.println("Section: " + key + " TimeSpan: " + timeSpan + " Percent: " + tempPercent * 100);
		}
	}
	
	private long getCurrentTime(){
		return System.currentTimeMillis();
	}
	
	private class TimeEntry{
		long startTime = Long.MIN_VALUE;
		long endTime = Long.MIN_VALUE;
		
		public TimeEntry(long start){
			startTime = start;
		}
		
		public void setStop(long stop){
			endTime = stop;
		}
		
		public long timeSpan(){
			if(startTime == Long.MIN_VALUE || endTime == Long.MIN_VALUE || endTime < startTime){
				return -1;
			}else
			{
				return endTime - startTime;
			}
		}
	}
}
