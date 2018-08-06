package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
//          create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory();
//          create session
        Session session = factory.getCurrentSession();

        try{
            int studentId= 1;

//            get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();
//            retrieve student based on the id: primary key
            System.out.println("Getting student with id: "+studentId);

            Student myStudent = (Student) session.get(Student.class, studentId);

            System.out.println("Delete student:...");
            if (myStudent!=null){

            session.delete(myStudent);
            }

//            commit the transaction
            session.getTransaction().commit();

            // New code
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("delete student with id 3");
            int i = session.createQuery("delete from Student where id=3 ").executeUpdate();
            System.out.println(i);

            session.getTransaction().commit();

            System.out.println("Done!");

        }finally {
            factory.close();
        }
    }

}
