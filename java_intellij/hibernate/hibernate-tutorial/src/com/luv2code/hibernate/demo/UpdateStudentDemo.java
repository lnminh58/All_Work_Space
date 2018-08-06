package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
//          create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory();
//          create session
        Session session = factory.getCurrentSession();

        try{
            int studentId= 1;
            System.out.println("Save student. Generate id: " + studentId);

//            get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();
//            retrieve student based on the id: primary key
            System.out.println("Getting student with id: "+studentId);

            Student myStudent = (Student) session.get(Student.class, studentId);
            System.out.println(Student.class);
            System.out.println("update student:...");
            myStudent.setFirstName("Scooby");

//            commit the transaction
            session.getTransaction().commit();

            // New code
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("update email for all students ");
            int i = session.createQuery("update Student set email='foo@gmail.com' ").executeUpdate();


            session.getTransaction().commit();

            System.out.println("Done!");

        }finally {
            factory.close();
        }
    }

}
