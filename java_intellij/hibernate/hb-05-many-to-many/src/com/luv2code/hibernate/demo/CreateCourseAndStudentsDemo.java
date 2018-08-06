package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {
    public static void main(String[] args) {
//          create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
//          create session
        Session session = factory.getCurrentSession();

        try {

//            start a transaction
            session.beginTransaction();

            Course course = new Course("Pacman - How To score one Million points");

            System.out.println("Saving the course...");
            session.save(course);
            System.out.println("Saved the course: "+course);

//            create the students
            Student student1 = new Student("John", "Doe", "John@luv2code.com");
            Student student2 = new Student("Mary", "Public", "mary@luv2code.com");

            course.addStudent(student1);
            course.addStudent(student2);

            System.out.println("\nSaving the student...");
            session.save(student1);
            session.save(student2);
            System.out.println("Saved the student: "+course);


            //            commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }

}
