/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java1.session6;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author lnminh
 */
public class StudentManager {

    private static Vector<Student> listStudents = new Vector<>();

    public static String inputText() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine().trim();
    }

    public static int inputInteger() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public static float inputFloat() {
        Scanner scan = new Scanner(System.in);
        return scan.nextFloat();
    }

    public static void addStudent() {

        System.out.println("\t=============================");
        listStudents.add(new Student());

    }

    public static void showStudents() {
        System.out.println("\t=============================");
        for (Student student : listStudents) {
            student.showInfo();
        }
    }

    public static void sortByName() {
        listStudents.sort(new Comparator<Student>() {
            @Override
            public int compare(Student t, Student t1) {
                return t.getName().compareToIgnoreCase(t1.getName());
            }
        });
        System.out.println("List Student After Sort By Name: ");
        showStudents();
    }

    public static void sortByAge() {
        Collections.sort(listStudents);
        System.out.println("List Student After Sort By Age: ");
        showStudents();
    }

    public static void sortByAverageMark() {
        listStudents.sort(new Comparator<Student>() {
            @Override
            public int compare(Student t, Student t1) {
                if(t.getAverageMark()>t1.getAverageMark()){
                    return 1;
                }
                if(t.getAverageMark()<t1.getAverageMark()){
                    return -1;
                }
                return 0;
            }
        });
        System.out.println("List Student After Sort By Average Mark: ");
        showStudents();
    }

    public static void FindByName(String name) {
        System.out.println("Student have name contain: " + name);
        for (Student student : listStudents) {
            if (student.getName().contains(name)) {
                student.showInfo();
                System.out.println("--------------");
            }
        }
    }

    public static void FindByAge(int age) {
        System.out.println("Student have age older: " + age);
        for (Student student : listStudents) {
            if (student.getAge() == age) {
                student.showInfo();
                System.out.println("--------------");
            }
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ HỌC SINH");
            System.out.println("1. Enter Student ");
            System.out.println("2. Show All Students");
            System.out.println("3. Sort Student By Name");
            System.out.println("4. Sort Student By Age");
            System.out.println("5. Sort Student By Average Mark");
            System.out.println("6. Find Student By Name");
            System.out.println("7. Find Student By Age");
            System.out.println("8. Exit");
            System.out.print("\t Your Choice: ");
            int choice = inputInteger();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    showStudents();
                    break;
                case 3:
                    sortByName();
                    break;
                case 4:
                    sortByAge();
                    break;
                case 5:
                    sortByAverageMark();
                    break;
                case 6:
                    System.out.println("Enter Name To Find");
                    FindByName(inputText());
                    break;
                case 7:
                    System.out.println("Enter Age To Find");
                    FindByAge(inputInteger());
                    break;
                case 8:
                    System.exit(0);

            }
        }
    }
}
