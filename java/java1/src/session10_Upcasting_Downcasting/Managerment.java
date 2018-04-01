/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session10_Upcasting_Downcasting;

/**
 *
 * @author nguyenducthao
 */
public class Managerment {

    public static void main(String[] args) {
        Student student = new Student();
        Person person = new Person();
        person = student;//upcasting ngầm định
        person.display();

        Person person1 = new Student();//upcasting tường minh
//        Person person1=(Person)student;//upcasting tường minh
        person1.display();

        Person person2 = new Student();
        Student student1 = (Student) person2; //downcasting
        student1.displayMarks();

//        displayMarks() là phương thức chỉ có ở lớp Student.
//        Tuy nhiên, thông qua downcast ta hoàn toàn có thể gọi ra phương thức đó
//        thông qua đối tượng person2 mà không cần new Person
//        bằng việc downcast đối tượng person2 có kiểu Student
//        mà không xảy ra vấn đề trong quá trình biên dịch và runtime.
    }
}
