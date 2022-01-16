package ques1;

class Circle{
	int radius;
	String colour;
	public Circle(){
		System.out.println("Default constructor of circle class");
	}
	public Circle(int radius) {
		this.radius=radius;
	}
	public int getRadius() {
		return radius;
	}
	public double getArea() {
		double area=22.5*radius*radius;
		return area;
	}
}
public class CircleExample{
 public static void main(String[] args) {
	 Circle cr=new Circle(5);
	int r=cr.getRadius();
	double ar=cr.getArea();
	System.out.println("Radius of the circle is "+r);
	System.out.println("Area of the circle is "+ar);
	 
 }
}
