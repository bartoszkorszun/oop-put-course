package main;

public interface Forecast {

	Integer todaysWeather(String country);
	final class Fake implements Forecast{
		
		@Override
		public Integer todaysWeather(String country) {
			return new Integer(5);
		}
	}
}
