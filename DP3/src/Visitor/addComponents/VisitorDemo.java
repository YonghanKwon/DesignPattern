package Visitor.addComponents;

import java.util.ArrayList;
import java.util.Iterator;

interface ICarElementVisitor {
    void visit(Wheel wheel);
    void visit(Engine engine);
    void visit(Body body);
    void visit(Car car); 
    void visit(Trunk trunk);
}

interface ICarElement {
    abstract public void accept(ICarElementVisitor visitor);   
}

public class VisitorDemo {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.addComponents(new Trunk("default"));
        myCar.addComponents(new Wheel("default front-left"));
        myCar.addComponents(new Wheel("default front-right"));
        myCar.addComponents(new Wheel("default rear-left"));
        myCar.addComponents(new Wheel("default rear-right"));
        myCar.addComponents(new Body("default"));
        myCar.addComponents(new Engine("default"));
        
        CompositeParts cx = new CompositeParts("CP1");
        cx.add(new Wheel("extra mid-left"));
        cx.add(new Wheel("extra mid-center"));
        cx.add(new Wheel("extra mid-right"));
        cx.add(new Engine("extra"));
        
        CompositeParts cxx = new CompositeParts("CP1-1");
        
        cxx.add(new Trunk("extra composite"));
        cxx.add(new Wheel("extra composite"));
        
        cx.add(cxx);
        
        myCar.addComponents(cx);
                
    	ICarElement car = myCar;        
        car.accept(new CarElementPrintVisitor());
        System.out.println("-------------------------");
        car.accept(new CarElementDoVisitor());
        System.out.println("-------------------------");
        car.accept(new CarElementDestroyVisitor());
    }
}

class Trunk extends CarComponent implements ICarElement  {
	public Trunk(String name) { super(name); }
    public void accept(ICarElementVisitor visitor) {
        visitor.visit(this);     
    }
}
class Wheel extends CarComponent implements ICarElement  {
    public Wheel(String name) { super(name); } 
    public void accept(ICarElementVisitor visitor) {
        visitor.visit(this);     
    }
}
class Engine extends CarComponent implements ICarElement {
    public Engine(String name) { super(name); } 
	public void accept(ICarElementVisitor visitor) {
        visitor.visit(this);     
    }
}
class Body extends CarComponent implements ICarElement {
	public Body(String name) { super(name); } 
    public void accept(ICarElementVisitor visitor) {
        visitor.visit(this);     
    }
}

abstract class CarComponent { 
	private String name;
	public CarComponent(String name) { this.name = name; }
	public String getName() { return this.name; }		
}

class CompositeParts extends CarComponent {    
    private ArrayList child;
	  
	public CompositeParts (String name) {
		super(name); 		
		child = new ArrayList();
	}
 	
	public void add(CarComponent elem) {
		child.add(elem);
	}
 
	public void remove(CarComponent elem) {
		child.remove(elem);
	}
 
	public CarComponent getChild(int i) {
		return (CarComponent) child.get(i);
	}
 	  
	public Iterator iterator() {
		return child.iterator();
	}
}

class Car implements ICarElement {
    private ArrayList components;
        
    public Car() { 
    	
    	components = new ArrayList();         
    }
    public void addComponents(CarComponent c) {
    	components.add(c);
    }
    public void acceptCarComponent(CarComponent c, ICarElementVisitor visitor) {
    	if (c instanceof CompositeParts ) {
    		CompositeParts cp = (CompositeParts) c;
    		Iterator j = cp.iterator();
    	    while (j.hasNext()) {    	    	
    	    	acceptCarComponent((CarComponent)j.next(), visitor);
    	    }    	    		
    	} else {
    		ICarElement elem = (ICarElement)c;
    		elem.accept(visitor);
    	}
    }
    
    public void accept(ICarElementVisitor visitor) {
    	Iterator i = components.iterator(); 
        while (i.hasNext()) {
        	CarComponent c = (CarComponent)i.next();
        	acceptCarComponent(c, visitor);
        }
        visitor.visit(this);    
    }
}
class CarElementPrintVisitor implements ICarElementVisitor {	
    public void visit(Wheel wheel) {      
      System.out.println("Visiting " + wheel.getName() + " wheel");     
    }
    public void visit(Engine engine) {
        System.out.println("Visiting " + engine.getName() + " engine");     
    }
    public void visit(Body body) {
        System.out.println("Visiting " + body.getName() + " body");     
    }
    public void visit(Car car) {      
        System.out.println("Visiting car");     
    }
    public void visit(Trunk trunk) {      
        System.out.println("Visiting " + trunk.getName() + " trunk");     
    }
}

class CarElementDoVisitor implements ICarElementVisitor {	
    public void visit(Wheel wheel) {
        System.out.println("Kicking my " + wheel.getName() + " wheel");  }
    public void visit(Engine engine) {
        System.out.println("Starting my " + engine.getName() + " engine");
    }
    public void visit(Body body) {
        System.out.println("Moving my " + body.getName() + " body");
    }
    public void visit(Car car) {
        System.out.println("Starting my car");
    }
    public void visit(Trunk trunk) {      
        System.out.println("Closing " + trunk.getName() + " trunk");     
    }
}

class CarElementDestroyVisitor implements ICarElementVisitor {	
    public void visit(Wheel wheel) {
        System.out.println("Destroying " + wheel.getName() + " wheel");  }
    public void visit(Engine engine) {
        System.out.println("Destroying " + engine.getName() + " engine");
    }
    public void visit(Body body) {
        System.out.println("Destroying " + body.getName() + " body");
    }
    public void visit(Car car) {
        System.out.println("Destroying car");
    }
    public void visit(Trunk trunk) {      
        System.out.println("Destroying " + trunk.getName() + " trunk");     
    }
}
