/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session11_baitap;

/**
 *
 * @author nguyenducthao
 */
public class CongThucTinh implements CongThuc{

    @Override
    public float dienTichHinhVuong(float chieudai) {
        return chieudai*chieudai;
    }

    @Override
    public float dienTichHinhChuNhat(float chieudai, float chieurong) {
        return chieudai*chieurong;
    }

    @Override
    public float chuViHinhVuong(float chieudai) {
        return chieudai*4;
    }

    @Override
    public float chuViHinhChuNhat(float chieudai, float chieurong) {
        return 2*(chieudai+chieurong);
    }
    public static void main(String[] args) {
        CongThucTinh tinhDienTichChuVi=new CongThucTinh();
        System.out.println("Dien tich hinh vuong co chieu dai bang 2 la: "+tinhDienTichChuVi.dienTichHinhVuong(2));
        System.out.println("Dien tich hinh chu nhat co chieu dai bang 2 va chieu rong bang 3 la: "+ tinhDienTichChuVi.dienTichHinhChuNhat(2, 3));
        System.out.println("Chu vi hinh vuong co chieu dai bang 2 la: "+tinhDienTichChuVi.chuViHinhVuong(2));
        System.out.println("Chu vi hinh chu nhat co chieu dai bang 2 va chieu rong bang 3 la: "+tinhDienTichChuVi.chuViHinhChuNhat(2, 3));
    }
}
