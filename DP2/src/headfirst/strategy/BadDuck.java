package headfirst.strategy;

public class BadDuck extends ModelDuck{
	int count;

	public BadDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
		count=0;
	}
	@Override
	public void display() {
		if(count%2==0) {
		System.out.println("I'm a model duck");
		}
		else {
			System.out.println("公矫");
		}
		count++;
	}
	@Override
	public void performFly() {
		if(count%2==0) {
		flyBehavior.fly();
		}
		else {
			System.out.println("公矫");
		}
		count++;
	}
	@Override
	public void performQuack() {
		if(count%2==0) {
			quackBehavior.quack();
		}
		else {
			System.out.println("公矫");
		}
		count++;
	}
	@Override
	public void swim() {
		if(count%2==0) {
		System.out.println("All ducks float, even decoys!");
		}else {
			System.out.println("公矫");
		}
		count++;
	}
}
