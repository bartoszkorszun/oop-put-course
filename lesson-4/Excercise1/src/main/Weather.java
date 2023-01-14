package main;

public class Weather {

	private final Forecast forecast;
	
	public Weather(Forecast forecast) {
		this.forecast = forecast;
	}
	
	public Integer todaysWeather(String country) {
		return forecast.todaysWeather(country);
	}
}
