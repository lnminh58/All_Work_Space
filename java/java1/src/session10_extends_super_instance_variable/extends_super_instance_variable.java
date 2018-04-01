/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session10_extends_super_instance_variable;

/**
 *
 * @author nguyenducthao
 */
//Khai báo class NhanSu và class HocSinh thừa kế class NhanSu có cùng 1 instance tên là DiaChi
//nếu dùng super.DiaChi nghĩa là tham chiếu đến instance DiaChi của class cha (class NhanSu)
//nếu dùng DiaChi nghĩa là tham chiếu đến biến instance DiaChi của class HocSinh
//đối với Contructor và method, khi sử dụng từ khóa super thì cũng tương tự như biến instance
class NhanSu {

    String diaChi = "38 Yen Bai";
    String hoten;
public NhanSu(){
    hoten="Ten cua class NhanSu";
}
public NhanSu(String str){
    hoten=str;
}
}

class HocSinh extends NhanSu {

    public String diaChi = "38 Yen Bai, Da Nang";
    int tuoi;

    public HocSinh() {
//        hoten="Hoc sinh";
//        super();
        super("Hoc sinh");
        tuoi = 20;
    }

    public void hienthi() {
        //ví dụ của super instance
        System.out.println("Day la gia tri cua bien instance DiaChi cua class NhanSu: " + super.diaChi);
        System.out.println("Day la gia tri cua bien instance DiaChi cua class HocSinh: " + diaChi);
    }
}

class GiaoVien extends NhanSu {

    float luong;
}

public class extends_super_instance_variable {

    public static void main(String[] args) {

        HocSinh hocsinh = new HocSinh();
        hocsinh.hienthi();
        System.out.println("Tuoi cua hoc sinh: " + hocsinh.hoten);
        System.out.println("Tuoi cua hoc sinh: " + hocsinh.tuoi);
    }
}

//Từ khóa super trong Java là một biến tham chiếu mà được sử dụng để tham chiếu 
//đến đối tượng lớp cha gần nhất. Bất cứ khi nào bạn tạo instance (sự thể hiện) của lớp con, 
//một instance của lớp cha được tạo ngầm định, được tham chiếu bởi biến super.
//
//Sự sử dụng của từ khóa super trong Java
//super được sử dụng để tham chiếu biến instance của lớp cha gần nhất.
//super() được sử dụng để triệu hồi Constructor của lớp cha gần nhất.
//super được sử dụng để triệu hồi phương thức của lớp cha gần nhất.
