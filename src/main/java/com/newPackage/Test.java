package com.newPackage;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {
			
		 Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		 SessionFactory sf = cfg.buildSessionFactory();
		 Session session = sf.openSession();
		
			 session.beginTransaction();
	         List<User> list = session.createQuery("from User").list();
	        Iterator<User> iterator = list.iterator();
	        int i=0;
	        while(list.size()>i){
	        	i++;
	            User user = (User) iterator.next(); 
	            System.out.print(user.getUserId()+") "+"Name of the user : " + user.getUsername()+" "); 
	            System.out.print(user.getUserId()+") "+"Created By : " + user.getCreatedBy()+" "); 
	            System.out.println(user.getUserId()+") "+"Date of Creation : " + user.getCreatedDate()+" "); 
	        }
	        session.getTransaction().commit();
		
	    }
	
		public static Session insert(Session session,int userId,String name,String createdBy) {
			User user = new User();
	        user.setUserId(userId);
	        user.setUsername(name);
	        user.setCreatedBy(createdBy);
	        user.setCreatedDate(new Date());
	        session.save(user);
			return session; 
		}
		
		public static Session delete(Session session,int id) {
	        User user = new User();
	        user.setUserId(id);
	        session.delete(user);
			return session;
		}
		
		public static Session update(Session session,int id,String name,String createdBy) {
			User user= new User();
			user.setUserId(id);
			user.setUsername(name);
			user.setCreatedBy(createdBy);
			user.setCreatedDate(new Date());
			session.update(user);
			return session;
		}
}


