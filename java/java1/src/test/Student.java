/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nguyenducthao
 */
public class Student {
    private String name;
    private int age;

    public Student() {
        Scanner input=new Scanner(System.in);
        System.out.print("Nhap ten: ");
        this.name=input.nextLine();
        System.out.print("Nhap tuoi: ");
        this.age=input.nextInt();
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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
    public void display(){
        System.out.println(name);
        System.out.println(age);
    }

    @Override
    public String toString() {
        return "Name=" + name + ",\n age=" + age;
    }
    
    public static void main(String[] args) {
        ArrayList<Student> arrStudent=new ArrayList<>();
        for (int i = 0; i <= 1; i++) {
            System.out.println("Nhap thong tin student thu "+(i+1));
            arrStudent.add(new Student());
        }
        for (int i = 0; i < arrStudent.size(); i++) {
            System.out.println("ten student "+(i+1)+": "+arrStudent.get(i).getName());
            System.out.println("tuoi student "+(i+1)+": "+arrStudent.get(i).getAge());
        }
    }
}
