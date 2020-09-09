package com.packageTwo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Testing {
	public static void main(String args[]) 
	{

		Configuration configutation = new Configuration().configure("hibernate.cfg.xml"); 
		SessionFactory factory = configutation.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Student student=new Student();
		student.setStudentId(100);
		student.setStudentName("Viswa");

		Address address = new Address();
		address.setAddressId(509);
		address.setCity("Indore");
		address.setState("MP");
		
		address.setS(student);
		
		session.save(address);
		session.getTransaction().commit();
		System.out.println("One to One is Done..!!");

	}
}
