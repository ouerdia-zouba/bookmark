package com.oy.bookmark.dao.impl;

import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.oy.bookmark.dao.model.Bookmark;
import com.oy.bookmark.dao.model.Group;

@Ignore
public class BookmarkDaoImplTest {
	private EntityTransaction transac;
	private BookmarkDaoImpl bookmarkDaoImpl = new BookmarkDaoImpl();
	private Bookmark bookmarkTest;
	private GroupDaoImpl groupDaoImpl = new GroupDaoImpl();

	@Before
	public void before() {
		transac = groupDaoImpl.getEm().getTransaction();
		transac.begin();
		Group group = groupDaoImpl.creerGroup(new Group("Etudiant"));
		bookmarkTest = bookmarkDaoImpl
				.creerBookmark(new Bookmark("sport", "http://www.sports.fr/", "le sport est bon pour la santé", group));

	}

	@Test
	public void test_creerBookmark_should_return_Bookmark() {
		// GIVEN
		String name = "cinema";
		String comment = "film XMAN";
		Group group = groupDaoImpl.creerGroup(new Group("Enseignant"));
		String url = "www.xman.fr";
		// WHEN
		Bookmark bookmark = bookmarkDaoImpl.creerBookmark(new Bookmark(name, url, comment, group));
		// THEN
		Assert.assertNotNull(bookmark);
		Assert.assertNotNull(bookmark.getIdBookmark());
		Assert.assertNotNull(group.getIdGroup());

	}

	@Test
	public void test_modifierBookmark_should_modify_name() {

		// GIVEN
		String name = "arbre";
		bookmarkTest.setName(name);
		// WHEN

		Bookmark bookmark = bookmarkDaoImpl.modifierBookmark(bookmarkTest);

		// THEN
		Assert.assertNotNull(bookmark);
		// Assert.assertNotNull(bookmark.getIdBookmark());
		// Assert.assertEquals("arbre", bookmark.getName());

	}

	@After
	public void after() {
		transac.rollback();

	}

}
