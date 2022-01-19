package ques2;
import java.util.*;
class Date{
	private int day;
	private int month;
	private int year;
	
	public Date() {
		System.out.println("Default date constructor");
	}
	
	public Date(int day,int month,int year) {
		this.day=day;
		this.month=month;
		this.year=year;
		
	}
	
	public Date(Date date) {
		
	}
	
	public void print() {
		System.out.println("Day: "+day);
		System.out.println("Month: "+month);
		System.out.println("Year: "+year);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
StringBuilder builder=new StringBuilder();
		
		builder.append("Details \n day:").append(day).append("\n month: ").append(month).append("\n year: ").append(year);
		return builder.toString();
	}
	
	
}
class Owner{
	private String name;
	private String nic;
	private Date date;
	
	public Owner(){
		
	}
	
	public Owner(String name,String nic,Date date) {
		this.name=name;
		this.nic=nic;
		this.date=date;
	}
	
	public Owner(Owner owner) {
	}
	
	public static void input() {
		System.out.println("Enter the name: ");
		System.out.println("Enter the nic");
	}
	
	public void print() {
		System.out.println("Name: "+name);
		System.out.println("NIc: "+nic);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
StringBuilder builder=new StringBuilder();
		
		builder.append("Details \n name:").append(name).append("\n nic: ").append(nic).append("\n date: ").append(date);
		return builder.toString();
	}
	
	
}
class Account {
	public float balance;
	public String number;
	public  Owner owner;
	Scanner sc=new Scanner(System.in);
	public Account() {
		System.out.println("Default Account constructor");
	}
	
	public Account(float balance,Owner owner) {
		this.balance=balance;
		this.number="abc";
		this.owner=owner;
	}
	
	public void input() {
		
	}
	public void print() {
		System.out.println("Balance: "+balance);
		System.out.println("Number: "+number);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
StringBuilder builder=new StringBuilder();
		
		builder.append("Details \n balance:").append(balance).append("\n number: ").append(number).append("\n Owner: ").append(owner);
		return builder.toString();
		
	}
	
	public void deposite() {
		System.out.println("enter the amount to deposite");
		float amt=sc.nextFloat();
		balance=balance+amt;
		System.out.println("Amount deposited!!");
	}
	
	public void withdraw() {
		System.out.println("enter the amount to withdraw: ");
		float amt=sc.nextFloat();
		if(amt<balance) {
			balance=balance-amt;
			System.out.println("amount deposited!!");
		}else {
			System.out.println("Insufficient Balance!!");
		}
		
	}
	
	public float getBalance() {
		return balance;
	}
}

class SavingAccount extends Account{
	private float interestRate=5;
	
	public SavingAccount() {
		System.out.println("Default Saving account constructor!!");
	}
	
	public SavingAccount(SavingAccount savingAccount) {
		
	}
	public void print() {
		System.out.println("Interest rate: "+interestRate);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
StringBuilder builder=new StringBuilder();
		
		builder.append("Details \n balance:").append(balance).append("\n number: ").append(number).append("\n Owner: ").append(owner).append("\n interest rate: ").append(interestRate);
		return builder.toString();
		
	}
	
	public float getInterestRate() {
		return interestRate;
	}
	
}

class CurrentAccount extends Account{
	public float minimumBalance;
	
	public CurrentAccount() {
		
	}
	public CurrentAccount(float minimumBalance,float balance,Owner owner) {
		super(balance,owner);
		this.minimumBalance=minimumBalance;
	}
	
	public void input() {
		System.out.println("input function");
	}
	
	public void print() {
		System.out.println("minimum balance: "+minimumBalance);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		StringBuilder builder=new StringBuilder();
		
		builder.append("Details \n balance:").append(balance).append("\n number: ").append(number).append("\n Owner: ").append(owner).append("\n minimum balance: ").append(minimumBalance);
		return builder.toString();
	}
	
	public float getCharges() {
		return minimumBalance;
	}
	
}
public class umlDemo {
		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the day");
			int day=sc.nextInt();
			System.out.println("enter the month");
			int month=sc.nextInt();
			System.out.println("enter the year:");
			int year=sc.nextInt();
			Date date=new Date(day,month,year);
			System.out.println("Date of birth: "+date);
			
			System.out.println("Enter the name: ");
			String name=sc.nextLine();
			System.out.println("Enter the nic:");
			String nic=sc.nextLine();
			Owner owner=new Owner(name,nic,date);
			System.out.println("Owner details are: "+owner);
			
			System.out.println("Enter the initial blance: ");
			float balance=sc.nextFloat();
			Account account=new Account(balance,owner);
			System.out.println("Account: "+account);
			System.out.println("Select the type of account: 1.Saving    2.Current");
			int ch=sc.nextInt();
			
			if(ch==1) {
				account=new SavingAccount();
				System.out.println("Savings Account: "+account);
			}else if(ch==2) {
				System.out.println("Enter the minimum balance: ");
				float amt=sc.nextFloat();
				account=new CurrentAccount(amt,balance,owner);
				
				System.out.println("Current account details: "+account);
			}
		}
}
