/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.FileFactory;
import controller.FindCustomer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import model.Customer;

/**
 *
 * @author lnmin
 */
public class Manager {
    static ArrayList<Customer> listCustomer = new ArrayList<>();
    private static void enterCustomer(){
        System.out.println("Nhập vào thông tin khách Hàng");
        listCustomer.add(new Customer());
    }
    private static void displayCustomer(){
        System.out.println("Danh sách khách hàng: ");
        System.out.println("\tID"+"\tTên"+"\t Số điện thoại");
        listCustomer.forEach((customer) -> {
            System.out.println(customer);
        });
    }
    private static void deleteCustomer(){
        Scanner ip = new Scanner(System.in);
        System.out.println("Nhập vào id khách hàng cần xóa: ");
        int id = ip.nextInt();
        for (Customer customer : listCustomer) {
            if(customer.getIdNumber()==id){
                listCustomer.remove(listCustomer.indexOf(customer));
                break;
            }
        }
    }
    private static void deleleAllCustomer(){
        Scanner ip = new Scanner(System.in);
        System.out.println("Bạn có chắc chán muốn xóa không? \t1. Có nhập yes \t"
                            + " 2.Nếu không nhập bất kỳ để hủy");
        String checker=ip.nextLine();
        if(checker.equalsIgnoreCase("yes")){
            listCustomer.clear();
            System.out.println("Đã xóa toàn bộ dữ liệu");
        }else{
            System.out.println("Đã hủy yêu cầu");
        }
          
    }
    private static void findByName(){
        Scanner ip = new Scanner(System.in);
        System.out.println("Nhập vào tên cần tìm");
        FindCustomer.findByName(listCustomer, ip.nextLine());
    }
      private static void findByPhoneNumber(){
        Scanner ip = new Scanner(System.in);
        System.out.println("Nhập vào số điện thoại cần tìm");
        FindCustomer.findByPhoneNumber(listCustomer, ip.nextLine());
    }
    
    private static void saveData(){
        boolean checker= FileFactory.saveListCustomer(listCustomer,
                                        "D:\\workspace\\java\\File\\dskhachhang.txt");
        if(checker){
            System.out.println("Lưu dữ liệu thành công");
        }else{
            System.out.println("Lưu dữ liệu thất bại");
        }
    }
    private static void loadData(){
        listCustomer=FileFactory.loadListCustomer("D:\\workspace\\java\\File\\dskhachhang.txt");
        System.out.println("Hoàn tất load dữ liệu");
        if(listCustomer.isEmpty()){
            Customer.setCounter(0);
        }else{
            Customer.setCounter((listCustomer.get(listCustomer.size()-1)).getIdNumber());
        }
    }
     static void sortByName(){
         Collections.sort(listCustomer,new Comparator<Customer>(){
             @Override
             public int compare(Customer t, Customer t1) {
                 return t.getName().compareToIgnoreCase(t1.getName());
             }
  
     });
         System.out.println("Danh sách sau khi sắp xếp theo tên: ");
         displayCustomer();
     }
     static void sortByID(){
         Collections.sort(listCustomer, new Comparator<Customer>(){
             @Override
             public int compare(Customer t, Customer t1) {
                 if(t.getIdNumber()>t1.getIdNumber()){
                     return 1;
                 }if(t.getIdNumber()<t1.getIdNumber()){
                     return -1;
                 }return 0;
             }
             
         });
         System.out.println("Danh sách sau khi sắp xếp theo ID: ");
         displayCustomer();
     }
    public static void main(String[] args) {
        boolean exit=true;
        loadData();
        while (exit) {            
            System.out.println("Quản Lý Khách Hàng ");
            System.out.println("1.  Nhập Khách Hàng mới.");
            System.out.println("2.  Xuất thông tin toàn bộ.");
            System.out.println("3.  Tìm kiếm khách hàng theo tên.");
            System.out.println("4.  Tìm kiếm khách hàng theo số điện thoại.");
            System.out.println("5.  Xóa khách hàng");
            System.out.println("6.  Xóa toàn bộ khách hàng");
            System.out.println("7.  Sắp xếp theo ID");
            System.out.println("8.  Sắp xếp theo tên");
            System.out.println("9.  Thoát");
            System.out.print("\t  bạn chọn: ");
            int choise = 0;
            try {
                Scanner ip = new Scanner(System.in);
                choise = ip.nextInt();
            } catch (Exception e) {
                System.out.println("Lỗi nhập!!!");
                e.printStackTrace();
            }
            switch(choise){
                case 1: enterCustomer();
                        break;
                case 2: displayCustomer();
                        break;
                case 3: findByName();
                        break;
                case 4: findByPhoneNumber();
                        break;
                case 5: deleteCustomer();
                        break;
                case 6: deleleAllCustomer();
                        break;
                case 7: sortByID();
                        break;
                case 8: sortByName();
                        break;
                case 9:  exit=false;
                        break;
            }       
        }
        saveData();
    }
}
