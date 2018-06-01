/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session10_extends_overriding_method;

/**
 *
 * @author nguyenducthao
 */
class NhanSu {

    String hoTen, queQuan;
    int namSinh;
    public void hienthi(){
        System.out.println("Thong tin cua class nhan su");
    }

    public NhanSu() {
    }

    public NhanSu(String hoTen, String queQuan, int namSinh) {
        this.hoTen = hoTen;
        this.queQuan = queQuan;
        this.namSinh = namSinh;
    }
    
}

class HocSinh extends NhanSu {

    float diemTrungBinh;
    @Override
    public void hienthi(){
        System.out.println("Thong tin cua class hoc sinh");
    }
   
}

class GiaoVien extends NhanSu {

    float luong;
    @Override
    public void hienthi() {
        System.out.println("Thong tin cua class giao vien");
    }
}

public class extends_overriding_method {

    public static void main(String[] args) {
        NhanSu nhansu = new NhanSu();
        nhansu.hoTen = "Nhan su";
        nhansu.queQuan = "Que quan nhan su";
        nhansu.namSinh = 1990;
        HocSinh hocsinh = new HocSinh();
        hocsinh.hoTen = "Hoc sinh";
        hocsinh.queQuan = "Que quan hoc sinh";
        hocsinh.namSinh = 1991;
        hocsinh.diemTrungBinh = 9.5f;
        GiaoVien giaovien = new GiaoVien();
        giaovien.hoTen = "Giao vien";
        giaovien.queQuan = "Que quan giao vien";
        giaovien.namSinh = 1980;
        giaovien.luong = 3_000_000f;
        nhansu.hienthi();
        hocsinh.hienthi();
        giaovien.hienthi();
    }
}

//Khái niệm ghi đè – override:
//
//- Đó là khi phương thức đã xuất hiện ở lớp cha và xuất hiện tiếp ở lớp con.
//- Khi đối tượng thuộc lớp con gọi phương thức thì sẽ chọn lựa và chạy theo phương thức trong lớp con.
//- Nếu lớp con không có phương thức đó thì mới lên kiếm ở lớp cha để chạy.
//- Phương thức ghi đè có cùng tên, cùng tham số truyền vào, cùng kiểu giá trị trả về với phương thức ở lớp cha!
//- Ghi đè là hình thức đa hình (polymorphism) trong quá trình thực thi (Runtime)