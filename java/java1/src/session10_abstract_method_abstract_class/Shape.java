/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session10_abstract_method_abstract_class;

/**
 *
 * @author nguyenducthao
 */
abstract class Shape{
    private final float PI=3.14f;
    public float getPI(){
        return PI;
    }
    abstract void calculate(float val);
}
//public class abstract_method_abstract_class {
//    
//   
//}



//1. Interface (Khác với GUI - Giao diện người dùng, nhiều người nhầm lẫn cái này!)
//- Interface được xây dựng để chứa các hằng, các methods dùng chung cho các class. 
//Các methods dùng trong Interface phải là trừu tượng (adstract). 
//Methods trừu tượng là các methods chỉ có phần header, không có phần body.
//- Mặc định các biến và mothods khai báo trong Interface là public và abstract
//2. Methods abstract (trừu tượng) là các methods chỉ có phần header, không có phần body
//Lưu ý:
//* Các phương thức được khai báo dùng các tiền tố private và static
//    thì không được khai báo là trừu tượng abstract. 
//    Tiền tố private thì không thể truy xuất từ các lớp dẫn xuất, 
//    còn tiền tố static thì chỉ dùng riêng cho lớp khai báo mà thôi.
//* Phương thức trong abstract class có 2 cách để khai báo:
//- Khai báo bình thường như class
//- Khai báo giống như interface nhưng phải có thêm từ khóa abstract
//3. abstract class
//- Là class có chứa các abstract methods 
//- Các methods trong abstract class phải khai báo với từ khóa abstract
//(không giống như interface vì interface mặc định gán abstract cho các methods)
//- Bất cứ class nào kết thừa abstract class nào đó phải định nghĩa lại
//các abstract methods của lớp mà nó thừa kế
//hoặc không định nghĩa lại nhưng phải ghi lại abstract methods đó.
//- Một abstract class có thể chứa cả abstract methods và các methods thường.
//- Khi một class có chứa abstract method thì bắt buộc phải có từ khóa abstract đằng trước tên class đó.
//- Không thể khởi tạo 1 đối tượng trực tiếp từ một class trừu tượng.
