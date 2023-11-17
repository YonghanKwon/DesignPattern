package observerPractice;


public class UmbrellaStore implements Observer{
	
	private boolean sellingState;

	private Subject weatherData;
	// default constructor
	public UmbrellaStore(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
		this.sellingState = false;
	}
	
	public void whetherChanged(float temperature,float rainfall) {
		if (rainfall >= 5.0f)// when rainfall exceeds 5.0mm
			sellingState = true; // selling umbrella
		else // when rainfall < 5.0
			sellingState = false;
		
		isSelling();
	}

	public void isSelling() {
		if(sellingState)
			System.out.println("Umbrellas Sale !");
		else
			System.out.println("Umbrellas not Sale!");
	}


}
