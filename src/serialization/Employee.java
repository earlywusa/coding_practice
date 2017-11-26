package serialization;

import java.io.Serializable;
import java.util.PriorityQueue;

public class Employee implements Serializable{

	public String name;
	public String address;
	public transient int SSN;
	public int number;
	
	public PriorityQueue<String> taskList = new PriorityQueue<String>(); 
	
	public void mailCheck() {
	      System.out.println("Mailing a check to " + name + " " + address);
	   }

	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + ", SSN=" + SSN + ", number=" + number + ", taskList="
				+ taskList + "]";
	}

}
