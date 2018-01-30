package com.oy.bookmark.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dao {
	protected EntityManager em;
	public Dao() {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("bookmark");
		 em=emf.createEntityManager();
	}
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	

}
