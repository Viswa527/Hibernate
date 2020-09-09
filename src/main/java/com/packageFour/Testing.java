package com.packageFour;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Testing {

	@SuppressWarnings("deprecation")
	public static void main(String args[])
	{
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();		
		
		 session.beginTransaction();
		 session = addCustomerToMerchantMO(session, 503, "Karthik");
	     session.getTransaction().commit();
		 System.out.println("Many-To-One Mapping is Done.....!");
	}
	
	@SuppressWarnings("unchecked")
	public static Session addCustomerToMerchantMO(Session session,int customerId,String customerName) {
		List<Customer> list = session.createQuery("from Customer").list();
		 Iterator<Customer> iterator = list.iterator();
		 Customer customer =iterator.next();
		 Merchant merchant = customer.getParentObjects();
		 System.out.println(merchant.getMerchantId());
		 Customer customers = new Customer(customerId,customerName);
		 customers.setParentObjects(merchant);
		 session.save(customers);
		 session.update(customers); 
		 return session;
		
	}
	public static void mappingManyToOne() {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();		
		
		Merchant merchant =new Merchant();
		merchant.setMerchantId(111);
		merchant.setMerchantName("Google"); 
		
		 Customer customerOne=new Customer(504,"Viswa");
		 customerOne.setParentObjects(merchant);
		             
		 Customer customerTwo=new Customer(505,"Mahesh");
		 customerTwo.setParentObjects(merchant);
		             
         Customer customerThree=new Customer(506,"Raghu");         
         customerThree.setParentObjects(merchant);           		             
		             
		 session.beginTransaction();
		 
		 session.save(customerOne);
		 session.save(customerTwo);
		 session.save(customerThree);
		 
	     session.getTransaction().commit();
	}
}
