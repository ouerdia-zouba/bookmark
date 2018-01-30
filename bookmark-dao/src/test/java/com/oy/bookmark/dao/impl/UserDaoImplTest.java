package com.oy.bookmark.dao.impl;

import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.oy.bookmark.dao.model.User;


public class UserDaoImplTest {
	
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	private EntityTransaction transac;
	User userTest;
	
	@Before //Cette méthode va être lancée avant chaque méthode de test
	public void before(){
		transac=userDaoImpl.getEm().getTransaction();
		transac.begin();
		userTest =userDaoImpl.createUser(new User("kamel zouba","kamel.zouba@gmail.com","pass1234",true));
	}
	
	@Test
	public void test_authentificationUser_should_return_user() {
		//GIVEN
		String email ="kamel.zouba@gmail.com";
		String password ="pass1234";
		
		//WHEN
		User user = userDaoImpl.authentificationUser(email, password);
		
		//THEN
		Assert.assertNotNull(user);
		Assert.assertEquals("kamel zouba", user.getUsername());
		Assert.assertEquals("kamel.zouba@gmail.com", user.getEmail());
		Assert.assertEquals("pass1234", user.getPassword());	
	}
	
	@Test
	public void test_authentificationUser_should_return_null_case_email_invalid() {
		//GIVEN
		String email ="kamelzouba@gmail.com";
		String password ="pass1234";
		
		//WHEN
		User user = userDaoImpl.authentificationUser(email, password);
		
		//THEN
		Assert.assertNull(user);	
	}
	@Test
	public void test_authentificationUser_should_return_null_case_password_invalid() {
		//GIVEN
		String email="kamel.zouba@gmail.com";
		String password="passe1234";
		//WHEN
		User user =userDaoImpl.authentificationUser(email, password);
		//THEN
		Assert.assertNull(user);
	}
	@Test
	public void test_createUser_should_return_user(){
		//GIVEN
		String username="kamel zouba";
		String email="ouerdiayk@yaoo.fr";
		String password="doudou";
		Boolean valid=true;
		//WHEN
		 User user=userDaoImpl.createUser(new User(username, email, password, valid));
		 
		//THEN
		 Assert.assertNotNull(user);
		 Assert.assertNotNull(user.getIdUser());
		 Assert.assertEquals("kamel zouba", user.getUsername());
		 Assert.assertEquals("ouerdiayk@yaoo.fr", user.getEmail());
		 Assert.assertEquals("doudou", user.getPassword());
		 Assert.assertEquals(true, user.getValid());
	
	}
	@Test
	public void test_modifierUser_should_modify_user_username(){
		
	
	//GIVEN
	String username="ouerdia zouba";
	//String password="password";
	//WHEN
	userTest.setUsername(username);
	//userTest.setPassword(password);
	User user=userDaoImpl.modifierUser(userTest);
	
	//THEN
	 Assert.assertNotNull(user);
	 Assert.assertNotNull(user.getIdUser());
	 Assert.assertEquals("ouerdia zouba", user.getUsername());
	 Assert.assertEquals("kamel.zouba@gmail.com", user.getEmail());
	 Assert.assertEquals("pass1234", user.getPassword());
	 Assert.assertEquals(true, user.getValid());
	
	}
	@Test
	public void test_modifierUser_should_modify_user_password(){
		
	
	//GIVEN
	
	String password="password";
	//WHEN
	userTest.setPassword(password);
	
	User user=userDaoImpl.modifierUser(userTest);
	
	//THEN
	 Assert.assertNotNull(user);
	 Assert.assertNotNull(user.getIdUser());
	 Assert.assertEquals("kamel zouba", user.getUsername());
	 Assert.assertEquals("kamel.zouba@gmail.com", user.getEmail());
	 Assert.assertEquals("password", user.getPassword());
	 Assert.assertEquals(true, user.getValid());
	
	}
	
	@After //Cette méthode va être lancée après chaque méthode de test
	public void after(){
		transac.rollback();
	}

}
