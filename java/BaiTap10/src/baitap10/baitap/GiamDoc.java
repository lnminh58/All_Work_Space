/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap10.baitap;

import java.util.Scanner;

/**
 *
 * @author lnmin
 */
public class GiamDoc extends Nguoi{
    private int tienTieuHangThang;

    public GiamDoc() {
    }

    public GiamDoc(int tienTieuHangThang, String hoTen, int namSinh, int maThe) {
        super(hoTen, namSinh, maThe);
        this.tienTieuHangThang = tienTieuHangThang;
    }

    public int getTienTieuHangThang() {
        return tienTieuHangThang;
    }

    public void setTienTieuHangThang(int tienTieuHangThang) {
        this.tienTieuHangThang = tienTieuHangThang;
    }

    @Override
    public String toString() {
        
        return  super.toString()+"\nGiamDoc{" + "tienTieuHangThang=" + tienTieuHangThang + '}';
    }
       @Override
    public void nhapThongTin() {
        super.nhapThongTin(); //To change body of generated methods, choose Tools | Templates.
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tiền tiêu hàng tháng");
        this.tienTieuHangThang = input.nextInt();
     }
    

    
}
