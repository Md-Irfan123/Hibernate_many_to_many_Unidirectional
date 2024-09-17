package com.jpa.Hibernate_Many_To_Many_Unidirectional.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jpa.Hibernate_Many_To_Many_Unidirectional.dto.Bank;
import com.jpa.Hibernate_Many_To_Many_Unidirectional.dto.User;

public class UserBankDao {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public List<User> saveUserBankDao(List<User> users,List<Bank> banks){
		et.begin();
//		for (Bank bank : banks) {
//			em.persist(bank);
//			
//		}
		for (User user : users) {
			em.persist(user);
			
		}
		
		et.commit();
		return users;
		
		
	}
	public  User deleteUserByIdDao(int userId) {
		User user=em.find(User.class, userId);
		if(user!=null) {
			et.begin();
			em.remove(user);
			et.commit();
			return user;
		}else {
			return null;
		}
		
	}
	public List<User> getAllUserAndBankDao()
	{
		String selectQuery="select u  From User u";
		Query query=em.createQuery(selectQuery);
		return query.getResultList();
	}
	public User getAllBankByUserId(int userId) {
		return em.find(User.class,userId);
	}

}
