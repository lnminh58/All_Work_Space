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
class HocSinh2{
    String khoiLop;
     void setKhoiLop(){
        khoiLop="Tieu hoc, Trung hoc co so, Trung hoc pho thong";
    }
    void getKhoiLop(){
        System.out.println("Hoc sinh co cac khoi lop: "+khoiLop);
    }
}
class TieuHoc2{
    HocSinh2 hocsinh=new HocSinh2(){
      @Override
      void setKhoiLop(){
          khoiLop="1 2 3 4 5";
      }
      @Override
      void getKhoiLop(){
          System.out.println("Khoi lop tieu hoc: "+khoiLop);
      }
    };
}
public class Anonymous_Class {
    public static void main(String[] args) {
        TieuHoc2 tieuhoc=new TieuHoc2();
        tieuhoc.hocsinh.setKhoiLop();
        tieuhoc.hocsinh.getKhoiLop();
    }
}
//Anonymous Inner Class:
//- Là một class không có tên, được định nghĩa trong 1 method của 1 class xác định. 
//Nó chỉ được dùng 1 lần tại nơi mà nó đã được định nghĩa ra
//- nên sử dụng loại Inner Class này khi bạn muốn ghi đè phương thức của lớp hoặc Interface.
//- Một Anonymous Inner Class có thể được tạo theo hai cách, 
//đó là sử dụng các lớp (abstract hoặc concrete) hoặc các Interface