/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;

/**
 *
 * @author nguyenducthao
 */
public class Employee extends Person{
    private float basicSalary;

    public Employee() {
        System.out.print("Nhap luong co ban: ");
        Scanner input=new Scanner(System.in);
        this.basicSalary=input.nextFloat();
        setSalary(basicSalary*2.34f);
    }

    public float getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(float basicSalary) {
        this.basicSalary = basicSalary;
    }

    @Override
    public String toString() {
        String str;
        str="Nhan vien:";
        str=str+"\n\tID: "+this.getID();
        str=str+"\n\tTen: "+this.getName();
        if(this.isGender()){
            str=str+"\n\tGioi tinh: Nam";
        }
        else{
            str=str+"\n\tGioi tinh: Nu";
        }
        return str;
    }
    
}
