/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session03;

import java.util.*;

/**
 *
 * @author nguyenducthao
 */
public class session03_formatted_input_Scanner {
    
    public static void main(String[] args) {
        Scanner nhapgiatri=new Scanner(System.in);
        System.out.print("Hay nhap gia tri cua a: ");
        int a=nhapgiatri.nextInt();
        a=a+1;
        System.out.println("Gia tri cua a+1: "+a);
//        next() và nextLine() dùng để nhập chuỗi
//        next(): không nhận ký tự trắng, tương tự như scanf("%s") trong C
//        nextLine(): nhận được ký tự trắng, tương tự gets(str) trong C
//        khi sử dụng next() để nhập chuỗi thì ko cần tạo đối tượng Scanner mới
        System.out.print("Nhap gia tri chuoi1: ");
        String chuoi1=nhapgiatri.next();
        System.out.println("Chuoi1="+chuoi1);
//        khi sử dụng nextLine() để nhập chuỗi thì phải tạo đối tượng Scanner mới, nếu ko thì sẽ
//        bị hiện tượng trôi lệnh như ngôn ngữ C
        System.out.print("Nhap chuoi2: ");
        nhapgiatri=new Scanner(System.in);
//        System.out.flush();
        String chuoi2=nhapgiatri.nextLine();
        System.out.println("Chuoi2: "+chuoi2);
    }
}
