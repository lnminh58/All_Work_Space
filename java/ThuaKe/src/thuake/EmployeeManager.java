/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Employee;
import model.Teacher;

/**
 *
 * @author nguyenducthao
 */
public class EmployeeManager {

    /**
     * @param args the command line arguments
     */
    ArrayList<Employee> arrayListEmployees=new ArrayList<>();
    ArrayList<Teacher> arrayListTeachers=new ArrayList<>();
    public void nhapNhanVien(){
        Employee employee=new Employee();
        arrayListEmployees.add(employee);
        
    }
    public void nhapGiaoVien(){
        Teacher teacher=new Teacher();
        System.out.println("fdsfjskfddfk");
    }
    public void hienThiThongTinNhanVien(){
        for (Employee arrayListEmployee : arrayListEmployees) {
            System.out.println(arrayListEmployee);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        EmployeeManager employeeManager=new EmployeeManager();
        do {
            System.out.println("CHUONG TRINH QUAN LY NHAN SU");
            System.out.println("1. Nhap nhan vien");
            System.out.println("2. Nhap giao vien");
            System.out.println("3. In thong tin nhan vien va giao vien");
            System.out.println("4. Tinh tong luong phai tra");
            System.out.println("5. Thoat");
            System.out.print("ban chon: ");
            Scanner input = new Scanner(System.in);
            int luachon = input.nextInt();
            switch (luachon) {
                case 1:
//                    System.out.println("so 1");
                    employeeManager.nhapNhanVien();
                    break;
                case 2:
                    System.out.println("so 2");
                    break;
                case 3:
                    employeeManager.hienThiThongTinNhanVien();
                    break;
                case 4:
                    System.out.println("so 4");
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        } while (true);
    }

}
