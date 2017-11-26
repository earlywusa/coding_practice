package designpattern.observerjdk;

import java.util.Date;
import java.util.Observer;

public class TestDriver {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		Observer observer = new CurrentWeatherDisplay(weatherData);
		Observer observerBeta = new CurrentWeatherDisplay(weatherData);
		weatherData.setData(new Date().toString());
		weatherData.measurementChanged();
	}

}
