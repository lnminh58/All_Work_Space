package view;

import java.util.ArrayList;

import model.Student;

public class StudentManager {
	static ArrayList<Student> listStudent = new ArrayList<>();

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			System.out.println("Nhập sinh viên thứ: " + (i + 1));
			listStudent.add(Student.inputStudent());
		}
		for (Student st : listStudent) {
			System.out.println(st);
		}
	}
}
