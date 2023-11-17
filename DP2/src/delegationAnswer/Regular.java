package delegationAnswer;

public class Regular extends EmployeeType {
    public Regular(double salary) {
        super(salary);        
    }
    
	public Regular() {
		this(0);
	}

	@Override
	public void increaseSalary(double rate) {		
		salary = salary + salary*(rate/100);	    
	}

}
