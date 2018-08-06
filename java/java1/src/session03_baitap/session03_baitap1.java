/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//1. Khai báo biến local, nhập giá trị cho biến local từ bàn phím và in giá trị của biến local ra output.
package session03_baitap;
/**
 *
 * @author nguyenducthao
 */
//1. Khai báo biến local, nhập giá trị cho biến local từ bàn phím và in giá trị của biến local ra output.
import java.util.*;
public class session03_baitap1 {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        {
            System.out.print("Nhap gia tri i: ");
            int bienLocal=nhap.nextInt();
            System.out.println("Gia tri i="+bienLocal);
        }
    }
   
}
