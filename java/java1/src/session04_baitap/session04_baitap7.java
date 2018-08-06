/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//7. Viết chương trình yêu cầu người dùng nhập vào 1 tháng và năm bất kì, 
//sau đó in ra màn hình xem tháng vừa nhập vào có bao nhiêu ngày trong năm đó ?
package session04_baitap;

/**
 *
 * @author nguyenducthao
 */
import java.util.*;
public class session04_baitap7 {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhap 1 thang bat ky: ");
        int thang=nhap.nextInt();
        System.out.print("Nhap 1 nam bat ky: ");
        int nam=nhap.nextInt();
        switch(thang){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Thang "+thang+" nam "+nam+" co 31 ngay");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Thang "+thang+" nam "+nam+" co 30 ngay");
                break;
            case 2:
                switch(nam%4){
                    case 0:
                        System.out.println("Thang "+thang+" nam "+nam+" co 29 ngay");
                        break;
                    default:
                        System.out.println("Thang "+thang+" nam "+nam+" co 28 ngay");
                }
            default:
                System.out.println("Thang nhap vao khong hop le");
        }
    }
}
