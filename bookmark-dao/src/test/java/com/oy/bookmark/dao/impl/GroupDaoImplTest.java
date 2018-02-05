package com.oy.bookmark.dao.impl;

import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.oy.bookmark.dao.model.Group;
import com.oy.bookmark.dao.model.User;

public class GroupDaoImplTest {
	private GroupDaoImpl groupDaoImpl = new GroupDaoImpl();
	private EntityTransaction transact;
	private Group groupTest;

	@Before
	public void before() {
		transact = groupDaoImpl.getEm().getTransaction();
		transact.begin();
		groupTest = groupDaoImpl.creerGroup(new Group("Etudiant"));

	}

	@Test
	public void test_createGroup_should_return_group() {
		// GIVEN
		String name = "Etudiant";
		// WHEN
		Group group = groupDaoImpl.creerGroup(new Group(name));
		// THEN
		Assert.assertNotNull(group);
		Assert.assertNotNull(group.getIdGroup());
		Assert.assertEquals("Etudiant", group.getName());
	}

	@Test
	public void test_findGroup_should_return_group() {
		// GIVEN
		Integer idGroup = groupTest.getIdGroup();
		// WHEN
		Group group = groupDaoImpl.findGroup(idGroup);
		// THEN
		Assert.assertNotNull(group);
	}

	@Test
	public void test_findGroup_should_return_null() {
		// GIVEN
		Integer idGroup = 1000;
		// WHEN
		Group group = groupDaoImpl.findGroup(idGroup);
		// THEN
		Assert.assertNull(group);
	}

	@Test
	public void test_AjouterUserGroup_should_return_group() {
		// GIVEN
		User user = new User("hhh", "aaa", "nnn", true);
		User user1 = new User("hhhhh", "aaaaa", "nnnnn", true);

		// WHEN
		Group group = groupDaoImpl.AjouterUserGroup(user, groupTest);
		group = groupDaoImpl.AjouterUserGroup(user1, groupTest);
		// THEN
		Assert.assertNotNull(group);
		Assert.assertNotNull(group.getIdGroup());
		Assert.assertNotNull(group.getUsers());
		Assert.assertEquals("hhh", user.getUsername());
		Assert.assertEquals("aaa", user.getEmail());
		Assert.assertEquals("nnn", user.getPassword());
		Assert.assertEquals(true, user.getValid());
		Assert.assertEquals("hhhhh", user1.getUsername());
		Assert.assertEquals("aaaaa", user1.getEmail());
		Assert.assertEquals("nnnnn", user1.getPassword());
		Assert.assertEquals(true, user1.getValid());
	}

	@Test
	public void test_modifierGroup_should_modify_group_name() {
		// GIVEN
		String name = "enseignant";
		groupTest.setName(name);
		// WHEN
		Group group = groupDaoImpl.modifierGroup(groupTest);
		// THEN
		Assert.assertNotNull(group);
		Assert.assertNotNull(group.getIdGroup());
		Assert.assertEquals("enseignant", group.getName());
	}

	@Test
	public void test_supprimerGroup_should_return_null() {

		// GIVEN
		Integer idGroup = groupTest.getIdGroup();

		// WHEN
		groupDaoImpl.supprimerGroup(idGroup);

		// THEN
		Group group = groupDaoImpl.findGroup(idGroup);
		Assert.assertNull(group);

	}

	@After
	public void after() {
		transact.rollback();
	}

}
