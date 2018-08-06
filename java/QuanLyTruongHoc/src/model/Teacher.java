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
public class Teacher extends Person{
    private float salary;

    public Teacher() {
    }
    public Teacher(float salary) {
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    
    @Override
    public String toString() {
        return "Teacher: " +super.toString()+"\nsalary=" + salary;
    }

    @Override
    public void inputInfo() {
        super.inputInfo(); 
         try {
            Scanner ip = new Scanner(System.in);
            System.out.print("Enter Teacher's Salary: ");
            this.salary=ip.nextFloat();
         } catch (Exception e) {
            System.out.println("Input Error");
        }
    }
    
}
