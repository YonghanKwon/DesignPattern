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
 abstract class�� ������ ���� �� �ƴ� ==> �����ڿ� public ����
 ������ ������ ���� class������ �����ڿ� public�� ����.
 */
