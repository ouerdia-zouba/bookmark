package com.oy.bookmark.dao.impl;

import java.util.List;

import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.oy.bookmark.dao.model.User;


public class UserDaoImplTest {
	
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	private EntityTransaction transac;
	private User userTest;

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
		userTest.setUsername(username);
		//WHEN


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
		userTest.setPassword(password);
		//WHEN


		User user=userDaoImpl.modifierUser(userTest);

		//THEN
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.getIdUser());
		Assert.assertEquals("kamel zouba", user.getUsername());
		Assert.assertEquals("kamel.zouba@gmail.com", user.getEmail());
		Assert.assertEquals("password", user.getPassword());
		Assert.assertEquals(true, user.getValid());

	}
	@Test
	public void test_findUser_should_return_user(){
		//GIVEN
		Integer idUser=userTest.getIdUser();
		//WHEN
		User user=userDaoImpl.findUser(idUser);
		//THEN
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.getIdUser());
		Assert.assertEquals("kamel zouba", user.getUsername());
		Assert.assertEquals("kamel.zouba@gmail.com", user.getEmail());
		Assert.assertEquals("pass1234", user.getPassword());
		Assert.assertEquals(true, user.getValid());


	}
	@Test
	public void test_findUser_should_return_user_null(){
		//GIVEN
		Integer idUser=9999;
		
		//WHEN
		User user=userDaoImpl.findUser(idUser);
		//THEN
		Assert.assertNull(user);
		//Assert.assertNull(user.getIdUser());

	}
	@Test 
	public void test_checkEmailUser_should_return_user(){
		//GIVEN
		String email="kamel.zouba@gmail.com";
		//WHEN
		User user=userDaoImpl.checkEmailUser(email);
		//THEN
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.getIdUser());
		Assert.assertEquals("kamel zouba", user.getUsername());
		Assert.assertEquals("kamel.zouba@gmail.com", user.getEmail());
		Assert.assertEquals("pass1234", user.getPassword());
		Assert.assertEquals(true, user.getValid());
	}
	@Test
	public void test_checkEmailUser_should_return_null(){
		//GIVEN
		String email="doudou@yahoo.fr";
		//WHEN
		User user=userDaoImpl.checkEmailUser(email);
		//THEN
		Assert.assertNull(user);
		
	}
	@Test
	public void test_supprimerUser_should_remove_user(){
		//GIVEN
		Integer idUser=userTest.getIdUser();
		//WHEN
		userDaoImpl.supprimerUser(idUser);
		
		//THEN
		User user=userDaoImpl.findUser(idUser);
		Assert.assertNull(user);
	}
	@Test
	public void test_searchUser_should_return_null() {
		//GIVEN
		String pattern_email ="sam";

		List<User> users =userDaoImpl.searchUser(pattern_email);

		//THEN
		Assert.assertTrue(users.isEmpty());
		
		for (User user : users) {
			Assert.assertFalse( user.getEmail().contains(pattern_email));
		}
	}
	@Test
	public void test_searchUser_should_return_users() {
		//GIVEN
		String pattern_email ="kam";

		List<User> users =userDaoImpl.searchUser(pattern_email);

		//THEN
		Assert.assertFalse(users.isEmpty());
		//Assert.assertTrue(((User) users.get(0)).getEmail().contains(pattern_email));
		for (User user : users) {
			Assert.assertTrue( user.getEmail().contains(pattern_email));
		}
	}
	
	@Test
	public void test_searchUser_should_return_empty_List() {
		//GIVEN
		String pattern_email ="jkyiçkojçkèoço";

		List<User> users =userDaoImpl.searchUser(pattern_email);

		//THEN
		Assert.assertTrue(users.isEmpty());
	}

	@After //Cette method va être lancée après chaque méthode de test
	public void after(){
		transac.rollback();
	}

}
