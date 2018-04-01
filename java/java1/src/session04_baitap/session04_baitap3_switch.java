/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Viết chương trình nhập vào 2 số nguyên, hiển thị chức năng cho phép người dùng lựa chọn.
//Dùng 02 cách: if-else if và switch:
//Nhấn phím số 1: Thực hiện phép cộng
//Nhấn phím số 2: Thực hiện phép trừ
//Nhấn phím số 3: Thực hiện phép nhân
//Nhấn phím số 4: Thực hiện phép chia
package session04_baitap;

/**
 *
 * @author nguyenducthao
 */
import java.util.*;
public class session04_baitap3_switch {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhap so nguyen thu nhat a: ");
        int a=nhap.nextInt();
        System.out.print("Nhap so nguyen thu hai b: ");
        int b=nhap.nextInt();
        System.out.println("Nhan phim so 1: Thuc hien phep cong ");
        System.out.println("Nhan phim so 2: Thuc hien phep tru ");
        System.out.println("Nhan phim so 3: Thuc hien phep nhan ");
        System.out.println("Nhan phim so 4: Thuc hien phep chia ");
        System.out.print("Hay chon phep tinh muon thuc hien: ");
        int pheptinh=nhap.nextInt();
        switch(pheptinh){
            case 1:
                System.out.println("a+b = "+(a+b));
                break;
            case 2:
                System.out.println("a-b = "+(a-b));
                break;
            case 3:
                System.out.println("a*b = "+(a*b));
                break;
            case 4:
                System.out.println("a/b = "+((float)a/b));
                break;
            default:
                System.out.println("Phim vua nhan khong phu hop");
                    
        }
    }
}
