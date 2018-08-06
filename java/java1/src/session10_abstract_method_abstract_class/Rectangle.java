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
class rectangle extends Shape{
    float perimeter;
    float length=10;
    @Override
    void calculate(float width){
        perimeter=2*(length+width);
        System.out.println("Perimeter of the Restangle is: "+perimeter);
    }
}
//public class Rectangle {
//    
//}
