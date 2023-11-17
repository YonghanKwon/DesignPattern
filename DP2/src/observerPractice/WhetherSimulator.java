package observerPractice;

public class WhetherSimulator {
	
	
	public static void main(String[] args) {

		//subject object
		WhetherDataSubject wdSubject;

		wdSubject = new WhetherDataSubject();
		//observer objects
		UmbrellaStore umbrellaStore = new UmbrellaStore(wdSubject);
		ClothingStore clothingStore = new ClothingStore(wdSubject);
		IceCreamStore icecreamStore = new IceCreamStore(wdSubject);
		
		// whether changed : temperature = 25.0'c, rainfall = 0.0mm
		System.out.println();
		wdSubject.setMeasurements(25.0f, 0.0f);
		
		// whether changed : temperature = 10.0'c, rainfall = 10.0mm
		System.out.println();
		wdSubject.setMeasurements(10.0f, 10.0f);
		
		// whether changed : temperature = 16.0'c, rainfall = 1.0mm
		System.out.println();
		wdSubject.setMeasurements(16.0f, 1.0f);
		
		System.out.println();
		wdSubject.setMeasurements(26.0f, 6.0f);
	}
}
