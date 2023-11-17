package headfirst.observer.weatherobservable;

public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentConditions = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		AverageDisplay averageDisplay = new AverageDisplay(weatherData);
		
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
		weatherData.setMeasurements(79, 90, 29.2f);
		weatherData.setMeasurements(83, 90, 29.2f);
		weatherData.setMeasurements(85, 90, 29.2f);
		weatherData.setMeasurements(82, 90, 29.2f);
		weatherData.setMeasurements(80, 90, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
		weatherData.setMeasurements(76, 90, 29.2f);
		weatherData.setMeasurements(75, 90, 29.2f);
	}
}
