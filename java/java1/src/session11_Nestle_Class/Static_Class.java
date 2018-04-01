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
class HocSinh3{
    
    static class TieuHoc3{
        void getKhoiLop(){
            System.out.println("Day la khoi tieu hoc");
        }
    }
}
class HocSinh4{
    static class TieuHoc4{
        static void getKhoiLop(){
            System.out.println("Day la khoi tieu hoc 1, 2, 3, 4, 5");
        }
    }
}
public class Static_Class {
    public static void main(String[] args) {
        HocSinh3.TieuHoc3 tieuhoc=new HocSinh3.TieuHoc3();
        tieuhoc.getKhoiLop();
        HocSinh4.TieuHoc4.getKhoiLop();
    }
    
}
//Khi tạo ra một lớp static bên trong một lớp khác, nghĩa là đang tạo ra cái được gọi một cách phù hợp nhất
//là lớp lồng trong. Một lớp lồng trong được định nghĩa bên trong một lớp khác, nhưng có thể tồn tại bên ngoài 
//một cá thể của lớp bao ngoài. Nếu lớp lồng trong không phải là lớp static, 
//nó chỉ có thể tồn tại bên trong một cá thể của lớp bao ngoài 
//và được gọi một cách phù hợp hơn là lớp bên trong (inner class). 


//- Trong Java, một Static Class được tạo bên trong một lớp thì được gọi là Static Nested Class. 
//Nó có thể truy cập các thành viên dữ liệu và phương thức non-static. 
//Ngoài ra, nó có thể được truy cập bởi tên của Outer Class.
//- Nếu trong Static Class không có phương thức static thì cần phải tạo instance của Static Nested Class
//Nhưng không cần tạo đối tượng của Outer Class bởi vì Nested Class là dạng static và các thuộc tính, 
//phương thức hoặc các lớp cũng có thể được truy cập mà không cần sử dụng đối tượng.
//    Outer.Inner obj = new Outer.Inner();
//- Nếu trong Static Class có phương thức static thì không cần tạo instance của Static Nested Class
//mà vẫn có thể truy cập được các phương thức đó