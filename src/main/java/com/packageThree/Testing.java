package com.packageThree;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Testing {

	public static void main(String args[])
	{
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
		
		@SuppressWarnings("deprecation")
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session=addCustomerToMerchantInOneToMany(session,112, "Ravi",45);
		/*
		 * Customer customerOne = new Customer(101, "Viswa"); Customer customerTwo = new
		 * Customer(102, "Mahesh"); Customer customerThree = new Customer(103, "Ramu");
		 * 
		 * Set<Customer> set = new HashSet<Customer>(); set.add(customerOne);
		 * set.add(customerTwo); set.add(customerThree); Merchant merchant = new
		 * Merchant(45, "India"); merchant.setChildren(set); session.save(merchant);
		 */
		
		session.getTransaction().commit();
        System.out.println("Done");
		           
	}
	
	public static Session addCustomerToMerchantInOneToMany(Session session,int customerId,String customerName,int merchId) {
		/*
		 * List<Merchant> list = session.createQuery("from Merchant").list();
		 * Iterator<Merchant> iterator = list.iterator(); Customer customer = new
		 * Customer(customerId,customerName);
		 * 
		 * Merchant merchant=iterator.next();
		 */
		 
		Query query = session.createQuery("from Merchant where merchid=:ID_OfMerchant").setParameter("ID_OfMerchant", merchId);
		Merchant merchant = (Merchant) query.list().iterator().next();

		
		 Customer customer = new Customer(customerId,customerName);
		 Set<Customer> customerObj = merchant.getChildren();
		 customerObj.add(customer);
		 merchant.setChildren(customerObj);
		 		 
		 session.update(merchant); 
		 return session;
	}
																				
	public static Session deleteMerchant(Session session,int merchantId) {
		Query query =session.createQuery("from Merchant where merchid=:ID_OfMerchant").setParameter("ID_OfMerchant", merchantId);
		Merchant merchant = (Merchant) query.list().iterator().next();
		session.delete(merchant);
		return session;
	}
	
	public static Session updateCustomer(Session session,int customerId,String customerName,int merchId) {
		
		Query query = session.createQuery("from Customer where custid = :customerID").setParameter("customerID", merchId);
		Customer customer = (Customer)query.list().iterator().next();
		customer.setCustomerName(customerName);
         session.update(customer);
		return session;
	}
}