/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session10_Upcasting_Downcasting;

/**
 *
 * @author nguyenducthao
 */
public class Student extends Person {

    @Override
    public void display() {
        System.out.println("Class Student");
    }

    public void displayMarks() {
        System.out.println("Student marks");
    }
}
