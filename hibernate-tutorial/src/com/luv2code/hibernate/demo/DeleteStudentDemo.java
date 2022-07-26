package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {

			/*
			session.beginTransaction();
			
			int studentId = 1;
			
			
			Student student = session.get(Student.class, studentId);
			System.out.println(student);
			session.delete(student);
			session.getTransaction().commit();
			*/

			/*
			session.beginTransaction();
			session.createQuery("delete from Student where id=2").executeUpdate();			
			session.getTransaction().commit();
			*/
			int studentId = 3;
			session.beginTransaction();
			session.createQuery("delete from Student where id=:id").setParameter("id", studentId).executeUpdate();			
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}
	}

}
