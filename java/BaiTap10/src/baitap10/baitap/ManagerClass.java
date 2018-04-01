/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap10.baitap;

/**
 *
 * @author lnmin
 */
public class ManagerClass {
    public static void main(String[] args) {
        SinhVien sv= new SinhVien();
        sv.nhapThongTin();
        GiangVien gv= new GiangVien();
        gv.nhapThongTin();
        GiamDoc gd = new GiamDoc();
        gd.nhapThongTin();
        System.out.println(sv);
        System.out.println(gv);
        System.out.println(gd);
    }
}
