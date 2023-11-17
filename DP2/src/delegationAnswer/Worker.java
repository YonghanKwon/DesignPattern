package delegationAnswer;

public abstract class Worker {
	public abstract void doWork();   
    EmployeeType etype = null;
    
    public double getSalary() { 
        return etype.getSalary();
    }
    
    public void setSalary(double salary) {
        etype.setSalary(salary);
    }

    public void increaseSalary(double rate) {
        etype.increaseSalary(rate);
    }
    
    public void setEmployeeType(EmployeeType emptype) {
        this.etype = emptype;
    }
    
    public EmployeeType getEmpoyeeType() {
        return this.etype;
    }    
   
}
