package Visitor.interfaceVisitor;

interface ICarElementVisitor {
    void visit(Wheel wheel);
    void visit(Engine engine);
    void visit(Body body);
    void visit(Trunk trunk);
    void visit(Car car); 
}

interface ICarElement {
    abstract public void accept(ICarElementVisitor visitor);   
}

public class VisitorDemo {
    public static void main(String[] args) {
        ICarElement car = new Car();
        car.accept(new CarElementPrintVisitor());
        car.accept(new CarElementDoVisitor()); 
        car.accept(new CarElementDestroyVisitor());
    }
}

class Wheel implements ICarElement {
    private String name;
    public Wheel(String name) { this.name = name; } 
    public String getName() { return this.name; }
    public void accept(ICarElementVisitor visitor) {
        visitor.visit(this);     
    }
}
class Engine implements ICarElement {
    public void accept(ICarElementVisitor visitor) {
        visitor.visit(this);     
    }
}
class Body implements ICarElement {
    public void accept(ICarElementVisitor visitor) {
        visitor.visit(this);     
    }
}
class Trunk implements ICarElement{
	public void accept(ICarElementVisitor visitor) {
		visitor.visit(this);
	}
}

class Car implements ICarElement {
    ICarElement[] elements;
    public Car() {
        this.elements = new ICarElement[] { new Wheel("front left"), new Wheel("front right"), new Wheel("back left") , new Wheel("back right"), new Body(), new Engine(),new Trunk() }; 
    }
    public void accept(ICarElementVisitor visitor) {    
        for(ICarElement elem : elements) 
            elem.accept(visitor);
        visitor.visit(this);    
    }
}

class CarElementPrintVisitor implements ICarElementVisitor {	
    public void visit(Wheel wheel) {      
      System.out.println("Visiting " + wheel.getName() + " wheel");     
    }
    public void visit(Engine engine) {
        System.out.println("Visiting engine");     
    }
    public void visit(Body body) {
        System.out.println("Visiting body");     
    }
    public void visit(Car car) {      
        System.out.println("Visiting car");     
    }
    public void visit(Trunk trunk) {      
        System.out.println("Visiting trunk");     
    }
}

class CarElementDoVisitor implements ICarElementVisitor {	
    public void visit(Wheel wheel) {
        System.out.println("Kicking my " + wheel.getName() + " wheel");  }
    public void visit(Engine engine) {
        System.out.println("Starting my engine");
    }
    public void visit(Body body) {
        System.out.println("Moving my body");
    }
    public void visit(Car car) {
        System.out.println("Starting my car");
    }
    public void visit(Trunk trunk) {      
        System.out.println("Opening trunk");     
    }
}

class CarElementDestroyVisitor implements ICarElementVisitor{
    public void visit(Wheel wheel) {
        System.out.println("Destroying my " + wheel.getName() + " wheel");  }
    public void visit(Engine engine) {
        System.out.println("Destroying my engine");
    }
    public void visit(Body body) {
        System.out.println("Destroying my body");
    }
    public void visit(Car car) {
        System.out.println("Destroying my car");
    }
    public void visit(Trunk trunk) {      
        System.out.println("Destroying trunk");     
    }
}


/*practice 1
 * ����� �̿��ϸ� ��� Ÿ���� ICarElement�����θ� ����, car�� ���� �ڵ常 �ǵ��� ������� ����. 
 * overriding(dynamic binding) vs overloading(static binding)
 * overloading�� �����(method�� parameter�� �ٸ�. static binding�� ���) ��, Compile time�� visit�� ICarElement���� visit�� �����Ǿ����.
 * ������ �ڵ忡���� �� class���� visitor.visit(this)�� �����ϰ�, �̶� this�� ������ type�� ����Ŵ.
 * 
 * car���� elem.accept(visitor);�� overriding, dynamic binding.
 * elem-> run time�� ����, ������ elem�� ���� visitor ���� ==> double dispatch
 * */

/*practice 2
 * concrete visitor �߰�
 * Concrete visitor �߰� ��, visitorDemo�� car.accept(new CarElementDestroyVisitor()); �߰�
 */

/*practice 3
 * ConcreteElement �߰�
 * 1. ConcreteElement Trunk�߰�
 * 2. interface ICarElement�� visit(Trunk trunk); �߰�
 * 3. ConcreteVisitor class�� visit(Trunk trunk) �Լ� �߰�
 * 4. Car�� Constructor�� Trunk ���� �߰�
 */
