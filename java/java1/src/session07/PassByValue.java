/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session07;

/**
 *
 * @author nguyenducthao
 */
public class PassByValue {

    public void setVal(int num1) {
        num1 = num1 + 10;
    }

    public static void main(String[] args) {
        int num1 = 10;
// Instantiate the PassByValue class
        PassByValue obj = new PassByValue();
// Invoke the setVal() method with num1 as parameter
        obj.setVal(num1);
        System.out.println("Value of num1 after invoking setVal is " + num1);
    }
}
