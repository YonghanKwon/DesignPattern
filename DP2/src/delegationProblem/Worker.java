package delegationProblem;


public abstract class Worker {
	EmployeeType employeetype;
	double salary;
	
	public abstract void doWork();	
	public void increaseSalary(double rate) {
		employeetype.increaseSalary(rate);
	}
	public void setEmployeeType(EmployeeType et) {
		employeetype=et;
	}

}


/* 
package delegationProblem;

public abstract class Worker {
	public abstract void doWork();	
}
 */


/*
worker.java
EmployeeType.java
Manager.java
Regular.java
 */