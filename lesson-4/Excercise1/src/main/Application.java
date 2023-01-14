package main;

public class Application {

	public static void main(String[] args) {

		Forecast forecast = new Forecast.Fake();
		Weather w1 = new Weather(forecast);
		assert "5".equals(w1.todaysWeather("Poland").toString());
	}
}
