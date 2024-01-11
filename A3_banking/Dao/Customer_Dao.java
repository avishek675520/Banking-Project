 package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Dto.Customer;

public class Customer_Dao 
{
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("de");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void save(Customer customer)
	{
		
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
		
	}
	public List<Customer> check1(String email) 
	{
//		List<Customer>list=(List<Customer>) entityManager.createQuery("select x from Customer x where Email=?1").setParameter(1, email).getResultList();
		Query query = entityManager.createQuery("select x from Customer x where Email=?1");
		query.setParameter(1, email);
		List<Customer> list = query.getResultList();
		return list;
		
	}
	public List<Customer> check2(long mobile)
	{
		Query query = entityManager.createQuery("select x from Customer x where mob=?1");
		query.setParameter(1, mobile);
		List<Customer> list = query.getResultList();
//		List<Customer>list=(List<Customer>) entityManager.createQuery("select x from Customer x where mob=?1").setParameter(1, mobile).getResultList();
		return list;
	}
	public Customer login(int customerid)
	{
		 Customer customer=entityManager.find(Customer.class, customerid);
		
		return customer;
	}
	public void update(Customer customer_Information) 
	{
		entityTransaction.begin();
		entityManager.merge(customer_Information);
		entityTransaction.commit();		
		
	}
	

}
