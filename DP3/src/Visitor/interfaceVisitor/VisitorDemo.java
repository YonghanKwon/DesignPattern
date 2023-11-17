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
 * 상속을 이용하면 모든 타입이 ICarElement형으로만 가능, car에 대한 코드만 의도한 기능으로 동작. 
 * overriding(dynamic binding) vs overloading(static binding)
 * overloading을 사용함(method의 parameter가 다름. static binding을 사용) 즉, Compile time에 visit는 ICarElement형의 visit로 고정되어버림.
 * 기존의 코드에서는 각 class마다 visitor.visit(this)가 존재하고, 이때 this가 각각의 type을 가리킴.
 * 
 * car에서 elem.accept(visitor);가 overriding, dynamic binding.
 * elem-> run time에 결정, 결정된 elem에 따라 visitor 결정 ==> double dispatch
 * */

/*practice 2
 * concrete visitor 추가
 * Concrete visitor 추가 후, visitorDemo에 car.accept(new CarElementDestroyVisitor()); 추가
 */

/*practice 3
 * ConcreteElement 추가
 * 1. ConcreteElement Trunk추가
 * 2. interface ICarElement에 visit(Trunk trunk); 추가
 * 3. ConcreteVisitor class에 visit(Trunk trunk) 함수 추가
 * 4. Car의 Constructor에 Trunk 생성 추가
 */
