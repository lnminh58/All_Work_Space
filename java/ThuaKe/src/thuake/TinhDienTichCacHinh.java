/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuake;

/**
 *
 * @author lnmin
 */
public class TinhDienTichCacHinh {
    public static void main(String[] args) {
        
        HinhVuong hv= new HinhVuong();
        hv.setDoDaiDoan(10);
        System.out.println(hv);
        
        HinhTron ht = new HinhTron(5,2);
        ht.setDoDaiDoan(10);
        System.out.println(ht);
        System.out.println("-----------------------");
        
        DoanThang dt1=new HinhVuong(20);
        double a=( (HinhVuong) dt1).tinhDienTich();
        System.out.println(a);
        
        
    }
}
