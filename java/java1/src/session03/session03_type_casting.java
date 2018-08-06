/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session03;

/**
 *
 * @author nguyenducthao
 */
public class session03_type_casting {
    
    public static void main(String[] args) {
//        implicit type casting: ép kiểu ngầm định
//        kiểu dữ liệu đích phải lớn hơn kiểu dữ liệu nguồn
        int a=1;
        float b=10.9f;
        b=a; //đúng vì b có kiểu float là kiểu lớn hơn kiểu int của a
        System.out.println("b= "+b);
//        a=b; //sai vì a có kiểu int nhỏ hơn kiểu float của b
//        explicit casting: ép kiểu tường minh
        a=(int)b;
        System.out.println("a= "+a);
    }
}
