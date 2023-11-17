package observerPractice;


public class ClothingStore implements Observer{
	private static final int SUMMER_CLOTHS = 1;
	private static final int WINTER_CLOTHS = 2;

	private Subject weatherData;
	
	private int state;
	
	public ClothingStore(Subject weatherData) {

		this.weatherData = weatherData;
		weatherData.registerObserver(this);
		state = SUMMER_CLOTHS;
	}
	
	public void whetherChanged(float temperature, float rainfall) {
		if(temperature >= 15.0f) // when temperature exceeds 15.0'c
			state = SUMMER_CLOTHS; // selling summer cloths
		else // when temperature < 15.0
			state = WINTER_CLOTHS;
		
		kindOfSellingCloths();
	}
	public void kindOfSellingCloths() {
		System.out.println("Selling " + ((state == SUMMER_CLOTHS) ? "Summer" : "Winter") + " cloths !");
	}

}
