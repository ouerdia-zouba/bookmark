package com.oy.bookmark.dao.impl;

import com.oy.bookmark.dao.BookmarkDao;
import com.oy.bookmark.dao.model.Bookmark;

public class BookmarkDaoImpl extends Dao implements BookmarkDao {

	public BookmarkDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public Bookmark creerBookmark(Bookmark bookmark) {
		em.persist(bookmark);
		return bookmark;
	}

	public Bookmark modifierBookmark(Bookmark bookmark) {
		Bookmark bookmarkDB = em.find(Bookmark.class, bookmark.getIdBookmark());
		bookmarkDB.setName(bookmark.getName());
		return bookmarkDB;

	}

	public void supprimerBookmark(Integer idBookmark) {
		Bookmark bookmark = em.find(Bookmark.class, idBookmark);
		em.remove(bookmark);

	}

	public Bookmark findBookmark(Integer idBookmark) {
		Bookmark bookmark = em.find(Bookmark.class, idBookmark);
		return bookmark;
	}

}
