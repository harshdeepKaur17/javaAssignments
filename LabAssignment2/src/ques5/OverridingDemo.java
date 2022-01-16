package ques5;
import java.util.*;
class Vehicle {
	int noOfWheels;
	int noOfPassengers;
	int model;
	String make;

	public Vehicle(int noOfWheels, int noOfPassengers, int model, String make) {
		this.noOfWheels = noOfWheels;
		this.noOfPassengers = noOfPassengers;
		this.model = model;
		this.make = make;
	}

	public void display() {
		System.out.println("Details of Vehicle: ");
		System.out.println("No of wheels: " + noOfWheels);
		System.out.println("No of passengers: " + noOfPassengers);
		System.out.println("Model: " + model);
		System.out.println("Make: " + make);
	}
}

class Car extends Vehicle {
	int noOfDoors;

	public Car(int noOfDoors, int noOfWheels, int noOfPassengers, int model, String make) {
		super(noOfWheels, noOfPassengers, model, make);
		this.noOfDoors = noOfDoors;
	}

	public void display() {
		System.out.println("Display Car: ");
		System.out.println("Model: " + model);
		System.out.println("Make: " + make);
		System.out.println("No of Doors: " + noOfDoors);
	}
}

class Convertible extends Car {
	boolean isHoodOpen;

	public Convertible(boolean isHoodOpen, int noOfDoors, int noOfPassengers, int noOfWheels, int model, String make) {
		super(noOfDoors, noOfWheels, noOfPassengers, model, make);
		this.isHoodOpen = isHoodOpen;
	}

	public void display() {
		System.out.println("Convertible Details: ");
		System.out.println("Model: " + model);
		System.out.println("Make: " + make);
		System.out.println("No of Doors: " + noOfDoors);
		System.out.println("hood open: " + isHoodOpen);
	}
}

public class OverridingDemo {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Please Select:     1.to create vehicle object  2.To create Car Object  3.To create Convertible object");
		int ch=sc.nextInt();
		if(ch==1) {
			Vehicle v=new Vehicle(4,8,2,"Maruti");
			v.display();
		}else if(ch==2) {
			Vehicle v=new Car(4,4,8,2,"Maruti");
			v.display();
		}else if(ch==3) {
			Vehicle v=new Convertible(true,4,4,8,2,"Maruti");
			v.display();
		}else {
			System.out.println("Ivalid Input!!");
		}
	}
}
