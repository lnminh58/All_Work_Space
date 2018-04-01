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
public class TestNhanVien {
    public static void main(String[] args) {
        NhanVien nv = new NhanVienChinhThuc();
        nv.setTen("Minh");
        System.out.println(nv);
        
        NhanVienChinhThuc nv2 = new NhanVienChinhThuc();
        nv2.setTen("Trần Thị Tý");
        System.out.println(nv2);
        
        nv= new NhanVienThoiVu();
        nv.setTen("Lê Ngọc Minh");
        System.out.println(nv);
    }
 
}
