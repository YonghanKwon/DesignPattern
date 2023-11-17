package delegationProblem;

public class Manager extends EmployeeType {
	public Manager(double salary){
		super(salary);
	}
	

	public Manager() {
		this(0);
	}
	@Override
	public  void increaseSalary(double rate) {
		salary=salary+10;
		salary=salary*(1+rate/100);
	}
}
/*
 abstract class는 생성을 위한 것 아님 ==> 생성자에 public 없음
 하지만 생성을 위한 class에서는 생성자에 public을 붙임.
 */
