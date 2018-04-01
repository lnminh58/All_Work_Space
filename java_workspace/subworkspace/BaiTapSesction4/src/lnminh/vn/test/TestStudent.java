package lnminh.vn.test;

import java.util.Scanner;

import lnminh.vn.Student;

public class TestStudent {
//		Nhập
	//	private static void nhapDoiTuong(Student st) {
//		Scanner input = new Scanner(System.in);
//		System.out.println("Tên: ");
//		st.setName(input.nextLine());
//		System.out.println("Nhập Tuổi:");
//		st.setAge(input.nextInt());
//		System.out.println("Nhập điểm tiếng anh:");
//		st.setEnglish(input.nextFloat());
//		System.out.println("Nhập điểm tin:");
//		st.setComputer(input.nextFloat());
//		System.out.println("Nhập điểm Toán:");
//		st.setMath(input.nextFloat());
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Student st1 = new Student();
//		System.out.println("Nhập đối tượng 1: ");
//		TestStudent.nhapDoiTuong(st1);
//
//		Student st2 = new Student();
//		System.out.println("Nhập đối tượng 2: ");
//		TestStudent.nhapDoiTuong(st2);
//
//		Student st3 = new Student();
//		System.out.println("Nhập đối tượng 3: ");
//		TestStudent.nhapDoiTuong(st3);
//
//		System.out.println(st1);
//		System.out.println(st2);
//		System.out.println(st3);
		
		// câu 4
		Student st1= new Student("John",18,2,4,2);
		Student st2= new Student("Peter",19,8,10,9);
		System.out.println("Student 1");
		st1.xuatThongTinXepLoai();
		System.out.println("Student 2");
		st2.xuatThongTinXepLoai();
		


	}

}
