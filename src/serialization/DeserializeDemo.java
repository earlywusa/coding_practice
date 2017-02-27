package serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e = null;
		try{
			FileInputStream fi = new FileInputStream("/telos/esuo/tmp/employee.ser");
			ObjectInputStream oi = new ObjectInputStream(fi);
			e = (Employee)oi.readObject();
			oi.close();
			fi.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		System.out.println("Deserialized Employee...");
	      System.out.println("Name: " + e.name);
	      System.out.println("Address: " + e.address);
	      System.out.println("SSN: " + e.SSN);
	      System.out.println("Number: " + e.number);
	      System.out.println("Report: " + e.taskList.poll());
	      System.out.println("Report: " + e.taskList.poll());
	}

}
