package designpattern.observerjdk;

import java.util.Date;
import java.util.Observable;

public class WeatherData extends Observable{

	String data = new Date().toString();
	
	public void measurementChanged() {
		setChanged(); //must be called before updating data.
		notifyObservers();//called from super class...
	}
	
	public void setData(String data) {
		this.data = data;
	}
	public String getData() {
		return data;
	}
}
