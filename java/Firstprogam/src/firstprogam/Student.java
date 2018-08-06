/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstprogam;

/**
 *
 * @author lnmin
 */
public class Student {
    private static int counter =0;
    private int ma;
    private String name;
    
        public Student(String name){
            this.ma=++counter;
            this.name = name;
    
        }
        public Student(){
            this.ma=++counter;
        }

    public int getMa() {
        return ma;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        

    @Override
    public String toString() {
        return "Student{" + "ma=" + ma + ", name=" + name + '}';
    }
        

    }