package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Student student = new Student("Kevin", "Amrein", "demo@demo.com");
			
			session.beginTransaction();
			
			session.save(student);
			System.out.println("Saved!");
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			session.close();
		}
	}

}
