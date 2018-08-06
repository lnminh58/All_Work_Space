/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session02_hw;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * @author lnmin
 */

class Class1{
 private String name;
 public void display(){
     System.out.println(this.name);
 }
}
class Class2{
    static void getField(){
        Field[] fields = Class1.class.getDeclaredFields();
        System.out.println("Tên các thuộc tính ở class 1");
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }
    static void getMethod(){
        Method[] methods = Class1.class.getMethods();
        System.out.println("Tên các phương thức ở class 1");
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
    static void setField() throws InstantiationException, IllegalAccessException{
        Class1 obj1 = new Class1();
        Class<?> myClass = obj1.getClass();
        Class1 obj2 = (Class1) myClass.newInstance();
        Field[] declaredFields = Class1.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
           declaredField.setAccessible(true);
           if(declaredField.getName().equals("name")){
               declaredField.set(obj2,"MINH");
           }
        }
        System.out.println("Sau khi thay đổi các giá trị");
        obj2.display();
    }
    public static void main(String[] args) {
        // getField();
//         getMethod();
        try {
           setField();
        } catch (InstantiationException | IllegalAccessException ex) {
        }
    }
}

public class ThucHanhField {
   
    
}
