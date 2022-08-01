package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Instructor instructor = new Instructor("Kevin", "Amrein", "demo2@demo.com");
			InstructorDetail instructorDetail = new InstructorDetail("https://google.com", "hello2"); 
			session.beginTransaction();
			instructor.setInstructorDetail(instructorDetail);
			
			// Cascade.all saving detail too
			session.save(instructor);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
