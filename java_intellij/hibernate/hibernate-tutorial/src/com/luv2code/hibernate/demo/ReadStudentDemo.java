package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
//          create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory();
//          create session
        Session session = factory.getCurrentSession();

        try{
//          create a student object
            System.out.println("Create new student");
            Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com ");
//            start a transaction
            session.beginTransaction();
//            save the student
            System.out.println("Saving student...");
            System.out.println(tempStudent);
            session.save(tempStudent);
//            commit transac tion
            session.getTransaction().commit();

            System.out.println("Save student. Generate id: " + tempStudent.getId());

//            get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();
//            retrieve student based on the id: primary key
            System.out.println("Getting student with id: "+tempStudent.getId());

            Student myStudent = (Student) session.get(Student.class, tempStudent.getId());
            System.out.println(Student.class);
            System.out.println("Get complete: "+myStudent);
//            commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }finally {
            factory.close();
        }
    }

}