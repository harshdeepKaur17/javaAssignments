package ques1;

public class CommisionEmployee extends Employee {
	private double percent;
	private double sales;
	
	public void setSales(double sales) {this.sales=sales;}
	
	public double getSales() {
		return sales;
	}
	
	public void setPercent(double percent) {
		this.percent=percent;
	}
	
	public double getPercent() {
		return percent;
	}
	
	public CommisionEmployee(String name,int id,double salary,double rate,double percent,double sales) {
		super(name,id,salary,rate);
		this.sales=sales;
		this.percent=percent;
	}
	
	public double getPayment() {
		setSalary((sales*percent)/100);
		return getSalary();
	}
}
