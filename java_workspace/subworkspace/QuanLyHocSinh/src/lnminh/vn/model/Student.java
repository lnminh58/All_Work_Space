package lnminh.vn.model;

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
	public Student(String name, int age, float english, float computer, float math) {
		super();
		this.name = name;
		this.age = age;
		this.english = english;
		this.computer = computer;
		this.math = math;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Name: "+name+"\n"+"Age: "+age+"\n"
				+"Mark:\n"+"\tEnglish: "+ english+"\n\tComputer"+computer+"\n\tMath: "+math	;
	}
	private float diemTrungBinh() {
		return  (english+math+computer)/3.0f;
	}
	private String xepLoai() {
		if(diemTrungBinh()>=8) {
			return "Excellent";
		}else if(diemTrungBinh()>=6.5) {
			return "Good";
		}else if(diemTrungBinh()>=5){
			return "Average";
		}else if(diemTrungBinh()>3.5) {
			return "Weak";
		}else {
			return "poor";
		}
		
		
	}
	public void xuatDiemTrungBinh() {
		System.out.println("Name: "+this.name+"\n Điểm trung bình: "+diemTrungBinh());
	}
	public void xuatThongTinXepLoai() {
		System.out.print("Name: "+ name+"\nMark Average: ");
		System.out.printf("%5.2f %n",diemTrungBinh());
		System.out.println("Level: "+ xepLoai());
	}
	public void nhapStudent() {
		Scanner input = new Scanner(System.in);
		System.out.println("Tên: ");
		this.setName(input.nextLine());
		System.out.println("Nhập Tuổi:");
		this.setAge(input.nextInt());
		System.out.println("Nhập điểm tiếng anh:");
		this.setEnglish(input.nextFloat());
		System.out.println("Nhập điểm tin:");
		this.setComputer(input.nextFloat());
		System.out.println("Nhập điểm Toán:");
		this.setMath(input.nextFloat());
	}
	
	
}
