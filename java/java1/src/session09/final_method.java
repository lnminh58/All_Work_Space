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
class A{
    final void hienthi(){
        System.out.println("Day la class A");
    }
}
class B extends A{
//    @Override
//    void hienthi(){ //error
//        
//    }
}
public class final_method {
    public static void main(String[] args) {
        
    }
    
}
//final method: phương thức có tiền tố này không được khai báo
//chồng ớ các lớp dẫn xuất (lớp con, lớp thừa kế)