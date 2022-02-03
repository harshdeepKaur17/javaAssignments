package ques1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Student {
	private int id;
	private String name;
	private int marks;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + marks;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		if (marks != other.marks)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [id=").append(id).append(", name=").append(name).append(", marks=").append(marks)
				.append("]");
		return builder.toString();
	}
	public Student(int id, String name, int marks) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
	}
	
	
 }

public class StudentDemo {
	public static void main(String[] args) {
		Map<Student, Integer> map2 = new HashMap<>();
		map2.put(new Student(10, "raj", 95), 95);
		map2.put(new Student(61, "keta", 78), 78);
		map2.put(new Student(11, "gunika", 98), 98);
		map2.put(new Student(19, "keshav", 97), 97);

		// Print all records sorted as per name of the student
		System.out.println("------records sorted as per name of the student------");
		map2.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Student::getName)))
				.forEach(student -> System.out.println(student));

		// Print all records as per id of the student
		System.out.println("------records sorted as per id of the student------");
		map2.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Student::getId)))
				.forEach(student -> System.out.println(student));

	}
}
