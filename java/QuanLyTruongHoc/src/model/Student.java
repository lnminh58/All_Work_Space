/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;

/**
 *
 * @author lnmin
 */
public class Student extends Person{
    private String classID;
    private float averageMark;

    public Student() {
    }

    public Student(String classID, float averageMark, int ID, String fullName, int yearOfBirth) {
        super(ID, fullName, yearOfBirth);
        this.classID = classID;
        this.averageMark = averageMark;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public float getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(float averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public String toString() {
        return "Student: " +super.toString()+ "\nClass ID= " + classID + "\tMark= " + averageMark ;
    }
    
    @Override
    public void inputInfo(){
        super.inputInfo();
        try {
            Scanner ip = new Scanner(System.in);
            System.out.print("Enter Class ID: ");
            this.classID=ip.nextLine();
            System.out.print("Enter Average Mark: ");
            this.averageMark=ip.nextFloat();
        } catch (Exception e) {
            System.out.println("Input Error");
        }
    }
}
 