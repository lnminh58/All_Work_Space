/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//9. Viết chương trình nhập vào 1 số từ 0 đến 9. In ra chữ số tương ứng.
//Ví dụ: nhập vào số 5, in ra "Năm".
//Chương trình chỉ dừng khi nhập 1 số không phải từ 0 đến 9.
package session05_baitap;

/**
 *
 * @author nguyenducthao
 */
import java.util.*;

public class session05_bai09 {

    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        int so;
        do {
            System.out.print("Nhap mot so tu 0->9 hoac nhap mot so khong tu 0->9 de thoat: ");
            nhap = new Scanner(System.in);
            so = nhap.nextInt();
            switch (so) {
                case 0:
                    System.out.println("So vua nhap la: Khong");
                    break;
                case 1:
                    System.out.println("So vua nhap la: Mot");
                    break;
                case 2:
                    System.out.println("So vua nhap la: Hai");
                    break;
                case 3:
                    System.out.println("So vua nhap la: Ba");
                    break;
                case 4:
                    System.out.println("So vua nhap la: Bon");
                    break;
                case 5:
                    System.out.println("So vua nhap la: Nam");
                    break;
                case 6:
                    System.out.println("So vua nhap la: Sau");
                    break;
                case 7:
                    System.out.println("So vua nhap la: Bay");
                    break;
                case 8:
                    System.out.println("So vua nhap la: Tam");
                    break;
                case 9:
                    System.out.println("So vua nhap la: Chin");
                    break;
            }
        } while ((so >= 0) && (so <= 9));
    }
}
