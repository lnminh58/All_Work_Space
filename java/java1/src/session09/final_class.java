/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session09;

/**
 *
 * @author nguyenducthao
 */
final class A1{
    void hienthi(){
        System.out.println("Final class");
    }
}
//class B1 extends A1{    //error
//    
//}
public class final_class {
    public static void main(String[] args) {
        A1 a=new A1();
        a.hienthi();
    }
 
}

//final class: (lớp vô sinh) 
//Lớp không thể có lớp dẫn xuất từ nó (không có lớp con) gọi là lớp “vô sinh”,
//hay nói cách khác không thể kế thừa được từ một lớp “vô sinh”. 
//Lớp “vô sinh” dùng để hạn chế, ngăn ngừa các lớp khác dẫn xuất từ nó.
//
//Để khai báo một lớp là lớp “vô sinh”, chúng ta dùng từ khóa final class.
//Tất cả các phương thức của lớp vô sinh đều vô sinh, 
//nhưng các thuộc tính của lớp vô sinh thì có thể không vô sinh.

//Các thuộc tính và phương thức trong final class mặc định được xem là final
//nghĩa là không thể thay đổi được giá trị (đối với thuộc tính)
//và override (đối với phương thức) bởi các class khác