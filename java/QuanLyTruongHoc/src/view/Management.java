/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import model.Person;
import model.Student;
import model.Teacher;

/**
 *
 * @author lnmin
 */
public class Management {
    static List<Student> listStudents = new ArrayList<>();
    static List<Teacher> listTeachers = new ArrayList<>();
    
    static <E extends Person> void printList(List<E> list){
        System.out.println("List of Person");
        for (E e : list) {
            System.out.println(e.toString());
        }
    }
    static <E extends Person> void inputList(E e){
        System.out.println("Begin Input Infor :");
        if( e instanceof Student){
            e.inputInfo();
            listStudents.add((Student) e);
        }else if(e instanceof Teacher){
            e.inputInfo();
            listTeachers.add((Teacher) e);
        }
       
     
    }
    
    
    public static void main(String[] args) {
        
    }
    
}
