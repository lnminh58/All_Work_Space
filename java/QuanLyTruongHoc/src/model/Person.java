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
public class Person {
    private int ID;
    private String fullName;
    private int yearOfBirth;

    public Person() {
    }

    public Person(int ID, String fullName, int yearOfBirth) {
        this.ID = ID;
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return ID + "\t" + fullName + "\t" + yearOfBirth;
    }
    public void inputInfo(){
        try {
            Scanner ip= new Scanner(System.in);
            System.out.print("Enter ID: ");
            this.ID = ip.nextInt();
            System.out.print("Enter Full Name: ");
            ip= new Scanner(System.in);
            this.fullName=ip.nextLine();
            System.out.print("Enter Year of Birth: ");
            this.yearOfBirth=ip.nextInt();
        } catch (Exception e) {
            System.out.println("Input Error");
        }
        
    }
}
