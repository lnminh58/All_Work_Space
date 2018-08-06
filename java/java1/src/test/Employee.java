/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author nguyenducthao
 */
public class Employee extends Person{
    public String name;

    public Employee() {
        
        super();
        System.out.println("class employee");
    }

    @Override
    public void display() {
        super.display(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        Employee employee=new Employee();
        employee.display();
        
    }
}
