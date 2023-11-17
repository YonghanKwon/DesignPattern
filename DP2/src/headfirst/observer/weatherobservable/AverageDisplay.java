package headfirst.observer.weatherobservable;

import java.util.Observable;
import java.util.Observer;

public class AverageDisplay implements Observer, DisplayElement  {

	private float[] temp_list=new float[10];
	private float avg_temperature;
	private int numReadings=0;
	
	public AverageDisplay(Observable observable) {
		observable.addObserver(this);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Average temperature: " + avg_temperature + "F degrees");
	}

	@Override
	public void update(Observable obs, Object arg) {
		// TODO Auto-generated method stub
		if (obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)obs;
			temp_list[numReadings%10]=weatherData.getTemperature();
			numReadings++;
			float sum_temp=0;
			if(numReadings<10) {
				for(int i=0;i<numReadings;i++) {
					sum_temp+=temp_list[i];
				}
				avg_temperature=sum_temp/numReadings;
			}
			else {
				for(int i=0;i<10;i++) {
					sum_temp+=temp_list[i];
				}
				avg_temperature=sum_temp/10;
			}
			display();
		}
	}

}
