package ques1;

public class HourlyEmployee extends Employee {
	 private int hours;
	 private double hoursRate;
	 
	 public int getHours() {
		 return hours;
	 }
	 
	 public double getHoursRate() {
		 return hoursRate;
	 }
	 
	 public void setHours(int hours) {
		 this.hours=hours;
	 }
	 
	 public void setHoursRate(double hoursRate) {
		 this.hoursRate=hoursRate;
	 }
	 
	 public HourlyEmployee(String name,int id,double salary,double rate,int hours,double hoursRate) {
		 super(name,id,salary,rate);
		 this.hours=hours;
		 this.hoursRate=hoursRate;
	 }
	 
	 public double getPayment() {
		 setSalary(getRate()*hours);
		 return getSalary();
	 }
}
