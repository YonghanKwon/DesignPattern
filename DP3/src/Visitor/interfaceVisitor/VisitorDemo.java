package Visitor.interfaceVisitor;

interface ICarElementVisitor {
    void visit(Wheel wheel);
    void visit(Engine engine);
    void visit(Body body);
    void visit(Car car); 
    void visit(ICarElement ICarElement);
}

abstract class ICarElement {
    public void accept(ICarElementVisitor visitor) {
    	visitor.visit(this);
    }
}

public class VisitorDemo {
    public static void main(String[] args) {
        ICarElement car = new Car();
        car.accept(new CarElementPrintVisitor());
        car.accept(new CarElementDoVisitor()); 
    }
}

class Wheel extends ICarElement {
    private String name;
    public Wheel(String name) { this.name = name; } 
    public String getName() { return this.name; }

}
class Engine extends ICarElement {
	
}
class Body extends ICarElement {

}

class Car extends ICarElement {
    ICarElement[] elements;
    public Car() {
        this.elements = new ICarElement[] { new Wheel("front left"), new Wheel("front right"), new Wheel("back left") , new Wheel("back right"), new Body(), new Engine() }; 
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

    public void visit(ICarElement ICarElement) {
    	System.out.println("Visiting ICarElement");
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
    public void visit(ICarElement ICarElement) {
    	System.out.println("Starting ICarElement");
    }
}
/*
 * 상속을 이용하면 모든 타입이 ICarElement형으로만 가능, car에 대한 코드만 의도한 기능으로 동작. 
 * overriding(dynamic binding) vs overloading(static binding)
 * */
