package ques3;

import java.io.*;
class Employee implements Serializable{
	
	private String name,id;
	private String address;
	private transient double salary;
	
	public Employee(String name,String id,String address,double salary) {
		this.name=name;
		this.id=id;
		this.address=address;
		this.salary=salary;
	}
	
	public void display() {
		System.out.println("Name: "+name);
		System.out.println("ID: "+id);
		System.out.println("Address: "+address);
		System.out.println("Salary: "+salary);
	}
}
public class SerializationDeserealizationDemo {
	public static void serialize(Employee emp,String filename) {
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filename))){
			out.writeObject(emp);
			System.out.println("Object has been serialized");
		}catch(IOException ex) {
			ex.getMessage();
		}
	}
	
	public static void deserealize(String filename) {
		Employee emp=null;
		try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(filename))){
			emp=(Employee)in.readObject();
			System.out.println("Object deserealize");
			emp.display();
		}catch(IOException | ClassNotFoundException ex) {
			ex.getMessage();
		}
	}
	
	public static void main(String[] args) {
		Employee emp=new Employee("Mahek","1711","Delhi",6000000);
		String filename="Serialization.ser";
		serialize(emp,filename);
		deserealize(filename);
	}
}
