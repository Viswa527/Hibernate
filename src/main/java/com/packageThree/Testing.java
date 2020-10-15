package com.packageThree;

import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Testing {

	public static void main(String args[])
	{
		
		Configuration configure = new Configuration();
		configure.configure("hibernate.cfg.xml"); 
		
		@SuppressWarnings("deprecation")
		SessionFactory factory = configure.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session=addCustomerToMerchantInOneToMany(session,786, "ViswaMahi",45);
		session.getTransaction().commit();
        System.out.println("Done");
		           
	}
	
	public static Session addCustomerToMerchantInOneToMany(Session session,int customerId,String customerName,int merchId) {
		 
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
	
	public static Session deleteCustomer(Session session,int customerId) {
		Query query =session.createQuery("from Customer where custid=:ID_OfCustomer").setParameter("ID_OfCustomer", customerId);
		Customer customer = (Customer) query.list().iterator().next();
		session.delete(customer);
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