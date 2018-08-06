/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session11_Nestle_Class;

/**
 *
 * @author nguyenducthao
 */
class HocSinh1{
    String khoiLop;
    void getKhoiLop(){
        class TieuHoc{
            String khoiLopTieuHoc="1 2 3 4 5";
            void getKhoiLopTieuHoc(){
                khoiLop="Tieu hoc, Trung hoc co so, Trung hoc pho thong";
                System.out.println("Cac khoi lop la: "+khoiLop);
                System.out.println("Khoi lop tieu hoc la:"+khoiLopTieuHoc);
            }
        }
        TieuHoc tieuhoc=new TieuHoc();
        tieuhoc.getKhoiLopTieuHoc();
    }
}
public class Local_Class {
    public static void main(String[] args) {
        HocSinh1 hocsinh=new HocSinh1();
        hocsinh.getKhoiLop();
    }
    
}
//Local class là class được khai báo bên trong một method.

//Nếu muốn triệu hồi các phương thức của Local Inner Class, 
//thì phải khởi tạo lớp này bên trong phương thức.

//Một số qui tắc khi sử dụng Local Inner Class trong Java
//+ Các biến cục bộ không thể là private, public, hoặc protected.
//+ Local Inner Class không thể được triệu hồi ở bên ngoài phương thức.
//+ Từ JDK 1.7 trở về trước, trong Local Inner Class, nếu muốn truy cập biến cục bộ của phương thức, 
//thì biến đó phải thuộc kiểu final. Còn bắt đầu từ JDK 1.8 trở đi, giới hạn này đã bị loại bỏ.