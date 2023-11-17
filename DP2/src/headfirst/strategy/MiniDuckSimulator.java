package headfirst.strategy;

public class MiniDuckSimulator {
 
	public static void main(String[] args) {
 
		MallardDuck	mallard = new MallardDuck();
		RubberDuck	rubberDuckie = new RubberDuck();
		DecoyDuck	decoy = new DecoyDuck();
 
		ModelDuck	model = new ModelDuck();

		mallard.performQuack();
		rubberDuckie.performQuack();
		decoy.performQuack();
   
		model.performFly();	
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
		model.setQuackBehavior(new DoubleQuack());
		model.performQuack();
		
		model = new BadDuck();
		model.performFly();	
		model.performFly();
		model.performQuack();
		model.performQuack();
		
		model = new ModelDuck();
		
		Duck ducks[] = {mallard,rubberDuckie,decoy,model};
		for (Duck d : ducks) {
			d.display();
			d.performEggBehavior();
		}
		ducks[0].setEggBehavior(new SpawnEgg());
		for (Duck d : ducks) {
			d.display();
			d.performEggBehavior();
		}
		System.out.println("\n");
		
		model.CopyBehavior(mallard);

		for (Duck d : ducks) {
			d.display();
			d.performEggBehavior();
		}
	}
}
