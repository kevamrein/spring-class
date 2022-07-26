package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Student student1 = new Student("Kevin", "Amrein", "kevin@demo.com");
			Student student2 = new Student("John", "Amrein", "john@demo.com");
			Student student3 = new Student("Paul", "Amrein", "paul@demo.com");

			session.beginTransaction();
			
			session.save(student1);
			session.save(student2);
			session.save(student3);

			System.out.println("Saved!");
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			session.close();
		}
	}
}
