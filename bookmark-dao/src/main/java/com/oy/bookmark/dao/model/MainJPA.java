package com.oy.bookmark.dao.model;

import java.util.ArrayList;
import java.util.List;

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
		Group group = new Group();
		Group group1 = new Group();
		group.setName("etudiant");
		group1.setName("Enseignant");
		
		
		user.setUsername("ouerdia");
		user.setEmail("ouerdiayk@yahoo.fr");
		user.setPassword("doudou");
		user.setValid(true);
		
		em.persist(group);
		em.persist(group1);
		Group group2 = em.find(Group.class, 1);
		Group group3 = em.find(Group.class, 2);
		List <Group> groups = new  ArrayList<Group>();
		groups.add(group2);
		groups.add(group3);
		user.setGroups(groups);
		em.persist(user);
		transac.commit();
		
		
		em.close();
		emf.close();
		
		

	}

}
