/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java1.session6;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author lnminh
 */
public class Student implements Comparable<Student>,Serializable{
    private static int counter=0;
    private int id;
    private String name;
    private int age;
    private float english;
    private float computer;
    private float math;
    private float averageMark;

    public Student() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Name");
        this.name = scan.nextLine();
        scan = new Scanner(System.in);
        System.out.println("Enter Age");
        this.age= scan.nextInt();
        System.out.println("Enter English Mark");
        this.english=scan.nextFloat();
        System.out.println("Enter Computer Mark");
        this.computer=scan.nextFloat();
        System.out.println("Enter Math Mark");
        this.math=scan.nextFloat();
        this.averageMark=(this.english+this.computer+this.math)/3;
        this.id =++counter;
    }

    public Student(String name, int age, float english, float Computer, float math) {
        this.name = name;
        this.age = age;
        this.english = english;
        this.computer = Computer;
        this.math = math;
        this.averageMark=(this.english+this.computer+this.math)/3;
        this.id = ++counter;
    }

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

    public void setComputer(float Computer) {
        this.computer = Computer;
    }

    public float getMath() {
        return math;
    }

    public void setMath(float math) {
        this.math = math;
    }

    public float getAverageMark() {
        return averageMark;
    }

    public int getId() {
        return id;
    }

    public static void setCounter(int counter) {
        Student.counter = counter;
    }
    
    public void showInfo(){
        System.out.println("Student "+ this.id);
        System.out.println("Name: "+this.name);
        System.out.println("Age: "+this.age);
        System.out.println("Mark");
        System.out.println("\tEnglish: "+this.english);
        System.out.println("\tComputer: "+this.computer);
        System.out.println("\tMath: "+this.math);
        System.out.println("Average Mark: "+this.averageMark);
    }
  

    @Override
    public int compareTo(Student t) {
        if(this.age>t.age){
            return 1;
        }else if(this.age<t.age){
            return -1;
        }
        return 0;
    }
    

}
