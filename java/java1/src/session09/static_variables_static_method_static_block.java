/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session09;

import static javafx.scene.input.KeyCode.I;

/**
 *
 * @author nguyenducthao
 */
public class static_variables_static_method_static_block {

    public static int staticCounter = 0;
// Declare and initialize instance variable
    int instanceCounter = 0;

    /**
     * static block
     *
     */
    static {
        System.out.println("I am a static block");
    }

    public static void staticMethod() {
        System.out.println("I am a static method");
    }

    public void displayCount() {
//Increment the static and instance variable
        staticCounter++;
        instanceCounter++;
// Print the value of static and instance variable
        System.out.println("Static counter is:" + staticCounter);
        System.out.println("Instance counter is:" + instanceCounter);
    }

    public static void main(String[] args) {
        System.out.println("I am the main method");
// Invoke the static method using the class name
        static_variables_static_method_static_block.staticMethod();
// Create first instance of the class
        static_variables_static_method_static_block objStatic1 = new static_variables_static_method_static_block();
        objStatic1.displayCount();
// Create second instance of the class
        static_variables_static_method_static_block objStatic2 = new static_variables_static_method_static_block();
        objStatic2.displayCount();
// Create third instance of the class
        static_variables_static_method_static_block objStatic3 = new static_variables_static_method_static_block();
        objStatic3.displayCount();
    }
}

//static method: Nếu áp dụng từ khóa static với bất cứ phương thức nào, 
//thì phương thức đó được gọi là phương thức static.
//Một phương thức static thuộc lớp chứ không phải đối tượng của lớp.
//Một phương thức static có thể được triệu hồi mà không cần tạo một instance của một lớp.
//Phương thức static có thể truy cập thành viên dữ liệu static và có thể thay đổi giá trị của nó.
//Một số hạn chế cho phương thức static
//Có hai hạn chế chính cho phương thức static. Đó là:
//Phương thức static không thể sử dụng thành viên dữ liệu non-static hoặc gọi trực tiếp phương thức non-static.
//Từ khóa this và super không thể được sử dụng trong ngữ cảnh static.
//static block: Được sử dụng để khởi tạo thành viên dữ liệu static.
//Nó được thực thi trước phương thức main tại thời gian tải lớp
