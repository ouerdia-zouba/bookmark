package com.oy.bookmark.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.oy.bookmark.dao.UserDao;
import com.oy.bookmark.dao.model.Group;
import com.oy.bookmark.dao.model.User;


public class UserDaoImpl extends Dao implements UserDao {

	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
		super();
	}

	public User createUser(User user) {

		em.persist(user);
		return user;
	}

	public User authentificationUser(String email, String password) {

		Query query = em.createQuery("select u from User u where u.email= :mail and u.password=:pw");
		query.setParameter("mail", email);
		query.setParameter("pw", password);
		User user= null;
		if(!query.getResultList().isEmpty()) {
			user = (User) query.getResultList().get(0); 
		}
		return user;
	}

	public void affiherUser() {
		// TODO Auto-generated method stub

	}

	public User modifierUser(User user) {
		//Query query = em.createQuery("select u from User u where u.id_user=:idUser");
		//query.setParameter("idUser", user.getIdUser());
		//user = (User) query.getSingleResult();
		User userDB  = em.find(User.class, user.getIdUser());
		userDB.setUsername(user.getUsername());
		userDB.setPassword(user.getPassword());
		return userDB;
	}

	public void supprimerUser(Integer idUser) {
		// TODO Auto-generated method stub

	}


}
