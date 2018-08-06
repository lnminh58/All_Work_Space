/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//4. Viết chương trình nhập vào 2 số a và b và kiểm tra a có chia hết cho b hay không?
package session04_baitap;

/**
 *
 * @author nguyenducthao
 */
import java.util.*;
public class session04_baitap4 {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhap gia tri a: ");
        int a=nhap.nextInt();
        System.out.print("Nhap gia tri b: ");
        int b=nhap.nextInt();
        if((a%b)==0)
            System.out.println("a chia het cho b");
        else
            System.out.println("a khong chia het cho b");
    }
}
