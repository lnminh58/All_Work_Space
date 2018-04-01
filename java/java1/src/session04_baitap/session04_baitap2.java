/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//2. Viết một chương trình để nhắc người dùng nhập 3 số nguyên và tìm giá trị lớn nhất.
package session04_baitap;

/**
 *
 * @author nguyenducthao
 */
import java.util.*;
public class session04_baitap2 {
    public static void main(String[] args) {
        Scanner nhap=new Scanner(System.in);
        System.out.print("Nhap gia tri a: ");
        int a=nhap.nextInt();
        System.out.print("Nhap gia tri b: ");
        int b=nhap.nextInt();
        System.out.print("Nhap gia tri c: ");
        int c=nhap.nextInt();
        int max;
        max=a;
        if(max<b)
            max=b;
        if (max<c)
            max=c;
        System.out.println("Gia tri lon nhat cua a, b, c la: "+max);
    }
}
