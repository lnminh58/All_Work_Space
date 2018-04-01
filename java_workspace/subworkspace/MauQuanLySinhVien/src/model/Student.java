package model;

import java.util.Scanner;

public class Student {
	private String name;
	private int age;
	private float english;
	private float computer;
	private float math;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getEnglish() {
		return english;
	}
	public void setEnglish(float english) {
		this.english = english;
	}
	public float getComputer() {
		return computer;
	}
	public void setComputer(float computer) {
		this.computer = computer;
	}
	public float getMath() {
		return math;
	}
	public void setMath(float math) {
		this.math = math;
	}
	
	
	public Student() {
		super();
	}
	
	
	
	public Student(String name, int age, float english, float computer, float math) {
		super();
		this.name = name;
		this.age = age;
		this.english = english;
		this.computer = computer;
		this.math = math;
	}
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", english=" + english + ", computer=" + computer + ", math="
				+ math + "]";
	}
	public static Student inputStudent() {
		Student st = new Student();
		Scanner input = new Scanner(System.in);
		System.out.println("Tên: ");
		st.setName(input.nextLine());
		System.out.println("Nhập Tuổi:");
		st.setAge(input.nextInt());
		System.out.println("Nhập điểm tiếng anh:");
		st.setEnglish(input.nextFloat());
		System.out.println("Nhập điểm tin:");
		st.setComputer(input.nextFloat());
		System.out.println("Nhập điểm Toán:");
		st.setMath(input.nextFloat());
		
		return st;
	}
}
