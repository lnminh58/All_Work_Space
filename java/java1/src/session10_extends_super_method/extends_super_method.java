/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session10_extends_super_method;

/**
 *
 * @author nguyenducthao
 */
class NhanSu{
    public void thongBao(){
        System.out.println("Day la class NhanSu");
    }
}
class HocSinh extends NhanSu{
    public void thongBao(){
        System.out.println("Day la class HocSinh");
}
    public void hienThi(){
        super.thongBao();
        thongBao();
    }
}
public class extends_super_method {
    public static void main(String[] args) {
        HocSinh hocsinh=new HocSinh();
        hocsinh.hienThi();
    }
}
