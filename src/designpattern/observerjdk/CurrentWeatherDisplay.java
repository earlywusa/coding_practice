package designpattern.observerjdk;

import java.util.Observable;
import java.util.Observer;

public class CurrentWeatherDisplay implements Observer, DisplayElement{

	Observable observable; 
	String data = "";
	
	public CurrentWeatherDisplay(Observable obsb) {
		this.observable = obsb;
		observable.addObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("data: " + data);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof WeatherData) {
		    data = 	((WeatherData) o).getData();
		    display();
		}
		
	}

}
