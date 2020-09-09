package com.packageFive;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Testing {

	public static void main(String args[])
	{
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml"); 
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();		
		
		Student studentOne=new Student();
		studentOne.setStudentId(527);
		studentOne.setStudentName("Viswa");
		studentOne.setMarks(98);
		
		Student studentTwo=new Student();
		studentTwo.setStudentId(548);
		studentTwo.setStudentName("Mahesh");
		studentTwo.setMarks(99);
		
		Course courseOne=new Course();
		courseOne.setCourseId(500);
		courseOne.setCourseName("Hibernate");
		courseOne.setDuration(7);
		
		Course courseTwo=new Course();
		courseTwo.setCourseId(501);
		courseTwo.setCourseName("Java");
		courseTwo.setDuration(30);
		
		Set set =new HashSet();
		set.add(courseOne);
		set.add(courseTwo);
		
		studentOne.setCourses(set);
		studentTwo.setCourses(set);
		
		
		session.beginTransaction();
		session.save(studentOne);
		session.save(studentTwo);                 
		session.getTransaction().commit();
		    
		    System.out.println("Many To Many is Done..!!");
	}
}
