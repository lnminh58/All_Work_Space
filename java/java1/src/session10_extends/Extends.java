/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session10_extends;

/**
 *
 * @author nguyenducthao
 */
class NhanSu{
     String hoTen, queQuan;
    int namSinh;
}
class HocSinh extends NhanSu{
    float diemTrungBinh;
}
class GiaoVien extends NhanSu{
    float luong;
}
public class Extends{
    
    public static void main(String[] args) {
       NhanSu nhansu=new NhanSu();
       nhansu.hoTen="Nhan su";
       nhansu.queQuan="Que quan nhan su";
       nhansu.namSinh=1990;
       HocSinh hocsinh=new HocSinh();
       hocsinh.hoTen="Hoc sinh";
       hocsinh.queQuan="Que quan hoc sinh";
       hocsinh.namSinh=1991;
       hocsinh.diemTrungBinh=9.5f;
       GiaoVien giaovien=new GiaoVien();
       giaovien.hoTen="Giao vien";
       giaovien.queQuan="Que quan giao vien";
       giaovien.namSinh=1980;
       giaovien.luong=3_000_000f;
    }
}
