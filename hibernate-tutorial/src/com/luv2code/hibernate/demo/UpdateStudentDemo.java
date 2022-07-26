package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {

			session.beginTransaction();
			int studentId = 1;
			Student student = session.get(Student.class, studentId);
			student.setFirstName("Tim");
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			session.createQuery("update Student s set email='foo@gmail.com'")
			.executeUpdate();
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}
	}

}
