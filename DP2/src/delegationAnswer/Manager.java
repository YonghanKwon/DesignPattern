package delegationAnswer;

public class Manager extends EmployeeType {
    public Manager(double salary) {
        super(salary);        
    }
    
	public Manager() {
		this(0);
	}

	@Override
	public void increaseSalary(double rate) {
		salary += 10;
		salary = salary + salary*(rate/100);	    
	}

}
