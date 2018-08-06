/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session02_hw;

/**
 *
 * @author lnmin
 */
class Person{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + '}';
    }
    public void soSanh1(Person p){
        if(this.name.equalsIgnoreCase(p.getName())&&this.age== p.age){
            System.out.println("2 đối tượng có nội dung bằng nhau");
        } else {
            System.out.println("2 đối tượng có nội dung khác nhau");
        }
    }
    public void soSanh2(Person p){
        if(this.hashCode()==p.hashCode()){
            System.out.println("2 đối tượng có địa chỉ như nhau");
        }else{
            System.out.println("2 đối tương có địa chỉ khác nhau");
        }
    }
    public void soSanh3(Person p){
        this.soSanh1(p);
        this.soSanh2(p);
    }
}
public class SoSanh {

    public static void main(String[] args) {
        Person person1=new Person("Minh", 23);
        Person person2=new Person("Minh", 18);
        Person person3=new Person("Minh", 23);
        Person person4= person3;
        person1.soSanh1(person2);
        person1.soSanh2(person2);
        person1.soSanh3(person2);
        System.out.println("=======================");
        person1.soSanh1(person3);
        person1.soSanh2(person3);
        person1.soSanh3(person3);
        System.out.println("=======================");
        
        person3.soSanh1(person4);
        person3.soSanh2(person4);
        person3.soSanh3(person4);
        System.out.println("=======================");
        
        
                
        
    }
}
