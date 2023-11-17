package observerPractice;

public class IceCreamStore implements Observer {

	private boolean sellingState;
	
	private Subject weatherData;
	
	// default constructor
	public IceCreamStore(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
		this.sellingState = false;
	}
	
	public void whetherChanged(float temperature,float rainfall) {
		if (temperature >= 20)// when temperature exceeds 20.0C
			sellingState = true; // selling IceCream
		else // when temperature < 20.0
			sellingState = false;
		
		isSelling();
	}
	
	public void isSelling() {
		if(sellingState)
			System.out.println("IceCream Sale !");
		else
			System.out.println("IceCream not Sale!");
	}
}




