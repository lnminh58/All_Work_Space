package lnminh.vn.test;

import java.util.ArrayList;

import lnminh.vn.model.Student;

public class TestStudent {
	public static void main(String[] args) {
		
		ArrayList<Student> arrList = new ArrayList<>();
		
		for (int i = 0; i < 3; i++) {
			System.out.println("Nhập học sinh thứ: " + i);
			Student st = new Student();
			st.nhapStudent();
			arrList.add(st);
		}
		// Câu 2

	/*	ArrayList<Student> arr = new ArrayList<Student>();
		arr.add(new Student("John", 18, 2, 4, 2));
		arr.add(new Student("Peter", 19, 8, 10, 9));
		arr.add(0, new Student("lora", 21, 10, 9, 1));
		for (Student student : arr) {
			System.out.println(student);
		}
		System.out.println("=============================");
		arr.set(0, new Student("micheal", 20, 10, 8, 7));
		for (Student student : arr) {
			System.out.println(student);
		}
		System.out.println("=============================");
		ArrayList<Student> arr2 = new ArrayList<>();
		arr2.addAll(arr);
		arr2.addAll(arr);
		for (Student student : arr2) {
			System.out.println(student);
		}
*/
	}
}
