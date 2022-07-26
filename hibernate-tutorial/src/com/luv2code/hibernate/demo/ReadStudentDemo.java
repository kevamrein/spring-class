package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Student student = new Student("ABC", "Amrein", "demo@demo.com");
			
			session.beginTransaction();
			
			session.save(student);
			System.out.println("Saved!");
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			System.out.println("Student id: " + student.getId());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student mystudent = session.get(Student.class, student.getId());
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

}
