package com.oy.bookmark.dao.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainJPA {

	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("bookmark");
		EntityManager em=emf.createEntityManager();
		EntityTransaction transac=em.getTransaction();
		transac.begin();
		User user=new User();
		user.setUsername("ouerdia");
		user.setEmail("ouerdiayk@yahoo.fr");
		user.setPassword("doudou");
		user.setValid(true);
		em.persist(user);
		transac.commit();
		em.close();
		emf.close();
		
		

	}

}
