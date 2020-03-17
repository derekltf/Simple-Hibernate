package com.dlcreation.test.hibernat;

import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dlcreation.test.hibernate.entity.Student;

public class JdbcTest {

	public static void main(String[] args) {
//		String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
//		String user = "hbstudent";
//		String pass = "hbstudent";
		System.out.println("Start!");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			Student s = new Student("Peter", "Ho", "peter123@gmail.com");
			session.beginTransaction();
			session.save(s);
			session.getTransaction().commit();
//			Connection myConn = DriverManager.getConnection(url, user, pass);
			System.out.println("Succ!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
