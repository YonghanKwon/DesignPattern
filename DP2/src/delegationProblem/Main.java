package delegationProblem;
public class Main {

	public static void main(String[] args) {
		Worker worker[] = { new Dog("Baduki"), new Cat("Nabi"), new Robot(), new Dog("Bulldog") };
		
		int i;
		
		//for ( i = 0 ; i < worker.length; i++) {			
		//	worker[i].doWork();
		//	((Sayable)worker[i]).say();
		//}
		//worker[i].doWork();		
		
		for ( i = 0 ; i < worker.length-1; i++) {			
			worker[i].doWork();
			((Sayable)worker[i]).say();
		}
		worker[i].doWork();
		
	}

}
