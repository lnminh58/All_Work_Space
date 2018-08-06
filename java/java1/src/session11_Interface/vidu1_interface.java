/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session11_Interface;

/**
 *
 * @author nguyenducthao
 */
interface DienTich {

    public abstract void dienTichHinhVuong(float a);

    public abstract void dienTichHinhChuNhat(float a, float b);
}

interface ChuVi {

    public abstract void chuViHinhVuong(float a);

    public abstract void chuViHinhChuNhat(float a, float b);
}

interface CongThuc extends DienTich, ChuVi {

}

class CongThucTinh implements CongThuc {
    //Hoặc viết là class CongThucTinh implements DienTich,ChuVi cũng được!

    @Override
    public void dienTichHinhVuong(float a) {
        System.out.println("Diện tích hình vuông: " + a * a);
    }

    @Override
    public void dienTichHinhChuNhat(float a, float b) {
        System.out.println("Diện tích hình chữ nhật: " + a * b);
    }

    @Override
    public void chuViHinhVuong(float a) {
        System.out.println("Chu vi hình vuông: " + 4 * a);
    }

    @Override
    public void chuViHinhChuNhat(float a, float b) {
        System.out.println("Chu vi hình chữ nhật: " + 2 * (a + b));
    }

}

public class vidu1_interface {

    public static void main(String[] args) {
        CongThucTinh congthuctinh = new CongThucTinh();
        congthuctinh.dienTichHinhVuong(5.0f);
        congthuctinh.chuViHinhVuong(5.0f);
        congthuctinh.dienTichHinhChuNhat(5.5f, 10.0f);
        congthuctinh.chuViHinhChuNhat(5.5f, 10.0f);
    }

}
