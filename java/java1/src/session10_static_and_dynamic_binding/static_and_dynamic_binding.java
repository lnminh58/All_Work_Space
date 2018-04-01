/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session10_static_and_dynamic_binding;

/**
 *
 * @author nguyenducthao
 */
public class static_and_dynamic_binding {
    
}


//Binding (gắn kết) là kết nối một lời gọi phương thức tới thân phương thức. 
//Có hai kiểu binding là: Static Binding hay early binding//compile-time binding (gắn kết tĩnh) 
//và Dynamic Binding hay late biding/run-time binding (gắn kết động)

//Gắn kết tĩnh (Static Binding):
//Khi kiểu của đối tượng được quyết định tại compile time (bởi Compiler) thì đó là static binding. 
//Nếu có bất cứ phương thức private, final hoặc static nào trong một lớp, thì đó là gắn kết tĩnh. 
//Do đó, không thể có chuyện ghi đè (overloading) kết quả đối với lập trình hướng đối tượng trong Static binding

//gắn kết động (Dynamic Binding):
//Khi kiểu của đối tượng được quyết định tại runtime thì đó là gắn kết động (Dynamic Binding).