package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
//          create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory();
//          create session
        Session session = factory.getCurrentSession();

        try {
            List<Student> students;
//            start a transaction
            session.beginTransaction();
//            save the student
            System.out.println("Retrive list student...");
            students = session.createQuery("from Student").getResultList();
            displayStudents(students);


//            student with last name is doe
            System.out.println("\nRetrive students with last name is duck...");
            students = session.createQuery("from Student s where s.lastName ='duck'").getResultList();
//            commit transaction
            displayStudents(students);

//            query students: lastName="Doe" or firstName='Daffy'
            System.out.println("\nRetrive students with last name is Doe or fisrt name is Daffy...");
            students = session.createQuery("from Student s where s.lastName ='Doe' OR s.firstName='Daffy'")
                    .getResultList();
            displayStudents(students);

//            query students: email like "%luv2code.com"
            System.out.println("\nRetrive students with email end with luv2code.com...");
            students=session.createQuery("from Student s where s.email LIKE '%gmail.com%'").getResultList();
            displayStudents(students);

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.toString());
            ;
        }
    }

}
