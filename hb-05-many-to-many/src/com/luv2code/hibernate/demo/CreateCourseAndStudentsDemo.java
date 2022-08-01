package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Course course = new Course("Tennis");
			session.save(course);
			
			Student s1 = new Student("John", "Doe", "john@demo.com");
			Student s2 = new Student("Mary", "Public", "mary@demo.com");
			
			course.addStudent(s1);
			course.addStudent(s2);

			session.save(s1);
			session.save(s2);
		
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
