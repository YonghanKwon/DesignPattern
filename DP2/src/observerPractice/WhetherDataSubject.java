package observerPractice;
import java.util.*;


public class WhetherDataSubject implements Subject{
	private ArrayList observers;
	private float temperature = 25.0f;
	private float rainfall = 0.0f;
	
	// default constructor
	public WhetherDataSubject() {
		observers = new ArrayList();
	}
	
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}
	
	public void notifyDataSetChanged() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.whetherChanged(temperature, rainfall);
		}
	}
	
	public void measurementsChanged() {
		notifyDataSetChanged();
	}
	
	public void setMeasurements(float temperature, float rainfall) {
		this.temperature = temperature;
		this.rainfall = rainfall;
		currentState();
		measurementsChanged();
	}
	
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	
	public void setRainfall(float rainfall) {
		this.rainfall = rainfall;
	}
		
	public void currentState() {
		System.out.printf("===== Current state ===== \n Temperature : %.1f'c \n Rainfall : %.1fmm \n=========================\n",
				temperature, rainfall);
	}
}
