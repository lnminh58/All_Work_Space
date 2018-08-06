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
class circle extends Shape {

    float area;

    @Override
    void calculate(float rad) {
        area = getPI() * rad * rad;
        System.out.println("Area of circle is: " + area);
    }
}

//public class Circle {
//}
