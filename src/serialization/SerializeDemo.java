package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e = new Employee();
	      e.name = "Reyan Ali";
	      e.address = "Phokka Kuan, Ambehta Peer";
	      e.SSN = 11122333;
	      e.number = 101;
	      e.taskList.add("report1");
	      e.taskList.add("report2");
	    String fileName = "serialization.out";
	    try{
	    	FileOutputStream fileout = new FileOutputStream(fileName);
	    	ObjectOutputStream out = new ObjectOutputStream(fileout);
	    	out.writeObject(e);
	    	out.close();
	    	fileout.close();
//	    	System.out.printf("Serialized data is saved in /telos/esuo/tmp/employee.ser");
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    }
	    
	    try {
	    	FileInputStream fis = new FileInputStream(fileName);
	    	ObjectInputStream ois = new ObjectInputStream(fis);
	    	Object obj = ois.readObject();
	    Employee emp = (Employee) obj;
	    System.out.println(emp);
	    }catch(Exception ee) {
	    	ee.printStackTrace();
	    }
	}

}
