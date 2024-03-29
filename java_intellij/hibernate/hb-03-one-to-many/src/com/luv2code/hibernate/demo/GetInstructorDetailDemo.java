package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {
    public static void main(String[] args) {
//          create session factory
        try( SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
//          create session
        Session session = factory.getCurrentSession())

        {


//            start a transaction
            session.beginTransaction();

//            Get the instructor detail object
            int theId = 25;
            InstructorDetail tempInstructorDetail= session.get(InstructorDetail.class,theId);

//            print the instuctor detail
            System.out.println("tempInstructorDetail: "+ tempInstructorDetail);
//            print the associated instructor
            System.out.println("the associated instructor: "+ tempInstructorDetail.getInstructor());
//            commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } catch (Exception e ){
            e.printStackTrace();
        }
    }

}
