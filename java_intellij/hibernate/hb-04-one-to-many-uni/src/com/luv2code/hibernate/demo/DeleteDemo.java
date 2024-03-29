package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
//          create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
//          create session
        Session session = factory.getCurrentSession();

        try {


//            start a transaction
            session.beginTransaction();
//          get instructor by primary key / id
            int  theId = 2;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println("Found Instructor: "+ tempInstructor);

            if(tempInstructor !=null){
                System.out.println("Delecting: " );

                session.delete(tempInstructor);
            }

//            commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }

}
