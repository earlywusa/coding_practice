package designpattern.observer;

public class ObserverImpl implements Observer {

	String data= "";
	
	@Override
	public void display() {
		System.out.println("show data: " + data);
	}

	@Override
	public void updateData(String data) {
		this.data = data;
		display();
	}

}
