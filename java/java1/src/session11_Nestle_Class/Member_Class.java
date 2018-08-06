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
class HocSinh {

    String khoiLop;

    void getHocSinh() {
        System.out.println("Hoc sinh bao gom: Tieu hoc, Trung hoc co so, Trung hoc pho thong");
    }

    class TieuHoc {

        void setKhoiLop() {
            khoiLop = "1 2 3 4 5";
        }

        void getKhoiLop() {
            getHocSinh();
            System.out.println("Cac khoi lop tieu hoc la: " + khoiLop);
        }
    }

    class TrungHocCoSo {

        void setKhoiLop() {
            khoiLop = "6 7 8 9";
        }

        void getKhoiLop() {
            getHocSinh();
            System.out.println("Cac khoi lop trung hoc co so la: " + khoiLop);
        }
    }
}

public class Member_Class {

    public static void main(String[] args) {
//        Tạo 1 đối tượng inner
//        cách 1
        HocSinh.TieuHoc tieuhoc=new HocSinh().new TieuHoc();
//        cách 2
//        HocSinh hocsinh = new HocSinh();
//        HocSinh.TieuHoc tieuhoc = hocsinh.new TieuHoc();
        tieuhoc.setKhoiLop();
        tieuhoc.getKhoiLop();
        HocSinh.TrungHocCoSo trunghoccoso = new HocSinh().new TrungHocCoSo();
        trunghoccoso.setKhoiLop();
        trunghoccoso.getKhoiLop();
    }
}
//Khi xuất hiện Inner Class, Java Compiler tạo hai class file, 
//trong đó tên class file của Inner Class sẽ ở dạng Outer$Inner. 
//Nếu bạn muốn khởi tạo Inner Class, bạn phải tạo sự thể hiện (instance) của Outer Class. 
//Trong trường hợp này, sự thể hiện của Inner Class được tạo bên trong sự thể hiện của Outer Class

//- Member Inner Class: là một lớp được tạo bên trong lớp và bên ngoài phương thức
//Nó là thành viên của lớp ngoài vì thế nó có thể truy cập thuộc tính, thành viên của lớp ngoài.
//- Anonymous Inner Class: là một lớp được tạo để triển khai (kế thừa) Interface hoặc kế thừa lớp.
//Tên của nó được quyết định bởi Compiler.
//- Local Inner Class: Một lớp được tạo bên trong phương thức.
//- Loại static Nested Class: một lớp static được tạo bên trong một lớp.
