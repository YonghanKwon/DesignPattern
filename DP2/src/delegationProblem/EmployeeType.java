package delegationProblem;

abstract public class EmployeeType {
	double salary;
	
	EmployeeType(double salary){
		this.salary=salary;
	}
	
	public void setSalary(double salary) {
		this.salary=salary;
	}
	public double getSalary() {
		return salary;
	}
	public abstract void increaseSalary(double rate);

}
