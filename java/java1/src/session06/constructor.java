/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session06;

/**
 *
 * @author nguyenducthao
 */
public class constructor {

    String className;
    int studentNum;

    public constructor() {
        this.className = "Batch 130";
        this.studentNum = 20;
    }

    public constructor(String className) {
        this.className = className;
    }

    public constructor(int studentNum) {
        this.studentNum = studentNum;
    }

    public constructor(String className, int studentNum) {
        this.className = className;
        this.studentNum = studentNum;
    }

    public void displayClassName() {
        System.out.println("Display class name: ");
        System.out.print("      Class name: " + this.className);
        System.out.println("");
    }

    public void displayStudentNum() {
        System.out.println("Display student number: ");
        System.out.print("      Student number: " + this.studentNum);
        System.out.println("");
    }

    public void displayClassInformation() {
        System.out.println("Class information: ");
        System.out.println("      Class name: " + this.className);
        System.out.println("      Student number: " + this.studentNum);
    }

    public static void main(String[] args) {
        constructor myClass = new constructor();
//        contructor myClass = new contructor("Batch 130");
//        contructor myClass= new contructor(20);
//        contructor myClass= new contructor("Batch130", 20);
        myClass.displayClassInformation();
    }
}
